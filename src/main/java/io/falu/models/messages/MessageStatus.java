package io.falu.models.messages;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The status of a message.
 */
public enum MessageStatus {

    @JsonProperty("accepted")
    ACCEPTED,

    @JsonProperty("sending")
    SENDING,

    @JsonProperty("sent")
    SENT,

    @JsonProperty("failed")
    FAILED,

    @JsonProperty("delivered")
    DELIVERED
}
