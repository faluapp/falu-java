package io.falu.models.temporaryKeys;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Information for creating a temporary key
 */
@NoArgsConstructor
@SuperBuilder
public class TemporaryKeyCreateOptions {
    /**
     * Unique identifier of the identity verification to be accessed using the key.
     */
    @JsonProperty("identity_verification")
    private String identityVerification;
}
