package io.falu.models.identityVerification;

import com.google.gson.annotations.SerializedName;
import io.falu.models.core.AbstractCreateOptions;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Information for searching for an entity's identity.
 */
@Setter
@SuperBuilder()
public class IdentityVerificationCreateOptions extends AbstractCreateOptions {
    /**
     * The type of verification check to be performed.
     */
    private String type;

    /**
     * A set of verification checks to be performed.
     */
    private IdentityVerificationOptions options;

    /**
     * The URL the user will be redirected to upon completing the verification flow.
     */
    @SerializedName("return_url")
    private String returnUrl;
}
