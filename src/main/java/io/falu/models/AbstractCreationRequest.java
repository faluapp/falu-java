package io.falu.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.HashMap;

@Setter
@Getter
@NoArgsConstructor
@SuperBuilder
public abstract class AbstractCreationRequest {
    /**
     * An optional arbitrary string attached to the object. Mainly used to describe the object and often useful for displaying to users.
     */
    private String description;

    /**
     * Set of key-value pairs that you can attach to an object.
     * This can be useful for storing additional information about the object in a structured format.
     * The key can only contain alphanumeric, and ‘-’, ‘_’ characters, and the string has to start with a letter.
     */
    public HashMap<String, String> metadata;
}
