package io.falu.services;

import io.falu.ApiResultCallback;
import io.falu.FaluClientOptions;
import io.falu.client.ResourceResponse;
import io.falu.models.payments.Payment;
import io.falu.models.payments.PaymentCreateRequest;
import org.jetbrains.annotations.NotNull;

public class PaymentsService extends BaseApiService {
    PaymentsService(FaluClientOptions options) {
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

}
