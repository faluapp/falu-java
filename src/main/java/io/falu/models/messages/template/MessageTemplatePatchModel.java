package io.falu.models.messages.template;

import io.falu.models.AbstractCreationRequest;
import lombok.experimental.SuperBuilder;

/**
 * A model representing details that can be changed about a template
 */
@SuperBuilder
public class MessageTemplatePatchModel extends AbstractCreationRequest {
    /**
     * An optional string you can provide to identify this template.
     * Allowed characters are numbers, ASCII letters, and ., -, _ characters,
     * and the string has to start with a letter.
     */
    public String alias;

    /**
     * The content to use when this template is used to send messages.
     * See our template language documentation for more information on the syntax for this field.
     */
    public String body;
}
