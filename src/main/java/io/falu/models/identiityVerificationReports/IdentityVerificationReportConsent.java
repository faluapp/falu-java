package io.falu.models.identiityVerificationReports;

import lombok.Getter;

import java.util.Date;

@Getter
public class IdentityVerificationReportConsent {
    /**
     * The timestamp marking when the user gave consent for the identity verification to be done.
     */
    private Date date;

    /**
     * The IP address from which the user gave consent for the identity verification to be done.
     */
    private String ip;

    /**
     * The user agent of the browser from which the user gave consent for the identity verification to be done.
     */
    private String userAgent;
}
