package io.falu.models.identiityVerificationReports;

import com.google.gson.annotations.SerializedName;
import io.falu.models.core.FaluModel;
import io.falu.models.identityVerification.IdentityVerificationOptions;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class IdentityVerificationReport extends FaluModel {
    /**
     * Unique identifier for the object.
     */
    private String id;

    /**
     * Identifier of the identity verification that created this report.
     */
    private String verification;

    /**
     * The checks that initiated this report.
     */
    private IdentityVerificationOptions options;

    /**
     * Details on the user’s acceptance of the Services Agreement.
     */
    private IdentityVerificationReportConsent consent;

    /**
     * Result from an id number check.
     */
    @SerializedName("id_number")
    private IdentityVerificationReportIdNumber idNumber;

    /**
     * Result from a document check.
     */
    private IdentityVerificationReportDocument document;

    /**
     * Result from a video check.
     */
    private IdentityVerificationReportSelfie selfie;

    /**
     * Result from a video check.
     */
    private IdentityVerificationReportVideo video;
}
