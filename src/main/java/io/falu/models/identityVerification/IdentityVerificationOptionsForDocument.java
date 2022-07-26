package io.falu.models.identityVerification;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class IdentityVerificationOptionsForDocument {
    /**
     * Disable image uploads, identity document images have to be captured using the device's camera.
     */
    private Boolean live;

    /**
     * The allowed identity document types.
     * If a user uploads a document which isn't one of the allowed types, it will be rejected.
     */
    private String[] allowed;
}
