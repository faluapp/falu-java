package io.falu.models.identityVerification;

import lombok.Getter;

@Getter
public class IdentityVerificationLastError {
    /**
     * A short machine-readable string giving the reason for verification or user-session failure.
     */
    private String code;

    /**
     * A human-readable message that explains the reason for verification or user-session failure.
     * These message can be shown to your user.
     */
    private String description;
}
