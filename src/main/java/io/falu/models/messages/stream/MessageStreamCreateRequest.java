package io.falu.models.messages.stream;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Information for creating a message stream.
 */
@Setter
@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class MessageStreamCreateRequest {
    /**
     * A string of 3-50 characters used for easier identification of a message stream.
     * This value cannot be changed after creation.
     * Allowed characters are numbers, lowercase ASCII letters, and -, _ characters,
     * and the string has to start with a letter.
     */
    private String name;

    /**
     * Type of stream.
     */
    private MessageStreamType type;

    /**
     * Provider to be used.
     */
    private MessageStreamProviderType provider;

    private MessageStreamSettings settings;
}
