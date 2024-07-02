package io.falu.models.messages.stream;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the types of streams for messages.
 */
public enum MessageStreamType {
    @JsonProperty("transactional")
    TRANSACTIONAL,

    @JsonProperty("inbound")
    INBOUND,

    @JsonProperty("broadcasts")
    BROADCASTS
}
