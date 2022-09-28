package io.falu.models.temporaryKeys;

import io.falu.models.core.FaluModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)

/**
 * Represents a temporary key.
 */
public class TemporaryKey extends FaluModel {
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
