package io.falu.models.identityVerification;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class IdentityVerificationOptionsForVideo {
    /**
     * Face poses to be performed in the video recording.
     * It is recommended to leave this field unassigned for the server to
     * generate random values per verification for security purposes.
     */
    private String[] poses;

    /**
     * Numerical phrase to be recited in the video recording.
     * When not provided, the server generates a random one.
     */
    private Integer recital;
}
