package io.falu.models.messages;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Information about the template used (or to be used) to send a message.
 */
@Data
@Getter
@NoArgsConstructor
public class MessageSourceTemplate {
    /**
     * Unique identifier of the template used.
     */
    private String id;

    /**
     * Alias of the template used.
     */
    private String alias;

    /**
     * Model applied when rending the template.
     */
    private Object model;
}
