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
import io.falu.models.messages.Message;
import io.falu.models.messages.MessageCreateRequest;
import io.falu.models.messages.stream.MessageStream;
import io.falu.models.messages.stream.MessageStreamCreateRequest;
import io.falu.models.messages.template.MessageTemplate;
import io.falu.models.messages.template.MessageTemplateRequest;
import io.falu.models.messages.template.MessageTemplateValidationRequest;
import io.falu.models.messages.template.MessageTemplateValidationResponse;
import io.falu.models.moneyBalances.MoneyBalance;
import io.falu.models.payments.Payment;
import io.falu.models.payments.PaymentCreateRequest;
import io.falu.models.payments.authorization.PaymentAuthorization;
import io.falu.models.payments.refunds.PaymentRefund;
import io.falu.models.payments.refunds.PaymentRefundRequest;
import io.falu.models.transfers.Transfer;
import io.falu.models.transfers.TransferCreateRequest;
import io.falu.models.transfers.reversals.TransferReversal;
import io.falu.models.transfers.reversals.TransferReversalCreateRequest;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FaluApiClient extends AbstractHttpApiClient {
    private static final String BASE_URL = "https://api.falu.io";
    private final Boolean enableLogging;

    public FaluApiClient(FaluClientOptions options) {
        super(new FaluAuthenticationHeaderProvider(options.getApiKey()));
        this.enableLogging = options.getEnableLogging();
    }


    public FaluApiClient(Boolean enableLogging) {
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

    public ResourceResponse<PaymentAuthorization[]> getPaymentAuthorizations() throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/payment_authorizations")
                .get();

        return execute(builder, PaymentAuthorization[].class);
    }

    public ResourceResponse<PaymentAuthorization> getPaymentAuthorization(String authorizationId) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/payment_authorizations/" + authorizationId)
                .post(RequestBody.create(makeJson(null), MEDIA_TYPE_JSON));

        return execute(builder, PaymentAuthorization.class);
    }

    public ResourceResponse<PaymentAuthorization> approvePaymentAuthorization(String authorizationId) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/payment_authorizations/" + authorizationId + "/approve")
                .get();

        return execute(builder, PaymentAuthorization.class);
    }

    public ResourceResponse<PaymentAuthorization> declinePaymentAuthorization(String authorizationId) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/payment_authorizations/" + authorizationId + "/decline")
                .get();

        return execute(builder, PaymentAuthorization.class);
    }

    public ResourceResponse<PaymentRefund[]> getPaymentRefunds() throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/payment_refunds/")
                .get();

        return execute(builder, PaymentRefund[].class);
    }

    public ResourceResponse<PaymentRefund> createPaymentRefund(PaymentRefundRequest request) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/payment_refunds/")
                .post(RequestBody.create(makeJson(request), MEDIA_TYPE_JSON));

        return execute(builder, PaymentRefund.class);
    }

    public ResourceResponse<PaymentRefund> getPaymentRefund(String refundId) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/payment_refunds/" + refundId)
                .get();

        return execute(builder, PaymentRefund.class);
    }
    //endregion

    //region Messages, Message Templates, and Message Streams
    public ResourceResponse<Message[]> getMessages() throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/messages")
                .get();

        return execute(builder, Message[].class);
    }

    public ResourceResponse<Message> createMessage(MessageCreateRequest request) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/messages")
                .post(RequestBody.create(makeJson(request), MEDIA_TYPE_JSON));

        return execute(builder, Message.class);
    }

    public ResourceResponse<Message> getMessage(String messageId) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/messages/" + messageId)
                .get();

        return execute(builder, Message.class);
    }

    public ResourceResponse<Message[]> sendBulkMessages(List<MessageCreateRequest> messages) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/messages/bulk")
                .post(RequestBody.create(makeJson(messages), MEDIA_TYPE_JSON));

        return execute(builder, Message[].class);
    }

    public ResourceResponse<MessageTemplate[]> getMessageTemplates() throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/messages_templates")
                .get();

        return execute(builder, MessageTemplate[].class);
    }

    public ResourceResponse<MessageTemplate> createMessageTemplate(MessageTemplateRequest request) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/messages_templates")
                .post(RequestBody.create(makeJson(request), MEDIA_TYPE_JSON));

        return execute(builder, MessageTemplate.class);
    }

    public ResourceResponse<MessageTemplate> getMessageTemplate(String templateId) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/messages_templates" + templateId)
                .get();

        return execute(builder, MessageTemplate.class);
    }

    // TODO: Update messages, templates, and streams

    public ResourceResponse<Object> deleteMessageTemplate(String templateId) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/messages_templates" + templateId)
                .delete();

        return execute(builder, Object.class);
    }

    public ResourceResponse<MessageTemplateValidationResponse> validateMessageTemplate(MessageTemplateValidationRequest request) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/messages_templates/validate")
                .post(RequestBody.create(makeJson(request), MEDIA_TYPE_JSON));

        return execute(builder, MessageTemplateValidationResponse.class);
    }

    public ResourceResponse<MessageStream[]> getMessageStreams() throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/message_streams")
                .get();
        return execute(builder, MessageStream[].class);
    }

    public ResourceResponse<MessageStream> createMessageStream(MessageStreamCreateRequest request) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/message_streams")
                .post(RequestBody.create(makeJson(request), MEDIA_TYPE_JSON));

        return execute(builder, MessageStream.class);
    }

    public ResourceResponse<MessageStream> getMessageStream(String streamId) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/message_streams" + streamId)
                .get();
        return execute(builder, MessageStream.class);
    }

    public ResourceResponse<Object> deleteMessageStream(String streamId) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/message_streams/" + streamId)
                .delete();
        return execute(builder, Object.class);
    }

    public ResourceResponse<MessageStream> archiveMessageStream(String streamId) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/message_streams/" + streamId + "/archive")
                .post(RequestBody.create(makeJson(null), MEDIA_TYPE_JSON));

        return execute(builder, MessageStream.class);
    }

    public ResourceResponse<MessageStream> unarchiveMessageStream(String streamId) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/message_streams" + streamId + "/unarchive")
                .post(RequestBody.create(makeJson(null), MEDIA_TYPE_JSON));

        return execute(builder, MessageStream.class);
    }
    //endregion

    //region Money Balance
    public ResourceResponse<MoneyBalance> getMoneyBalances() throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/money_balance")
                .get();
        return execute(builder, MoneyBalance.class);
    }

    public ResourceResponse<MoneyBalance> refreshMoneyBalances() throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/money_balance")
                .post(RequestBody.create(makeJson(null), MEDIA_TYPE_JSON));
        return execute(builder, MoneyBalance.class);
    }
    //endregion

    //region Transfers, Transfer Reversals
    public ResourceResponse<Transfer[]> getTransfers() throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/transfers")
                .get();
        return execute(builder, Transfer[].class);
    }

    public ResourceResponse<Transfer> createTransfer(TransferCreateRequest request) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/transfers")
                .post(RequestBody.create(makeJson(request), MEDIA_TYPE_JSON));
        return execute(builder, Transfer.class);
    }

    public ResourceResponse<Transfer> getTransfer(String transferId) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/transfers/" + transferId)
                .get();
        return execute(builder, Transfer.class);
    }

    public ResourceResponse<TransferReversal[]> getTransferReversals() throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/transfer_reversals")
                .get();
        return execute(builder, TransferReversal[].class);
    }

    public ResourceResponse<TransferReversal> createTransferReversal(TransferReversalCreateRequest request) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/transfer_reversals")
                .post(RequestBody.create(makeJson(request), MEDIA_TYPE_JSON));
        return execute(builder, TransferReversal.class);
    }

    public ResourceResponse<TransferReversal> getTransferReversal(String transferId) throws IOException {
        Request.Builder builder = new Request.Builder()
                .url(BASE_URL + "/v1/transfer_reversals/" + transferId)
                .get();
        return execute(builder, TransferReversal.class);
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
