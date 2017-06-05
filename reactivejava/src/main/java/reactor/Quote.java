package reactor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Quote{


    private final Long id;
    private final String quote;


    public Quote(@JsonProperty("id") Long id, @JsonProperty("quote")String quote) {
        this.id = id;
        this.quote = quote;
    }

    public Long getId() {
        return id;
    }

    public String getQuote() {
        return quote;
    }

}
