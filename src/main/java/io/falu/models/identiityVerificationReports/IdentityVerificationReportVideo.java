package io.falu.models.identiityVerificationReports;

import lombok.Getter;

@Getter
public class IdentityVerificationReportVideo extends AbstractIdentityVerificationReportCheck {
    /**
     * Identifier of the file holding the image of the identity document used in this check.
     */
    private String document;

    /**
     * Identifier of the file holding the video used in this check.
     */
    private String video;

    /**
     * Identifier of the file holding the image of the portrait used in this check.
     */
    private String portrait;
}
