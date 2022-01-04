package io.falu.models.messages.template;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@Getter
@NoArgsConstructor
public class MessageTemplateValidationResponse {

    /**
     * The template model to be used when rendering test content.
     */
    private HashMap<String, Object> model;

    /**
     *
     */
    private String rendered;
}
