package io.falu.services;

import io.falu.FaluClientOptions;
import io.falu.client.ResourceResponse;
import io.falu.models.payments.Payment;
import io.falu.models.payments.PaymentCreateOptions;
import io.falu.models.payments.PaymentUpdateOptions;
import io.falu.models.payments.PaymentsListOptions;
import io.falu.models.payments.authorization.PaymentAuthorization;
import io.falu.models.payments.authorization.PaymentAuthorizationUpdateOptions;
import io.falu.models.payments.authorization.PaymentAuthorizationsListOptions;
import io.falu.models.payments.refunds.PaymentRefund;
import io.falu.models.payments.refunds.PaymentRefundCreateOptions;
import io.falu.models.payments.refunds.PaymentRefundUpdateOptions;
import io.falu.models.payments.refunds.PaymentRefundsListOptions;
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
    public ResourceResponse<Payment[]> getPayments(@Nullable PaymentsListOptions listOptions, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().getPayments(listOptions, requestOptions);
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
    public ResourceResponse<Payment> createPayment(@NotNull PaymentCreateOptions request, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().createPayment(request, requestOptions);
    }

    /**
     * Retrieve a payment.
     *
     * @param paymentId     unique identifier for the payment.
     * @param updateOptions the payment update options.
     * @param options       additional info to add to the request.
     */
    public ResourceResponse<Payment> updatePayment(@NotNull String paymentId, @NotNull PaymentUpdateOptions updateOptions,
                                                   @Nullable RequestOptions options) throws IOException {

        return getApiClient().updatePayment(paymentId, updateOptions, options);
    }

    /**
     * List payment authorizations.
     *
     * @param requestOptions additional info to add to the request.
     */
    public ResourceResponse<PaymentAuthorization[]> getPaymentAuthorizations(@Nullable PaymentAuthorizationsListOptions listOptions, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().getPaymentAuthorizations(listOptions, requestOptions);
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
     * Update payment authorization.
     *
     * @param authorizationId unique identifier for the payment authorization.
     * @param updateOptions   the Payment Auth update options.
     * @param requestOptions  additional info to add to the request.
     */
    public ResourceResponse<PaymentAuthorization> updatePaymentAuthorization(@NotNull String authorizationId, @NotNull PaymentAuthorizationUpdateOptions updateOptions, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().updatePaymentAuthorization(authorizationId, updateOptions, requestOptions);
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
    public ResourceResponse<PaymentRefund[]> getPaymentRefunds(@Nullable PaymentRefundsListOptions listOptions, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().getPaymentRefunds(listOptions, requestOptions);
    }

    /**
     * Create payment refund.
     *
     * @param request        the request object.
     * @param requestOptions additional info to add to the request.
     */
    public ResourceResponse<PaymentRefund> createPaymentRefund(@NotNull PaymentRefundCreateOptions request, @Nullable RequestOptions requestOptions) throws IOException {
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

    /**
     * Get payment refund.
     *
     * @param refundId       unique identifier for the payment refund.
     * @param updateOptions  the payment update options .
     * @param requestOptions additional info to add to the request.
     */
    public ResourceResponse<PaymentRefund> updatePaymentRefund(@NotNull String refundId, @NotNull PaymentRefundUpdateOptions updateOptions, @Nullable RequestOptions requestOptions) throws IOException {
        return getApiClient().updatePaymentRefund(refundId, updateOptions, requestOptions);
    }
}
