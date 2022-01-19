package io.falu.services;

import io.falu.FaluClientOptions;
import io.falu.client.ResourceResponse;
import io.falu.client.patch.JsonPatchDocument;
import io.falu.models.evaluations.Evaluation;
import io.falu.models.evaluations.EvaluationRequest;
import io.falu.networking.RequestOptions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

public class EvaluationsService extends BaseApiService {

    public EvaluationsService(@NotNull FaluClientOptions options) {
        super(options);
    }

    /**
     * Get evaluations.
     */
    public ResourceResponse<Evaluation[]> getEvaluations(@Nullable RequestOptions options) throws IOException {
        return getApiClient().getEvaluations(options);
    }

    /**
     * Create Evaluation.
     *
     * @param request the request object.
     */
    public ResourceResponse<Evaluation> createEvaluation(@NotNull EvaluationRequest request, @Nullable RequestOptions options) throws IOException {
        return getApiClient().createEvaluation(request, options);
    }

    /**
     * Get Evaluation.
     *
     * @param evaluationId the unique identifier of the object.
     */
    public ResourceResponse<Evaluation> getEvaluation(@NotNull String evaluationId, @Nullable RequestOptions options) throws IOException {
        return getApiClient().getEvaluation(evaluationId, options);
    }

    /**
     * Score Evaluation.
     *
     * @param evaluationId the unique identifier of the object.
     */
    public ResourceResponse<Evaluation> scoreEvaluation(@NotNull String evaluationId, @Nullable RequestOptions options) throws IOException {
        return getApiClient().scoreEvaluation(evaluationId, options);
    }

    /**
     * Update Evaluation.
     *
     * @param evaluationId the unique identifier of the object.
     */
    public ResourceResponse<Evaluation> updateEvaluation(@NotNull String evaluationId, @NotNull JsonPatchDocument patch, @Nullable RequestOptions options) throws IOException {
        return getApiClient().updateEvaluation(evaluationId, patch, options);
    }
}
