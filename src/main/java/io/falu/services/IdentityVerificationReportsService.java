package io.falu.services;

import io.falu.FaluClientOptions;
import io.falu.client.ResourceResponse;
import io.falu.models.identiityVerificationReports.IdentityVerificationReport;
import io.falu.models.identiityVerificationReports.IdentityVerificationReportsListOptions;
import io.falu.networking.RequestOptions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

public class IdentityVerificationReportsService extends BaseApiService {
    public IdentityVerificationReportsService(@NotNull FaluClientOptions options) {
        super(options);
    }

    /**
     * List identity verification reports
     */
    public ResourceResponse<IdentityVerificationReport[]> getIdentityVerificationReports(
            @Nullable IdentityVerificationReportsListOptions options, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().getIdentityVerificationReports(options, requestOptions);
    }

    /**
     * Retrieve an identity verification report
     */
    public ResourceResponse<IdentityVerificationReport> getIdentityVerificationReport(
            @NotNull String reportId, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().getIdentityVerificationReport(reportId, requestOptions);
    }
}
