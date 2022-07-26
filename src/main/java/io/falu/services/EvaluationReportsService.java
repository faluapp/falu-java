package io.falu.services;

import io.falu.FaluClientOptions;
import io.falu.client.ResourceResponse;
import io.falu.models.evaluationReports.EvaluationReport;
import io.falu.models.evaluationReports.EvaluationReportsListOptions;
import io.falu.networking.RequestOptions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

public class EvaluationReportsService extends BaseApiService {

    public EvaluationReportsService(@NotNull FaluClientOptions options) {
        super(options);
    }

    /**
     * Get evaluation reports.
     */
    public ResourceResponse<EvaluationReport[]> getEvaluationReports(@Nullable EvaluationReportsListOptions options, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().getEvaluationReports(options, requestOptions);
    }

    /**
     * Get Evaluation report.
     *
     * @param reportId the unique identifier of the object.
     */
    public ResourceResponse<EvaluationReport> getEvaluationReport(@NotNull String reportId, @Nullable RequestOptions options) throws IOException {
        return getApiClient().getEvaluationReport(reportId, options);
    }
}
