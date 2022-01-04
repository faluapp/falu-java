package io.falu.models.messages.template;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * A model representing details that can be changed about a template
 */
@Setter
@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class MessageTemplateRequest {
    /**
     * An optional string you can provide to identify this template.
     * Allowed characters are numbers, ASCII letters, and ‘.’, ‘-’, ‘_’ characters,
     * and the string has to start with a letter.
     */
    private String alias;

    /**
     * An optional arbitrary string attached to the object. Mainly used to describe the object and often useful for displaying to users.
     */
    private String description;

    /**
     * A string used for easier identification of a message template.
     * Allowed characters are numbers, ASCII letters, and ‘-’, ‘_’ characters, and the string has to start with a letter.
     */
    private String body;
}
