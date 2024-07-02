package io.falu.models.messages.stream;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the kind of provider used to send messages in a message stream.
 */
public enum MessageStreamProviderType {
    /**
     * Backed by @see <a href="http://www.crossgatesolutions.com/"/>
     */
    @JsonProperty("crossgate")
    CROSS_GATE,

    /**
     * Backed by @see <a href="https://mobi4tech.co.ke/"/>
     */
    @JsonProperty("mobi4tech")
    MOBI4TECH,

    /**
     * Backed by @see <a href="http://mtechcomm.com/"/>
     */
    @JsonProperty("mtech")
    M_TECH
}
