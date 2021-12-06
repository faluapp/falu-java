package io.falu.networking;

import io.falu.FaluClientOptions;
import io.falu.client.AbstractHttpApiClient;
import io.falu.client.ResourceResponse;
import io.falu.client.headers.EmptyAuthenticationHeaderProvider;
import io.falu.models.evaluations.Evaluation;
import io.falu.models.evaluations.EvaluationRequest;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FaluApiClient extends AbstractHttpApiClient {
    private static final String BASE_URL = "https://api.falu.io";
    private final Boolean enableLogging;

    public FaluApiClient(FaluClientOptions options) {
        super(new FaluAuthenticationHeaderProvider(options.getApiKey()));
        this.enableLogging = options.getEnableLogging();
    }


    FaluApiClient(Boolean enableLogging) {
        super(new EmptyAuthenticationHeaderProvider());
        this.enableLogging = enableLogging;
    }

    //region Evaluations
    public ResourceResponse<Evaluation[]> getEvaluations() throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/evaluations")
                .get();
        return execute(builder, Evaluation[].class);
    }

    public ResourceResponse<Evaluation> createEvaluation(EvaluationRequest request) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/evaluations")
                .post(RequestBody.create(makeJson(request), MEDIA_TYPE_JSON));
        return execute(builder, Evaluation.class);
    }

    public ResourceResponse<Evaluation> getEvaluation(String evaluationId) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/evaluations/" + evaluationId)
                .get();
        return execute(builder, Evaluation.class);
    }

    // TODO: Update an evaluation

    public ResourceResponse<Evaluation> scoreEvaluation(String evaluationId) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/evaluations/" + evaluationId + "/scores")
                .post(RequestBody.create(makeJson(null), MEDIA_TYPE_JSON));
        return execute(builder, Evaluation.class);
    }
    //endregion


    private Request.Builder buildRequest(Request.Builder builder, RequestOptions options) {
        return builder;
    }

    @Override
    protected OkHttpClient buildBackChannel(OkHttpClient.Builder builder) {
        builder
                .followRedirects(false)
                .connectTimeout(50, TimeUnit.SECONDS) // default is 50 seconds
                .readTimeout(50, TimeUnit.SECONDS)
                .writeTimeout(50, TimeUnit.SECONDS);

        if (enableLogging) {
            builder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        }

        return super.buildBackChannel(builder);
    }
}
