package io.falu.networking;

import io.falu.FaluClientOptions;
import io.falu.client.AbstractHttpApiClient;
import io.falu.client.ResourceResponse;
import io.falu.client.headers.EmptyAuthenticationHeaderProvider;
import io.falu.models.evaluations.Evaluation;
import io.falu.models.evaluations.EvaluationRequest;
import io.falu.models.identity.IdentityRecord;
import io.falu.models.identity.IdentitySearchModel;
import io.falu.models.identity.MarketingListOptions;
import io.falu.models.identity.MarketingResult;
import io.falu.models.payments.Payment;
import io.falu.models.payments.PaymentCreateRequest;
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

    //region Identity
    public ResourceResponse<IdentityRecord> searchIdentity(IdentitySearchModel searchModel) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/identity/search")
                .post(RequestBody.create(makeJson(searchModel), MEDIA_TYPE_JSON));

        return execute(builder, IdentityRecord.class);
    }

    public ResourceResponse<MarketingResult[]> fetchMarketingResults(MarketingListOptions marketingListOptions) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/identity/marketing")
                .post(RequestBody.create(makeJson(null), MEDIA_TYPE_JSON));

        return execute(builder, MarketingResult[].class);
    }
    //endregion

    //region Payments
    public ResourceResponse<Payment[]> getPayments() throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/payments")
                .get();

        return execute(builder, Payment[].class);
    }

    public ResourceResponse<Payment> getPayment(String paymentId) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/payments/" + paymentId)
                .get();

        return execute(builder, Payment.class);
    }

    // TODO: Update payment

    public ResourceResponse<Payment> createPayment(PaymentCreateRequest request) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/payments")
                .post(RequestBody.create(makeJson(request), MEDIA_TYPE_JSON));


        return execute(builder, Payment.class);
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
