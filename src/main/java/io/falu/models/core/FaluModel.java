package io.falu.models.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public abstract class FaluModel implements Serializable {
    /**
     * Time at which the object was created.
     */
    Date created;

    /**
     * Time at which the object was last updated.
     */
    Date updated;

    /**
     * Indicates if this object belongs in the live environment
     */
    Boolean live;

    /**
     * Unique identifier for the workspace that the object belongs to.
     */
    String workspace;

    /**
     * An optional arbitrary string attached to the object.
     * Mainly used to describe the object and often useful for displaying to users.
     */
    String description;

    /**
     * Set of key-value pairs that you can attach to an object.
     * This can be useful for storing additional information about the object in a structured format.
     * The key can only contain alphanumeric, and -, _ characters, and the string has to start with a letter.
     */
    Map<String, String> metadata;

    /**
     * A value that validates concurrent access of this object when stored in the database.
     * This value changes with every update and can thus be used to track changes.
     */
    String etag;
}
