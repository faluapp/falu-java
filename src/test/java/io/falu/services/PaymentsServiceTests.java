package io.falu.services;

import io.falu.client.ResourceResponse;
import io.falu.models.payments.MpesaPaymentRequest;
import io.falu.models.payments.Payment;
import io.falu.models.payments.PaymentCreateRequest;
import io.falu.models.payments.authorization.PaymentAuthorization;
import io.falu.networking.RequestOptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class PaymentsServiceTests extends BaseApiServiceTests {

    @Test
    public void test_GetPaymentsWorks() throws IOException {
        PaymentsService service = new PaymentsService(options);

        ResourceResponse<Payment[]> response = service.getPayments(requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_GetPaymentWorks() throws IOException {
        PaymentsService service = new PaymentsService(options);

        ResourceResponse<Payment> response = service.getPayment("pa_123", requestOptions);
        Assertions.assertEquals(204, response.getStatusCode());
        Assertions.assertNull(response.getResource());
    }

    @Test
    public void test_CreatePaymentWorks() throws IOException {
        PaymentsService service = new PaymentsService(options);

        PaymentCreateRequest request = PaymentCreateRequest.builder()
                .amount(1000)
                .currency("kes")
                .mpesa(MpesaPaymentRequest.builder()
                        .phone("+254722000000")
                        .paybill(true)
                        .reference("INV-2020-12-01-1234")
                        .destination("5001")
                        .build()
                )
                .build();

        RequestOptions requestOptions = RequestOptions.builder()
                .live(false)
                .build();

        ResourceResponse<Payment> response = service.createPayment(request, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_GetPaymentAuthorizationsWorks() throws IOException {
        PaymentsService service = new PaymentsService(options);

        ResourceResponse<PaymentAuthorization[]> response = service.getPaymentAuthorizations(requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_GetPaymentAuthorizationWorks() throws IOException {
        PaymentsService service = new PaymentsService(options);

        ResourceResponse<PaymentAuthorization> response = service.getPaymentAuthorization("pauth_123", requestOptions);
        Assertions.assertEquals(204, response.getStatusCode());
        Assertions.assertNull(response.getResource());
    }

    @Test
    public void test_ApprovePaymentAuthorizationWorks() throws IOException {
        PaymentsService service = new PaymentsService(options);

        RequestOptions requestOptions = RequestOptions.builder()
                .live(false)
                .build();

        ResourceResponse<PaymentAuthorization> response = service.approvePaymentAuthorization("pauth_123", requestOptions);
        Assertions.assertEquals(204, response.getStatusCode());
        Assertions.assertNull(response.getResource());
    }

    @Test
    public void test_DeclinePaymentAuthorizationWorks() throws IOException {
        PaymentsService service = new PaymentsService(options);

        RequestOptions requestOptions = RequestOptions.builder()
                .live(false)
                .build();

        ResourceResponse<PaymentAuthorization> response = service.declinePaymentAuthorization("pauth_123", requestOptions);
        Assertions.assertEquals(204, response.getStatusCode());
        Assertions.assertNull(response.getResource());
    }
}
