package io.falu.models.messages.stream;

import com.google.gson.annotations.SerializedName;

/**
 * Represents the types of streams for messages.
 */
public enum MessageStreamType {
    @SerializedName("transactional")
    TRANSACTIONAL,

    @SerializedName("inbound")
    INBOUND,

    @SerializedName("broadcasts")
    BROADCASTS
}
