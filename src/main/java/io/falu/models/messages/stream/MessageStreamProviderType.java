package io.falu.models.messages.stream;

import com.google.gson.annotations.SerializedName;

/**
 * Represents the kind of provider used to send messages in a message stream.
 */
public enum MessageStreamProviderType {
    /**
     * Backed by @see <a href="http://www.crossgatesolutions.com/"/>
     */
    @SerializedName("crossgate")
    CROSS_GATE,

    /**
     * Backed by @see <a href="https://mobi4tech.co.ke/"/>
     */
    @SerializedName("mobi4tech")
    MOBI4TECH,

    /**
     * Backed by @see <a href="http://mtechcomm.com/"/>
     */
    @SerializedName("mtech")
    M_TECH
}
