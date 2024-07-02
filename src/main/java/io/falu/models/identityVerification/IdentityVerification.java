package io.falu.models.identityVerification;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.falu.models.core.DataReduction;
import io.falu.models.core.FaluModel;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * The identification record for an entity.
 */
@Getter
@SuperBuilder
public class IdentityVerification extends FaluModel {
    /**
     * Unique identifier for the record
     */
    private String id;

    /**
     * Status of the verification.
     * <a href="https://falu.io/docs/identity/how-verifications-work">Learn more about the lifecycle of verifications.</a>
     */
    private String status;

    /**
     * The type of <a href="https://falu.io/docs/identity/verification-checks">verification check<a/> to be performed.
     */
    private String type;

    /**
     * A set of verification checks to be performed.
     */
    private IdentityVerificationOptions options;

    /**
     * The short-lived client secret used by front-end libraries to show a verification modal inside your app.
     * This client secret expires after 24 hours and can only be used once.
     * Don’t store it, log it, embed it in a URL, or expose it to anyone other than the user.
     * Make sure that you have TLS enabled on any page that includes the client secret.
     */
    @JsonProperty("client_secret")
    private String clientSecret;

    /**
     * The short-lived URL that you use to redirect a user to Falu to submit their identity information.
     * This link expires after 24 hours and can only be used once.
     * Don’t store it, log it, send it in emails or expose it to anyone other than the target user.
     */
    private String url;

    /**
     * Unique identifiers of the reports for this verification.
     */
    private String[] reports;

    /**
     * If present, this property tells you the last error encountered when processing the identity verification.
     */
    private IdentityVerificationLastError error;

    /**
     * The user's verified data.
     */
    private IdentityVerificationOutputs outputs;

    /**
     * Redaction information of this object. If the object is not redacted, this field will be null.
     */
    private DataReduction reduction;
}
