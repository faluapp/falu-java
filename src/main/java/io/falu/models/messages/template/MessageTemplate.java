package io.falu.models.messages.template;

import io.falu.models.FaluModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * A template for sending messages.
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Getter
@NoArgsConstructor
public class MessageTemplate extends FaluModel {
    /**
     * Unique identifier for the object.
     */
    private String id;

    /**
     * A string used for easier identification of a message template. Allowed characters are numbers,
     * ASCII letters, and -, _ characters, and the string has to start with a letter.
     */
    private String alias;

    /**
     * Content to use when this template is used to send messages.
     * See our template language documentation for more information on the syntax for this field.
     */
    private String body;
}
