package io.falu.networking;

import com.google.gson.internal.bind.util.ISO8601Utils;
import io.falu.FaluClientOptions;
import io.falu.client.AbstractHttpApiClient;
import io.falu.client.ResourceResponse;
import io.falu.client.patch.JsonPatchDocument;
import io.falu.common.BasicListOptions;
import io.falu.common.QueryValues;
import io.falu.models.evaluationReports.EvaluationReport;
import io.falu.models.evaluationReports.EvaluationReportsListOptions;
import io.falu.models.evaluations.Evaluation;
import io.falu.models.evaluations.EvaluationPatchModel;
import io.falu.models.evaluations.EvaluationRequest;
import io.falu.models.evaluations.EvaluationsListOptions;
import io.falu.models.events.EventListOptions;
import io.falu.models.events.WebhookEvent;
import io.falu.models.files.File;
import io.falu.models.files.FileCreateRequest;
import io.falu.models.files.FileListOptions;
import io.falu.models.files.links.FileLink;
import io.falu.models.files.links.FileLinkCreateRequest;
import io.falu.models.files.links.FileLinkPatchModel;
import io.falu.models.files.links.FileLinksListOptions;
import io.falu.models.identiityVerificationReports.IdentityVerificationReport;
import io.falu.models.identiityVerificationReports.IdentityVerificationReportsListOptions;
import io.falu.models.identity.IdentityRecord;
import io.falu.models.identity.IdentitySearchModel;
import io.falu.models.identity.MarketingListOptions;
import io.falu.models.identity.MarketingResult;
import io.falu.models.identityVerification.IdentityVerification;
import io.falu.models.identityVerification.IdentityVerificationCreateRequest;
import io.falu.models.identityVerification.IdentityVerificationListOptions;
import io.falu.models.identityVerification.IdentityVerificationPatchModel;
import io.falu.models.messages.*;
import io.falu.models.messages.stream.MessageStream;
import io.falu.models.messages.stream.MessageStreamCreateRequest;
import io.falu.models.messages.stream.MessageStreamPatchModel;
import io.falu.models.messages.stream.MessageStreamsListOptions;
import io.falu.models.messages.template.*;
import io.falu.models.moneyBalances.MoneyBalance;
import io.falu.models.payments.Payment;
import io.falu.models.payments.PaymentCreateRequest;
import io.falu.models.payments.PaymentPatchModel;
import io.falu.models.payments.PaymentsListOptions;
import io.falu.models.payments.authorization.PaymentAuthorization;
import io.falu.models.payments.authorization.PaymentAuthorizationPatchModel;
import io.falu.models.payments.authorization.PaymentAuthorizationsListOptions;
import io.falu.models.payments.refunds.PaymentRefund;
import io.falu.models.payments.refunds.PaymentRefundPatchModel;
import io.falu.models.payments.refunds.PaymentRefundRequest;
import io.falu.models.payments.refunds.PaymentRefundsListOptions;
import io.falu.models.transfers.Transfer;
import io.falu.models.transfers.TransferCreateRequest;
import io.falu.models.transfers.TransferListOptions;
import io.falu.models.transfers.TransferPatchModel;
import io.falu.models.transfers.reversals.TransferReversal;
import io.falu.models.transfers.reversals.TransferReversalCreateRequest;
import io.falu.models.transfers.reversals.TransferReversalPatchModel;
import io.falu.models.transfers.reversals.TransferReversalsListOptions;
import io.falu.models.webhooks.WebhookEndpoint;
import io.falu.models.webhooks.WebhookEndpointCreateRequest;
import io.falu.models.webhooks.WebhookEndpointListOptions;
import io.falu.models.webhooks.WebhookEndpointPatchModel;
import okhttp3.HttpUrl;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.List;

public class FaluApiClient extends AbstractHttpApiClient {
    private static final String HOST = "api.falu.io";
    private static final String SCHEME = "https";

    public FaluApiClient(FaluClientOptions options, AppDetailsInterceptor interceptor, Boolean enableLogging) {
        super(new FaluAuthenticationHeaderProvider(options.getApiKey()), interceptor, enableLogging);
    }

    //region Evaluations
    public ResourceResponse<Evaluation[]> getEvaluations(EvaluationsListOptions options, RequestOptions requestOptions) throws IOException {
        HttpUrl url = buildUrl("v1/evaluations", options);
        Request.Builder builder = buildRequest(requestOptions)
                .url(url)
                .get();
        return execute(builder, Evaluation[].class);
    }

    public ResourceResponse<Evaluation> createEvaluation(EvaluationRequest request, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/evaluations", null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .post(RequestBody.create(makeJson(request), MEDIA_TYPE_JSON));
        return execute(builder, Evaluation.class);
    }

    public ResourceResponse<Evaluation> getEvaluation(String evaluationId, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/evaluations/" + evaluationId, null);
        Request.Builder builder = buildRequest(options)
                .url(url)
                .get();
        return execute(builder, Evaluation.class);
    }

    public ResourceResponse<Evaluation> updateEvaluation(String evaluationId, JsonPatchDocument<EvaluationPatchModel> patch, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/evaluations/" + evaluationId, null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .patch(RequestBody.create(makeJson(patch.getOperations()), MEDIA_TYPE_JSON));
        return execute(builder, Evaluation.class);
    }

    public ResourceResponse<Evaluation> scoreEvaluation(String evaluationId, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/evaluations/" + evaluationId + "/scores", null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .post(RequestBody.create(makeJson(null), MEDIA_TYPE_JSON));
        return execute(builder, Evaluation.class);
    }
    //endregion

    //region Identity
    public ResourceResponse<IdentityRecord> searchIdentity(IdentitySearchModel searchModel, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/identity/search", null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .post(RequestBody.create(makeJson(searchModel), MEDIA_TYPE_JSON));

        return execute(builder, IdentityRecord.class);
    }

    public ResourceResponse<MarketingResult[]> fetchMarketingResults(MarketingListOptions listOptions, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/identity/marketing", listOptions);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .post(RequestBody.create(makeJson(null), MEDIA_TYPE_JSON));

        return execute(builder, MarketingResult[].class);
    }
    //endregion

    //region Payments
    public ResourceResponse<Payment[]> getPayments(PaymentsListOptions listOptions, RequestOptions requestOptions) throws IOException {
        HttpUrl url = buildUrl("v1/payments", listOptions);

        Request.Builder builder = buildRequest(requestOptions)
                .url(url)
                .get();

        return execute(builder, Payment[].class);
    }

    public ResourceResponse<Payment> getPayment(String paymentId, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/payments/" + paymentId, null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .get();

        return execute(builder, Payment.class);
    }

    public ResourceResponse<Payment> updatePayment(String paymentId, JsonPatchDocument<PaymentPatchModel> document, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/payments/" + paymentId, null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .patch(RequestBody.create(makeJson(document.getOperations()), MEDIA_TYPE_JSON));

        return execute(builder, Payment.class);
    }

    public ResourceResponse<Payment> createPayment(PaymentCreateRequest request, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/payments/", null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .post(RequestBody.create(makeJson(request), MEDIA_TYPE_JSON));

        return execute(builder, Payment.class);
    }

    public ResourceResponse<PaymentAuthorization[]> getPaymentAuthorizations(PaymentAuthorizationsListOptions listOptions, RequestOptions requestOptions) throws IOException {
        HttpUrl url = buildUrl("v1/payment_authorizations", listOptions);

        Request.Builder builder = buildRequest(requestOptions)
                .url(url)
                .get();

        return execute(builder, PaymentAuthorization[].class);
    }

    public ResourceResponse<PaymentAuthorization> getPaymentAuthorization(String authorizationId, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/payment_authorizations/" + authorizationId, null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .get();
        return execute(builder, PaymentAuthorization.class);
    }

    public ResourceResponse<PaymentAuthorization> updatePaymentAuthorization(String authorizationId, JsonPatchDocument<PaymentAuthorizationPatchModel> document, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/payment_authorizations/" + authorizationId, null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .patch(RequestBody.create(makeJson(document.getOperations()), MEDIA_TYPE_JSON));
        return execute(builder, PaymentAuthorization.class);
    }

    public ResourceResponse<PaymentAuthorization> approvePaymentAuthorization(String authorizationId, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/payment_authorizations/" + authorizationId + "/approve", null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .post(RequestBody.create(makeJson(null), MEDIA_TYPE_JSON));
        return execute(builder, PaymentAuthorization.class);
    }

    public ResourceResponse<PaymentAuthorization> declinePaymentAuthorization(String authorizationId, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/payment_authorizations/" + authorizationId + "/decline", null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .post(RequestBody.create(makeJson(null), MEDIA_TYPE_JSON));
        return execute(builder, PaymentAuthorization.class);
    }

    public ResourceResponse<PaymentRefund[]> getPaymentRefunds(PaymentRefundsListOptions listOptions, RequestOptions requestOptions) throws IOException {
        HttpUrl url = buildUrl("v1/payment_refunds/", listOptions);

        Request.Builder builder = buildRequest(requestOptions)
                .url(url)
                .get();

        return execute(builder, PaymentRefund[].class);
    }

    public ResourceResponse<PaymentRefund> createPaymentRefund(PaymentRefundRequest request, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/payment_refunds/", null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .post(RequestBody.create(makeJson(request), MEDIA_TYPE_JSON));

        return execute(builder, PaymentRefund.class);
    }

    public ResourceResponse<PaymentRefund> getPaymentRefund(String refundId, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/payment_refunds/" + refundId, null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .get();
        return execute(builder, PaymentRefund.class);
    }

    public ResourceResponse<PaymentRefund> updatePaymentRefund(String refundId, JsonPatchDocument<PaymentRefundPatchModel> document, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/payment_refunds/" + refundId, null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .patch(RequestBody.create(makeJson(document.getOperations()), MEDIA_TYPE_JSON));
        return execute(builder, PaymentRefund.class);
    }
    //endregion

    //region Messages, Message Templates, and Message Streams
    public ResourceResponse<Message[]> getMessages(MessagesListOptions listOptions, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/messages", listOptions);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .get();
        return execute(builder, Message[].class);
    }

    public ResourceResponse<MessageResponse> createMessage(MessageCreateRequest request, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/messages", null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .post(RequestBody.create(makeJson(request), MEDIA_TYPE_JSON));
        return execute(builder, MessageResponse.class);
    }

    public ResourceResponse<Message> getMessage(String messageId, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/messages/" + messageId, null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .get();

        return execute(builder, Message.class);
    }

    public ResourceResponse<Message> updateMessage(String messageId, JsonPatchDocument<MessagePatchModel> document, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/messages/" + messageId, null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .patch(RequestBody.create(makeJson(document.getOperations()), MEDIA_TYPE_JSON));
        return execute(builder, Message.class);
    }

    public ResourceResponse<MessageResponse> sendBulkMessages(List<MessageCreateRequest> messages, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/messages/batch", null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .post(RequestBody.create(makeJson(messages), MEDIA_TYPE_JSON));
        return execute(builder, MessageResponse.class);
    }

    public ResourceResponse<MessageTemplate[]> getMessageTemplates(MessageTemplatesListOptions listOptions, RequestOptions requestOptions) throws IOException {
        HttpUrl url = buildUrl("v1/message_templates", listOptions);

        Request.Builder builder = buildRequest(requestOptions)
                .url(url)
                .get();
        return execute(builder, MessageTemplate[].class);
    }

    public ResourceResponse<MessageTemplate> createMessageTemplate(MessageTemplateRequest request, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/message_templates", null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .post(RequestBody.create(makeJson(request), MEDIA_TYPE_JSON));
        return execute(builder, MessageTemplate.class);
    }

    public ResourceResponse<MessageTemplate> getMessageTemplate(String templateId, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/message_templates/" + templateId, null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .get();
        return execute(builder, MessageTemplate.class);
    }

    public ResourceResponse<MessageTemplate> updateMessageTemplate(String templateId, JsonPatchDocument<MessageTemplatePatchModel> document, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/message_templates/" + templateId, null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .patch(RequestBody.create(makeJson(document.getOperations()), MEDIA_TYPE_JSON));
        return execute(builder, MessageTemplate.class);
    }

    public ResourceResponse<?> deleteMessageTemplate(String templateId, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/message_templates/" + templateId, null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .delete();
        return execute(builder, ResourceResponse.class);
    }

    public ResourceResponse<MessageTemplateValidationResponse> validateMessageTemplate(MessageTemplateValidationRequest request, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/message_templates/validate", null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .post(RequestBody.create(makeJson(request), MEDIA_TYPE_JSON));
        return execute(builder, MessageTemplateValidationResponse.class);
    }

    public ResourceResponse<MessageStream[]> getMessageStreams(MessageStreamsListOptions listOptions, RequestOptions requestOptions) throws IOException {
        HttpUrl url = buildUrl("v1/message_streams", listOptions);

        Request.Builder builder = buildRequest(requestOptions)
                .url(url)
                .get();
        return execute(builder, MessageStream[].class);
    }

    public ResourceResponse<MessageStream> createMessageStream(MessageStreamCreateRequest request, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/message_streams", null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .post(RequestBody.create(makeJson(request), MEDIA_TYPE_JSON));
        return execute(builder, MessageStream.class);
    }

    public ResourceResponse<MessageStream> getMessageStream(String streamId, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/message_streams/" + streamId, null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .get();
        return execute(builder, MessageStream.class);
    }

    public ResourceResponse<MessageStream> updateMessageStream(String streamId, JsonPatchDocument<MessageStreamPatchModel> document, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/message_streams/" + streamId, null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .patch(RequestBody.create(makeJson(document.getOperations()), MEDIA_TYPE_JSON));

        return execute(builder, MessageStream.class);
    }

    public ResourceResponse<?> deleteMessageStream(String streamId, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/message_streams/" + streamId, null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .delete();
        return execute(builder, ResourceResponse.class);
    }

    public ResourceResponse<MessageStream> archiveMessageStream(String streamId, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/message_streams/" + streamId + "/archive", null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .post(RequestBody.create(makeJson(null), MEDIA_TYPE_JSON));
        return execute(builder, MessageStream.class);
    }

    public ResourceResponse<MessageStream> unarchiveMessageStream(String streamId, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/message_streams/" + streamId + "/unarchive", null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .post(RequestBody.create(makeJson(null), MEDIA_TYPE_JSON));
        return execute(builder, MessageStream.class);
    }
    //endregion

    //region Money Balance
    public ResourceResponse<MoneyBalance> getMoneyBalances(RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/money_balances/", null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .get();
        return execute(builder, MoneyBalance.class);
    }

    public ResourceResponse<MoneyBalance> refreshMoneyBalances(RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/money_balances/refresh", null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .post(RequestBody.create(makeJson(null), MEDIA_TYPE_JSON));
        return execute(builder, MoneyBalance.class);
    }
    //endregion

    //region Transfers, Transfer Reversals
    public ResourceResponse<Transfer[]> getTransfers(TransferListOptions listOptions, RequestOptions requestOptions) throws IOException {
        HttpUrl url = buildUrl("v1/transfers", listOptions);

        Request.Builder builder = buildRequest(requestOptions)
                .url(url)
                .get();
        return execute(builder, Transfer[].class);
    }

    public ResourceResponse<Transfer> createTransfer(TransferCreateRequest request, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/transfers", null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .post(RequestBody.create(makeJson(request), MEDIA_TYPE_JSON));
        return execute(builder, Transfer.class);
    }

    public ResourceResponse<Transfer> getTransfer(String transferId, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/transfers" + transferId, null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .get();
        return execute(builder, Transfer.class);
    }

    public ResourceResponse<Transfer> updateTransfer(String transferId, JsonPatchDocument<TransferPatchModel> document, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/transfers" + transferId, null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .patch(RequestBody.create(makeJson(document.getOperations()), MEDIA_TYPE_JSON));
        return execute(builder, Transfer.class);
    }

    public ResourceResponse<TransferReversal[]> getTransferReversals(TransferReversalsListOptions listOptions, RequestOptions requestOptions) throws IOException {
        HttpUrl url = buildUrl("v1/transfer_reversals", listOptions);

        Request.Builder builder = buildRequest(requestOptions)
                .url(url)
                .get();
        return execute(builder, TransferReversal[].class);
    }

    public ResourceResponse<TransferReversal> createTransferReversal(TransferReversalCreateRequest request, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/transfer_reversals", null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .post(RequestBody.create(makeJson(request), MEDIA_TYPE_JSON));
        return execute(builder, TransferReversal.class);
    }

    public ResourceResponse<TransferReversal> updateTransferReversal(String transferId, JsonPatchDocument<TransferReversalPatchModel> document, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/transfer_reversals/" + transferId, null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .post(RequestBody.create(makeJson(document.getOperations()), MEDIA_TYPE_JSON));

        return execute(builder, TransferReversal.class);
    }

    public ResourceResponse<TransferReversal> getTransferReversal(String transferId, RequestOptions options) throws IOException {
        HttpUrl url = buildUrl("v1/transfer_reversals/" + transferId, null);

        Request.Builder builder = buildRequest(options)
                .url(url)
                .get();
        return execute(builder, TransferReversal.class);
    }
    //endregion


    //region Files and File Links
    public ResourceResponse<File[]> getFiles(FileListOptions listOptions, RequestOptions requestOptions) throws IOException {
        HttpUrl url = buildUrl("v1/files", listOptions);

        Request.Builder builder = buildRequest(requestOptions)
                .url(url)
                .get();
        return execute(builder, File[].class);
    }

    public ResourceResponse<File> getFile(String fileId, RequestOptions requestOptions) throws IOException {
        HttpUrl url = buildUrl("v1/files/" + fileId, null);

        Request.Builder builder = buildRequest(requestOptions)
                .url(url)
                .get();
        return execute(builder, File.class);
    }

    public ResourceResponse<File> uploadFile(FileCreateRequest request, RequestOptions requestOptions) throws IOException {
        HttpUrl url = buildUrl("v1/files", null);

        MultipartBody.Builder bodyBuilder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("purpose", request.getPurpose())
                .addFormDataPart("file",
                        request.getContent().getName(), RequestBody.create(request.getContent(), request.getMediaType()))
                .addFormDataPart("description", request.getDescription());

        if (request.getExpires() != null) {
            bodyBuilder.addFormDataPart("expires", ISO8601Utils.format(request.getExpires()));
        }

        RequestBody requestBody = bodyBuilder.build();

        Request.Builder builder = buildRequest(requestOptions)
                .url(url)
                .post(requestBody);
        return execute(builder, File.class);
    }

    public ResourceResponse<FileLink[]> getFileLinks(FileLinksListOptions listOptions, RequestOptions requestOptions) throws IOException {
        HttpUrl url = buildUrl("v1/file_links", listOptions);

        Request.Builder builder = buildRequest(requestOptions)
                .url(url)
                .get();
        return execute(builder, FileLink[].class);
    }

    public ResourceResponse<FileLink> createFileLink(FileLinkCreateRequest request, RequestOptions requestOptions) throws IOException {
        HttpUrl url = buildUrl("v1/file_links", null);

        Request.Builder builder = buildRequest(requestOptions)
                .url(url)
                .post(RequestBody.create(makeJson(request), MEDIA_TYPE_JSON));
        return execute(builder, FileLink.class);
    }

    public ResourceResponse<FileLink> getFileLink(String linkId, RequestOptions requestOptions) throws IOException {
        HttpUrl url = buildUrl("v1/file_links/" + linkId, null);

        Request.Builder builder = buildRequest(requestOptions)
                .url(url)
                .get();
        return execute(builder, FileLink.class);
    }

    public ResourceResponse<FileLink> updateFileLink(String linkId, JsonPatchDocument<FileLinkPatchModel> document, RequestOptions requestOptions) throws IOException {
        HttpUrl url = buildUrl("v1/file_links/" + linkId, null);

        Request.Builder builder = buildRequest(requestOptions)
                .url(url)
                .patch(RequestBody.create(makeJson(document.getOperations()), MEDIA_TYPE_JSON));
        return execute(builder, FileLink.class);
    }
    //endregion

    //region Webhook Endpoints, Events
    public ResourceResponse<WebhookEndpoint[]> getWebhookEndpoints(WebhookEndpointListOptions listOptions, RequestOptions requestOptions) throws IOException {
        HttpUrl url = buildUrl("v1/webhooks/endpoints", listOptions);

        Request.Builder builder = buildRequest(requestOptions)
                .url(url)
                .get();
        return execute(builder, WebhookEndpoint[].class);
    }

    public ResourceResponse<WebhookEndpoint> createWebhookEndpoint(WebhookEndpointCreateRequest request, RequestOptions requestOptions) throws IOException {
        HttpUrl url = buildUrl("v1/webhooks/endpoints", null);
        Request.Builder builder = buildRequest(requestOptions)
                .url(url)
                .post(RequestBody.create(makeJson(request), MEDIA_TYPE_JSON));
        return execute(builder, WebhookEndpoint.class);
    }

    public ResourceResponse<WebhookEndpoint> getWebhookEndpoint(String endpointId, RequestOptions requestOptions) throws IOException {
        HttpUrl url = buildUrl("v1/webhooks/endpoints/" + endpointId, null);

        Request.Builder builder = buildRequest(requestOptions)
                .url(url)
                .get();
        return execute(builder, WebhookEndpoint.class);
    }

    public ResourceResponse<WebhookEndpoint> updateWebhookEndpoint(String endpointId, JsonPatchDocument<WebhookEndpointPatchModel> document, RequestOptions requestOptions) throws IOException {
        HttpUrl url = buildUrl("v1/webhooks/endpoints/" + endpointId, null);

        Request.Builder builder = buildRequest(requestOptions)
                .url(url)
                .patch(RequestBody.create(makeJson(document.getOperations()), MEDIA_TYPE_JSON));
        return execute(builder, WebhookEndpoint.class);
    }

    public ResourceResponse<?> deleteWebhookEndpoint(String endpointId, RequestOptions requestOptions) throws IOException {
        HttpUrl url = buildUrl("v1/webhooks/endpoints/" + endpointId, null);

        Request.Builder builder = buildRequest(requestOptions)
                .url(url)
                .delete();
        return execute(builder, ResourceResponse.class);
    }

    public ResourceResponse<WebhookEvent[]> getWebhookEvents(EventListOptions listOptions, RequestOptions requestOptions) throws IOException {
        HttpUrl url = buildUrl("v1/events", listOptions);

        Request.Builder builder = buildRequest(requestOptions)
                .url(url)
                .get();
        return execute(builder, WebhookEvent[].class);
    }

    public ResourceResponse<WebhookEvent> getWebhookEvent(String eventId, RequestOptions requestOptions) throws IOException {
        HttpUrl url = buildUrl("v1/event/" + eventId, null);

        Request.Builder builder = buildRequest(requestOptions)
                .url(url)
                .get();

        return execute(builder, WebhookEvent.class);
    }
    //endregion

    //region Evaluation Reports

    public ResourceResponse<EvaluationReport[]> getEvaluationReports(EvaluationReportsListOptions listOptions, RequestOptions requestOptions) throws IOException {
        HttpUrl url = buildUrl("v1/evaluations/evaluation_reports", listOptions);

        Request.Builder builder = buildRequest(requestOptions)
                .url(url)
                .get();
        return execute(builder, EvaluationReport[].class);
    }

    public ResourceResponse<EvaluationReport> getEvaluationReport(String reportId, RequestOptions requestOptions) throws IOException {
        HttpUrl url = buildUrl("v1/evaluations/evaluation_reports/" + reportId, null);

        Request.Builder builder = buildRequest(requestOptions)
                .url(url)
                .get();
        return execute(builder, EvaluationReport.class);
    }

    //endregion

    //region IdentityVerification
    public ResourceResponse<IdentityVerification[]> getIdentityVerifications(IdentityVerificationListOptions listOptions, RequestOptions requestOptions) throws IOException {
        HttpUrl url = buildUrl("v1/identity/verifications", listOptions);

        Request.Builder builder = buildRequest(requestOptions)
                .url(url)
                .get();
        return execute(builder, IdentityVerification[].class);
    }

    public ResourceResponse<IdentityVerification> createIdentityVerification(IdentityVerificationCreateRequest request, RequestOptions requestOptions) throws IOException {
        HttpUrl url = buildUrl("v1/identity/verifications", null);

        Request.Builder builder = buildRequest(requestOptions)
                .url(url)
                .post(RequestBody.create(makeJson(request), MEDIA_TYPE_JSON));
        return execute(builder, IdentityVerification.class);
    }

    public ResourceResponse<IdentityVerification> getIdentityVerification(String id, RequestOptions requestOptions) throws IOException {
        HttpUrl url = buildUrl("v1/identity/verifications/" + id, null);

        Request.Builder builder = buildRequest(requestOptions)
                .url(url)
                .get();
        return execute(builder, IdentityVerification.class);
    }

    public ResourceResponse<IdentityVerification> updateIdentityVerification(String id,
                                                                             JsonPatchDocument<IdentityVerificationPatchModel> document, RequestOptions requestOptions) throws IOException {
        HttpUrl url = buildUrl("v1/identity/verifications/" + id, null);

        Request.Builder builder = buildRequest(requestOptions)
                .url(url)
                .patch(RequestBody.create(makeJson(document.getOperations()), MEDIA_TYPE_JSON));
        return execute(builder, IdentityVerification.class);
    }

    public ResourceResponse<IdentityVerification> cancelIdentityVerification(String id, RequestOptions requestOptions) throws IOException {
        HttpUrl url = buildUrl("v1/identity/verifications/" + id + "/cancel", null);

        Request.Builder builder = buildRequest(requestOptions)
                .url(url)
                .post(RequestBody.create(makeJson(null), MEDIA_TYPE_JSON));
        return execute(builder, IdentityVerification.class);
    }

    public ResourceResponse<IdentityVerification> redactIdentityVerification(String id, RequestOptions requestOptions) throws IOException {
        HttpUrl url = buildUrl("v1/identity/verifications/" + id + "/redact", null);

        Request.Builder builder = buildRequest(requestOptions)
                .url(url)
                .post(RequestBody.create(makeJson(null), MEDIA_TYPE_JSON));
        return execute(builder, IdentityVerification.class);
    }
    //endregion

    //region IdentityVerificationReports
    public ResourceResponse<IdentityVerificationReport[]> getIdentityVerificationReports(IdentityVerificationReportsListOptions listOptions, RequestOptions requestOptions) throws IOException {
        HttpUrl url = buildUrl("v1/identity/verifications_reports", listOptions);

        Request.Builder builder = buildRequest(requestOptions)
                .url(url)
                .get();
        return execute(builder, IdentityVerificationReport[].class);
    }

    public ResourceResponse<IdentityVerificationReport> getIdentityVerificationReport(String reportId, RequestOptions requestOptions) throws IOException {
        HttpUrl url = buildUrl("v1/identity/verifications_reports/" + reportId, null);

        Request.Builder builder = buildRequest(requestOptions)
                .url(url)
                .get();
        return execute(builder, IdentityVerificationReport.class);
    }
    //endRegion

    private static Request.Builder buildRequest(RequestOptions options) {
        Request.Builder builder = new Request.Builder();

        if (options.workspace != null && !options.workspace.isEmpty()) {
            builder.header("X-Workspace-Id", options.workspace);
        }

        if (options.idempotencyKey != null && !options.idempotencyKey.isEmpty()) {
            builder.header("X-Idempotency-Key", options.idempotencyKey);
        }

        boolean live = options.live != null && options.live;
        builder.header("X-Live-Mode", String.valueOf(live));


        return builder;
    }

    private static HttpUrl buildUrl(String path, @Nullable BasicListOptions listOptions) {
        HttpUrl.Builder builder = new HttpUrl.Builder();
        builder.scheme(SCHEME);
        builder.host(HOST);
        builder.addPathSegments(path);

        if (listOptions != null) {
            QueryValues args = new QueryValues();
            listOptions.populate(args);
            args.getQueryParameters(builder);
        }

        return builder.build();
    }
}
