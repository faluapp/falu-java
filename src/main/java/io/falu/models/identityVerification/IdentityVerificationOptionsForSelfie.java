package io.falu.models.identityVerification;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class IdentityVerificationOptionsForSelfie {
    /**
     * Disable image uploads, selfie images have to be captured using the device's camera.
     */
    private Boolean live;
}