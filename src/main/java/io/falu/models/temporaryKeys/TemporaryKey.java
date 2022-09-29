package io.falu.models.temporaryKeys;

import io.falu.models.core.FaluModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * Represents a temporary key.
 */
@NoArgsConstructor
@Getter
@SuperBuilder
public class TemporaryKey extends FaluModel {
    /**
     * Unique identifier for the object.
     */
    private String id;

    /**
     * Unique identifiers of the objects that can be accessed using the key.
     */
    private String[] objects;

    /**
     * Expiry time for the key.
     */
    private Date expires;

    /**
     * Value provided for authentication secret
     */
    private String secret;
}
