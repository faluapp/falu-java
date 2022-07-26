package io.falu.models.messages;

import io.falu.models.core.FaluModel;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * Representation of a message request response
 */
@Getter
@SuperBuilder
public class MessageResponse extends FaluModel {

    /**
     * The unique identifiers of the messages that were sent.
     */
    String[] ids;
}
