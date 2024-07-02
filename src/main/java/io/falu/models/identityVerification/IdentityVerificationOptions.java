package io.falu.models.identityVerification;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

/**
 * A set of verification checks to be performed.
 */
@Getter
@Builder
public class IdentityVerificationOptions {

    /**
     * Options for the id number check.
     */
    @JsonProperty("id_number")
    private IdentityVerificationOptionsForIdNumber idNumber;

    /**
     * Options for the document check.
     */
    private IdentityVerificationOptionsForDocument document;

    /**
     * Options for the selfie check.
     */
    private IdentityVerificationOptionsForSelfie selfie;

    /**
     * Options for the video check.
     */
    private IdentityVerificationOptionsForVideo video;
}
