package io.falu.models.identiityVerificationReports;

import lombok.Getter;

@Getter
public abstract class AbstractIdentityVerificationReportCheck {
    /**
     * Details on the verification error.
     * Present when not verified.
     */
    private IdentityVerificationReportError error;

    /**
     * Whether the check resulted in a successful verification.
     */
    private Boolean verified;
}
