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

    public void getPayments(@NotNull ApiResultCallback<Payment[]> callback) {
        try {
            ResourceResponse<Payment[]> response = getApiClient().getPayments();
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    public void getPayment(@NotNull String paymentId, @NotNull ApiResultCallback<Payment> callback) {
        try {
            ResourceResponse<Payment> response = getApiClient().getPayment(paymentId);
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    public void createPayment(@NotNull PaymentCreateRequest request, @NotNull ApiResultCallback<Payment> callback) {
        try {
            ResourceResponse<Payment> response = getApiClient().createPayment(request);
            handleResponse(response, callback);
        } catch (Exception e) {
            callback.onError(e);
        }
    }

}
