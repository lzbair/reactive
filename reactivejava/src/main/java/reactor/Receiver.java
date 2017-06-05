package reactor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.bus.Event;
import reactor.fn.Consumer;

import java.util.concurrent.CountDownLatch;

@Service
class Receiver implements Consumer<Event<Integer>> {

    @Autowired
    CountDownLatch latch;

    RestTemplate restTemplate = new RestTemplate();

    public void accept(Event<Integer> ev) {
        Quote quote =
                restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
        System.out.println("Quote " + ev.getData() + ": " + quote);
        latch.countDown();
    }

}