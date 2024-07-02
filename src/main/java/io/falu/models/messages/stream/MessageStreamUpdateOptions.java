package io.falu.models.messages.stream;

import io.falu.common.Optional;
import io.falu.models.core.AbstractCreateOptions;
import lombok.Getter;
import lombok.experimental.SuperBuilder;


/**
 * Represents the details about a message stream that can be patched.Represents the details about a message stream that can be patched.
 */
@Getter
@SuperBuilder
public class MessageStreamUpdateOptions extends AbstractCreateOptions {
    /**
     * Settings for the stream.
     */
    private Optional<MessageStreamSettings> settings;
}
