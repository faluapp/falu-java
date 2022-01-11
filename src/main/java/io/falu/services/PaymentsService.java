package io.falu.services;

import io.falu.ApiResultCallback;
import io.falu.FaluClientOptions;
import io.falu.client.ResourceResponse;
import io.falu.models.payments.Payment;
import io.falu.models.payments.PaymentCreateRequest;
import io.falu.models.payments.authorization.PaymentAuthorization;
import io.falu.models.payments.refunds.PaymentRefund;
import io.falu.models.payments.refunds.PaymentRefundRequest;
import org.jetbrains.annotations.NotNull;

public class PaymentsService extends BaseApiService {
    public PaymentsService(FaluClientOptions options) {
        super(options);
    }

    /**
     * List payments.
     *
     * @param callback the result object for the request.
     */
    public void getPayments(@NotNull ApiResultCallback<Payment[]> callback) {
        try {
            ResourceResponse<Payment[]> response = getApiClient().getPayments();
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    /**
     * Retrieve a payment.
     *
     * @param paymentId unique identifier for the payment.
     * @param callback  the result object for the request.
     */
    public void getPayment(@NotNull String paymentId, @NotNull ApiResultCallback<Payment> callback) {
        try {
            ResourceResponse<Payment> response = getApiClient().getPayment(paymentId);
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }


    /**
     * Create payment.
     *
     * @param request  the request object.
     * @param callback the result object for the request.
     */
    public void createPayment(@NotNull PaymentCreateRequest request, @NotNull ApiResultCallback<Payment> callback) {
        try {
            ResourceResponse<Payment> response = getApiClient().createPayment(request);
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    public void getPaymentAuthorizations(@NotNull ApiResultCallback<PaymentAuthorization[]> callback) {
        try {
            ResourceResponse<PaymentAuthorization[]> response = getApiClient().getPaymentAuthorizations();
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    public void getPaymentAuthorization(@NotNull String authorizationId, @NotNull ApiResultCallback<PaymentAuthorization> callback) {
        try {
            ResourceResponse<PaymentAuthorization> response = getApiClient().getPaymentAuthorization(authorizationId);
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    public void approvePaymentAuthorization(@NotNull String authorizationId, @NotNull ApiResultCallback<PaymentAuthorization> callback) {
        try {
            ResourceResponse<PaymentAuthorization> response = getApiClient().approvePaymentAuthorization(authorizationId);
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    public void declinePaymentAuthorization(@NotNull String authorizationId, @NotNull ApiResultCallback<PaymentAuthorization> callback) {
        try {
            ResourceResponse<PaymentAuthorization> response = getApiClient().declinePaymentAuthorization(authorizationId);
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    public void getPaymentRefunds(@NotNull ApiResultCallback<PaymentRefund[]> callback) {
        try {
            ResourceResponse<PaymentRefund[]> response = getApiClient().getPaymentRefunds();
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    public void createPaymentRefund(@NotNull PaymentRefundRequest request, @NotNull ApiResultCallback<PaymentRefund> callback) {
        try {
            ResourceResponse<PaymentRefund> response = getApiClient().createPaymentRefund(request);
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    public void getPaymentRefund(@NotNull String refundId, @NotNull ApiResultCallback<PaymentRefund> callback) {
        try {
            ResourceResponse<PaymentRefund> response = getApiClient().getPaymentRefund(refundId);
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }
}
