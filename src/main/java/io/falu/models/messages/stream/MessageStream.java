package io.falu.models.messages.stream;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.falu.models.core.FaluModel;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * Represents a stream used for sending messages.
 * This is a way to separate messages sent to ensure high deliverable.
 */
@Getter
@SuperBuilder
public class MessageStream extends FaluModel {

    /**
     * The unique identifier for the stream
     */
    private String id;

    /**
     * The name of the stream
     */
    private String name;

    /**
     * Represents the types of streams for messages.
     */
    private String type;

    /**
     * Represents the kind of provider used to send messages in a message stream.
     */
    private String provider;

    /**
     * Time at which the stream was archived. Only populated once a stream is archived.
     */
    private Date archived;

    /**
     * Indicates if the stream is one created by default.
     */
    @JsonProperty("default")
    private boolean defaultStream;
}
