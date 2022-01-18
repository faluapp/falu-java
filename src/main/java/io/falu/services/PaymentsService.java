package io.falu.services;

import io.falu.FaluClientOptions;
import io.falu.client.ResourceResponse;
import io.falu.models.payments.Payment;
import io.falu.models.payments.PaymentCreateRequest;
import io.falu.models.payments.authorization.PaymentAuthorization;
import io.falu.models.payments.refunds.PaymentRefund;
import io.falu.models.payments.refunds.PaymentRefundRequest;
import io.falu.networking.RequestOptions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

public class PaymentsService extends BaseApiService {
    public PaymentsService(@NotNull FaluClientOptions options) {
        super(options);
    }

    /**
     * List payments.
     *
     * @param requestOptions additional info to add to the request.
     */
    public ResourceResponse<Payment[]> getPayments(@Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().getPayments(requestOptions);
    }

    /**
     * Retrieve a payment.
     *
     * @param paymentId      unique identifier for the payment.
     * @param requestOptions additional info to add to the request.
     */
    public ResourceResponse<Payment> getPayment(@NotNull String paymentId, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().getPayment(paymentId, requestOptions);
    }


    /**
     * Create payment.
     *
     * @param request        the request object.
     * @param requestOptions additional info to add to the request.
     */
    public ResourceResponse<Payment> createPayment(@NotNull PaymentCreateRequest request, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().createPayment(request, requestOptions);

    }

    /**
     * List payment authorizations.
     *
     * @param requestOptions additional info to add to the request.
     */
    public ResourceResponse<PaymentAuthorization[]> getPaymentAuthorizations(@Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().getPaymentAuthorizations(requestOptions);
    }

    /**
     * Get payment authorization.
     *
     * @param authorizationId unique identifier for the payment authorization.
     * @param requestOptions  additional info to add to the request.
     */
    public ResourceResponse<PaymentAuthorization> getPaymentAuthorization(@NotNull String authorizationId, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().getPaymentAuthorization(authorizationId, requestOptions);
    }

    /**
     * Approve payment authorization.
     *
     * @param authorizationId unique identifier for the payment authorization.
     * @param requestOptions  additional info to add to the request.
     */
    public ResourceResponse<PaymentAuthorization> approvePaymentAuthorization(@NotNull String authorizationId, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().approvePaymentAuthorization(authorizationId, requestOptions);
    }

    /**
     * Decline payment authorization.
     *
     * @param authorizationId unique identifier for the payment authorization.
     * @param requestOptions  additional info to add to the request.
     */
    public ResourceResponse<PaymentAuthorization> declinePaymentAuthorization(@NotNull String authorizationId, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().declinePaymentAuthorization(authorizationId, requestOptions);
    }

    /**
     * List payment refunds.
     *
     * @param requestOptions additional info to add to the request.
     */
    public ResourceResponse<PaymentRefund[]> getPaymentRefunds(@Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().getPaymentRefunds(requestOptions);
    }

    /**
     * Create payment refund.
     *
     * @param request        the request object.
     * @param requestOptions additional info to add to the request.
     */
    public ResourceResponse<PaymentRefund> createPaymentRefund(@NotNull PaymentRefundRequest request, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().createPaymentRefund(request, requestOptions);
    }

    /**
     * Get payment refund.
     *
     * @param refundId       unique identifier for the payment refund.
     * @param requestOptions additional info to add to the request.
     */
    public ResourceResponse<PaymentRefund> getPaymentRefund(@NotNull String refundId, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().getPaymentRefund(refundId, requestOptions);
    }
}
