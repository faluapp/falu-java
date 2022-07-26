package io.falu.services;

import io.falu.FaluClientOptions;
import io.falu.client.ResourceResponse;
import io.falu.client.patch.JsonPatchDocument;
import io.falu.models.identityVerification.IdentityVerification;
import io.falu.models.identityVerification.IdentityVerificationCreateRequest;
import io.falu.models.identityVerification.IdentityVerificationPatchModel;
import io.falu.networking.RequestOptions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

public class IdentificationVerificationService extends BaseApiService {
    public IdentificationVerificationService(@NotNull FaluClientOptions options) {
        super(options);
    }

    /**
     * List identity verifications
     */
    public ResourceResponse<IdentityVerification[]> getIdentityVerifications(
            @Nullable IdentityVerificationListOptions options, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().getIdentityVerifications(options, requestOptions);
    }

    /**
     * Create an identity verification
     */
    public ResourceResponse<IdentityVerification> createIdentityVerification(
            @NotNull IdentityVerificationCreateRequest request, @Nullable RequestOptions options) throws IOException {
        return getApiClient().createIdentityVerification(request, options);
    }

    /**
     * Retrieve an identity verification
     */
    public ResourceResponse<IdentityVerification> getIdentityVerification(@NotNull String id, @Nullable RequestOptions options) throws IOException {
        return getApiClient().getIdentityVerification(id, options);
    }

    /**
     * Update an identity verification
     */
    public ResourceResponse<IdentityVerification> updateIdentityVerification(
            @NotNull String id, @NotNull JsonPatchDocument<IdentityVerificationPatchModel> patch, @Nullable RequestOptions options) throws IOException {
        return getApiClient().updateIdentityVerification(id, patch, options);
    }

    /**
     * An identity verification can be cancelled when it is in input_required status.
     * Once cancelled, future submission attempts are disabled.
     * This cannot be undone. <a href="https://falu.io/docs/identity/sessions#cancel">Learn more</a>.
     */
    public ResourceResponse<IdentityVerification> cancelIdentityVerification(@NotNull String id, @Nullable RequestOptions options) throws IOException {
        return getApiClient().cancelIdentityVerification(id, options);
    }

    /**
     * Redact an identity verification to remove all collected information from Falu.
     * This will redact the IdentityVerification and all objects related to it, including IdentityVerificationReports, Events, request logs, etc.
     * An identity verification can be redacted when it is in input_required or verified status. Redacting an identity verification in input_required state will automatically cancel it.
     * <p>
     * The redaction process may take up a week. When the redaction process is in progress,
     * the IdentityVerification's redaction.status field will be set to processing; when the process is finished,
     * it will change to redacted and an identity_verification.redacted event will be emitted.
     * <p>
     * Redaction is irreversible. Redacted objects are still accessible in the API,
     * but all the fields that contain personal data will be replaced by the string [redacted] or a similar placeholder.
     * The metadata field will also be erased. Redacted objects cannot be updated or used for any purpose.
     */
    public ResourceResponse<IdentityVerification> redactIdentityVerification(@NotNull String id, @Nullable RequestOptions options) throws IOException {
        return getApiClient().redactIdentityVerification(id, options);
    }
}
