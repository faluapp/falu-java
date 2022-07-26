package io.falu.models.identiityVerificationReports;

import lombok.Getter;

@Getter
public class IdentityVerificationReportSelfie extends AbstractIdentityVerificationReportCheck {
    /**
     * Identifier of the file holding the image of the identity document used in this check.
     */
    private String document;

    /**
     * Identifier of the file holding the image of the selfie used in this check.
     */
    private String selfie;
}
