package io.falu.models.messages.stream;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import io.falu.client.adapters.ISO8601DateAdapter;
import io.falu.models.FaluModel;

import java.util.Date;

/**
 * Represents a stream used for sending messages.
 * This is a way to separate messages sent to ensure high deliverable.
 */
public class MessageStream extends FaluModel {
    /**
     * The name of the stream
     */
    private String name;

    /**
     * Represents the types of streams for messages.
     */
    private MessageStreamType type;

    /**
     * Represents the kind of provider used to send messages in a message stream.
     */
    private MessageStreamProviderType provider;

    /**
     * Time at which the stream was archived. Only populated once a stream is archived.
     */
    @JsonAdapter(ISO8601DateAdapter.class)
    private Date archived;

    /**
     * Indicates if the stream is one created by default.
     */
    @SerializedName("default")
    private boolean defaultStream;
}
