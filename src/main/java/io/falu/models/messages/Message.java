package io.falu.models.messages;

import com.google.gson.annotations.JsonAdapter;
import io.falu.client.adapters.ISO8601DateAdapter;
import io.falu.models.core.FaluModel;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * A message record.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class Message extends FaluModel {
    /**
     * Unique identifier for the object.
     */
    private String id;

    /**
     * Destination phone number in E.164 format.
     */
    private String to;

    /**
     * Represents the status of a message.
     */
    private MessageStatus status;

    /**
     * Actual message content sent.
     */
    private String body;

    /**
     * Stream used for the message.
     */
    private String streamId;

    /**
     * Time at which the message was delivered. This is dependent on the underlying provider.
     */
    @JsonAdapter(ISO8601DateAdapter.class)
    private Date delivered;

    /**
     * Represents details about the template to be used for a message.
     */
    private MessageSourceTemplate template;

    /**
     * Provider used for the message.
     */
    private MessageProvider provider;
}
