package io.falu.models.messages;

import io.falu.models.core.FaluModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
