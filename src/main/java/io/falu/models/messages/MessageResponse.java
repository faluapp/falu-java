package io.falu.models.messages;

import io.falu.models.FaluModel;
import lombok.Getter;

/**
 * Representation of a message request response
 */
@Getter
public class MessageResponse extends FaluModel {

    /**
     * The unique identifiers of the messages that were sent.
     */
    String[] ids;
}
