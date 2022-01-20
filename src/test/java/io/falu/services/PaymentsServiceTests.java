package io.falu.services;

import io.falu.client.ResourceResponse;
import io.falu.client.patch.JsonPatchDocument;
import io.falu.models.payments.MpesaPaymentRequest;
import io.falu.models.payments.Payment;
import io.falu.models.payments.PaymentCreateRequest;
import io.falu.models.payments.PaymentPatchModel;
import io.falu.models.payments.authorization.PaymentAuthorization;
import io.falu.models.payments.authorization.PaymentAuthorizationPatchModel;
import io.falu.models.payments.refunds.PaymentRefund;
import io.falu.models.payments.refunds.PaymentRefundPatchModel;
import io.falu.models.payments.refunds.PaymentRefundReason;
import io.falu.models.payments.refunds.PaymentRefundRequest;
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
    public void test_UpdatePaymentWorks() throws IOException {
        PaymentsService service = new PaymentsService(options);

        RequestOptions requestOptions = RequestOptions.builder()
                .live(false)
                .build();

        JsonPatchDocument<PaymentPatchModel> document = new JsonPatchDocument<PaymentPatchModel>()
                .replace("description", "cake");

        ResourceResponse<Payment> response = service.updatePayment("pa_123", document, requestOptions);
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
    public void test_UpdatePaymentAuthorizationWorks() throws IOException {
        PaymentsService service = new PaymentsService(options);

        JsonPatchDocument<PaymentAuthorizationPatchModel> document = new JsonPatchDocument<PaymentAuthorizationPatchModel>()
                .replace("description", "cake");

        ResourceResponse<PaymentAuthorization> response = service.updatePaymentAuthorization("pauth_123", document, requestOptions);
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

    @Test
    public void test_GetPaymentRefundsWorks() throws IOException {
        PaymentsService service = new PaymentsService(options);

        ResourceResponse<PaymentRefund[]> response = service.getPaymentRefunds(requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_CreatePaymentRefundWorks() throws IOException {
        PaymentsService service = new PaymentsService(options);

        PaymentRefundRequest request = PaymentRefundRequest.builder()
                .payment("pa_123")
                .reason(PaymentRefundReason.CUSTOMER_REQUESTED)
                .build();

        RequestOptions requestOptions = RequestOptions.builder()
                .live(false)
                .build();

        ResourceResponse<PaymentRefund> response = service.createPaymentRefund(request, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_GetPaymentRefundWorks() throws IOException {
        PaymentsService service = new PaymentsService(options);

        ResourceResponse<PaymentRefund> response = service.getPaymentRefund("pr_123", requestOptions);
        Assertions.assertEquals(204, response.getStatusCode());
        Assertions.assertNull(response.getResource());
    }

    @Test
    public void test_UpdatePaymentRefundWorks() throws IOException {
        PaymentsService service = new PaymentsService(options);

        JsonPatchDocument<PaymentRefundPatchModel> document = new JsonPatchDocument<PaymentRefundPatchModel>()
                .replace("replace", "cake");

        ResourceResponse<PaymentRefund> response = service.updatePaymentRefund("pr_123", document, requestOptions);
        Assertions.assertEquals(204, response.getStatusCode());
        Assertions.assertNull(response.getResource());
    }
}
