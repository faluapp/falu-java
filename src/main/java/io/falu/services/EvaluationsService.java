package io.falu.services;

import io.falu.ApiResultCallback;
import io.falu.FaluClientOptions;
import io.falu.client.ResourceResponse;
import io.falu.models.evaluations.Evaluation;
import io.falu.models.evaluations.EvaluationRequest;
import org.jetbrains.annotations.NotNull;

public class EvaluationsService extends BaseApiService {

    EvaluationsService(FaluClientOptions options) {
        super(options);
    }

    public void getEvaluations(@NotNull ApiResultCallback<Evaluation[]> callback) {
        try {
            ResourceResponse<Evaluation[]> response = getApiClient().getEvaluations();
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    public void createEvaluation(@NotNull EvaluationRequest request, @NotNull ApiResultCallback<Evaluation> callback) {
        try {
            ResourceResponse<Evaluation> response = getApiClient().createEvaluation(request);
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    public void getEvaluation(@NotNull String evaluationId, @NotNull ApiResultCallback<Evaluation> callback) {
        try {
            ResourceResponse<Evaluation> response = getApiClient().getEvaluation(evaluationId);
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    public void scoreEvaluation(@NotNull String evaluationId, @NotNull ApiResultCallback<Evaluation> callback) {
        try {
            ResourceResponse<Evaluation> response = getApiClient().scoreEvaluation(evaluationId);
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }
}
