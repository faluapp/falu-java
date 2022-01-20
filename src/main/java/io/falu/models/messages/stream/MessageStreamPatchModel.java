package io.falu.models.messages.stream;

import io.falu.models.AbstractCreationRequest;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * Represents the details about a message stream that can be patched.Represents the details about a message stream that can be patched.
 */
@Getter
@SuperBuilder
public class MessageStreamPatchModel extends AbstractCreationRequest {
    /**
     * Settings for the stream.
     */
    private MessageStreamSettings settings;
}
