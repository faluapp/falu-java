package io.falu.models.messages.template;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.HashMap;

/**
 * Model for requesting template validation
 */
@Setter
@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class MessageTemplateValidationRequest {
    /**
     * The content to use when this template is used to send messages.
     * See our template language documentation for more information on the syntax for this field.
     */
    private String body;

    /**
     * The template model to be used when rendering test content.
     */
    private HashMap<String, Object> model;
}
