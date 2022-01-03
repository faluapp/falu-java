package io.falu.models.messages;

import com.google.gson.annotations.SerializedName;

/**
 * The status of a message.
 */
public enum MessageStatus {

    @SerializedName("accepted")
    ACCEPTED,

    @SerializedName("sending")
    SENDING,

    @SerializedName("sent")
    SENT,

    @SerializedName("failed")
    FAILED,

    @SerializedName("delivered")
    DELIVERED
}
