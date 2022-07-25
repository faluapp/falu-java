package io.falu.models.identityVerification;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

/**
 * A set of verification checks to be performed.
 */
@Getter
public class IdentityVerificationOptions {

    /**
     * Options for the id number check.
     */
    @SerializedName("id_number")
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
