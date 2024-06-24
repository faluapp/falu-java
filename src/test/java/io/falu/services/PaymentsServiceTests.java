package io.falu.services;

import io.falu.client.ResourceResponse;
import io.falu.models.payments.*;
import io.falu.models.payments.authorization.PaymentAuthorization;
import io.falu.models.payments.authorization.PaymentAuthorizationUpdateOptions;
import io.falu.models.payments.authorization.PaymentAuthorizationsListOptions;
import io.falu.models.payments.refunds.PaymentRefund;
import io.falu.models.payments.refunds.PaymentRefundCreateOptions;
import io.falu.models.payments.refunds.PaymentRefundUpdateOptions;
import io.falu.models.payments.refunds.PaymentRefundsListOptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Date;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

@ExtendWith(MockitoExtension.class)
public class PaymentsServiceTests extends BaseApiServiceTests {

    private final Payment payment = Payment.builder()
        .id("pa_123")
        .currency("kes")
        .amount(100_00)
        .build();


    private final PaymentAuthorization paymentAuthorization = PaymentAuthorization.builder()
        .id("pauth_123")
        .currency("kes")
        .amount(5_000_00)
        .created(new Date())
        .updated(new Date())
        .build();

    private final PaymentRefund paymentRefund = PaymentRefund.builder()
        .id("pr_123")
        .currency("kes")
        .created(new Date())
        .updated(new Date())
        .amount(5_000_0)
        .build();

    @Mock
    private PaymentsService service;

    @Test
    public void test_GetPaymentsWorks() throws IOException {
        service = Mockito.mock(PaymentsService.class, withSettings().useConstructor(options));

        PaymentsListOptions opt = PaymentsListOptions.builder()
            .count(1)
            .build();

        // given
        ResourceResponse<Payment[]> expectedResponse = getResourceResponse(200, new Payment[]{payment});
        when(service.getPayments(opt, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, new Payment[]{payment}));

        // when
        ResourceResponse<Payment[]> response = service.getPayments(opt, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_GetPaymentWorks() throws IOException {
        service = Mockito.mock(PaymentsService.class, withSettings().useConstructor(options));

        // given
        ResourceResponse<Payment> expectedResponse = getResourceResponse(200, payment);
        when(service.getPayment("pa_123", requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, payment));

        // when
        ResourceResponse<Payment> response = service.getPayment("pa_123", requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_CreatePaymentWorks() throws IOException {
        service = Mockito.mock(PaymentsService.class, withSettings().useConstructor(options));

        PaymentCreateOptions request = PaymentCreateOptions.builder()
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

        // given
        ResourceResponse<Payment> expectedResponse = getResourceResponse(200, payment);
        when(service.createPayment(request, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, payment));

        // when
        ResourceResponse<Payment> response = service.createPayment(request, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_UpdatePaymentWorks() throws IOException {
        service = Mockito.mock(PaymentsService.class, withSettings().useConstructor(options));

        PaymentUpdateOptions patchModel = PaymentUpdateOptions.builder()
            .description("cake")
            .build();

        // given
        ResourceResponse<Payment> expectedResponse = getResourceResponse(200, payment);
        when(service.updatePayment("pa_123", patchModel, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, payment));

        // when
        ResourceResponse<Payment> response = service.updatePayment("pa_123", patchModel, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_GetPaymentAuthorizationsWorks() throws IOException {
        service = Mockito.mock(PaymentsService.class, withSettings().useConstructor(options));

        PaymentAuthorizationsListOptions opt = PaymentAuthorizationsListOptions.builder()
            .count(1)
            .build();

        // given
        ResourceResponse<PaymentAuthorization[]> expectedResponse = getResourceResponse(200, new PaymentAuthorization[]{paymentAuthorization});
        when(service.getPaymentAuthorizations(opt, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, new PaymentAuthorization[]{paymentAuthorization}));

        // when
        ResourceResponse<PaymentAuthorization[]> response = service.getPaymentAuthorizations(opt, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_GetPaymentAuthorizationWorks() throws IOException {
        service = Mockito.mock(PaymentsService.class, withSettings().useConstructor(options));

        // given
        ResourceResponse<PaymentAuthorization> expectedResponse = getResourceResponse(200, paymentAuthorization);
        when(service.getPaymentAuthorization("pauth_123", requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, paymentAuthorization));

        // when
        ResourceResponse<PaymentAuthorization> response = service.getPaymentAuthorization("pauth_123", requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_UpdatePaymentAuthorizationWorks() throws IOException {
        service = Mockito.mock(PaymentsService.class, withSettings().useConstructor(options));

        PaymentAuthorizationUpdateOptions updateOptions = PaymentAuthorizationUpdateOptions.builder()
            .description("cake")
            .build();

        // given
        ResourceResponse<PaymentAuthorization> expectedResponse = getResourceResponse(200, paymentAuthorization);
        when(service.updatePaymentAuthorization("pauth_123", updateOptions, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, paymentAuthorization));

        // when
        ResourceResponse<PaymentAuthorization> response = service.updatePaymentAuthorization("pauth_123", updateOptions, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_ApprovePaymentAuthorizationWorks() throws IOException {
        service = Mockito.mock(PaymentsService.class, withSettings().useConstructor(options));

        // given
        ResourceResponse<PaymentAuthorization> expectedResponse = getResourceResponse(200, paymentAuthorization);
        when(service.approvePaymentAuthorization("pauth_123", requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, paymentAuthorization));

        // when
        ResourceResponse<PaymentAuthorization> response = service.approvePaymentAuthorization("pauth_123", requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_DeclinePaymentAuthorizationWorks() throws IOException {
        service = Mockito.mock(PaymentsService.class, withSettings().useConstructor(options));

        // given
        ResourceResponse<PaymentAuthorization> expectedResponse = getResourceResponse(200, paymentAuthorization);
        when(service.declinePaymentAuthorization("pauth_123", requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, paymentAuthorization));

        // when
        ResourceResponse<PaymentAuthorization> response = service.declinePaymentAuthorization("pauth_123", requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_GetPaymentRefundsWorks() throws IOException {
        service = Mockito.mock(PaymentsService.class, withSettings().useConstructor(options));

        PaymentRefundsListOptions opt = PaymentRefundsListOptions.builder()
            .count(1)
            .build();

        // given
        ResourceResponse<PaymentRefund[]> expectedResponse = getResourceResponse(200, new PaymentRefund[]{paymentRefund});
        when(service.getPaymentRefunds(opt, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, new PaymentRefund[]{paymentRefund}));

        // when
        ResourceResponse<PaymentRefund[]> response = service.getPaymentRefunds(opt, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_CreatePaymentRefundWorks() throws IOException {
        service = Mockito.mock(PaymentsService.class, withSettings().useConstructor(options));

        PaymentRefundCreateOptions request = PaymentRefundCreateOptions.builder()
            .payment("pa_123")
            .reason("customerRequested")
            .build();

        // given
        ResourceResponse<PaymentRefund> expectedResponse = getResourceResponse(200, paymentRefund);
        when(service.createPaymentRefund(request, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, paymentRefund));

        // when
        ResourceResponse<PaymentRefund> response = service.createPaymentRefund(request, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_GetPaymentRefundWorks() throws IOException {
        service = Mockito.mock(PaymentsService.class, withSettings().useConstructor(options));

        // given
        ResourceResponse<PaymentRefund> expectedResponse = getResourceResponse(200, paymentRefund);
        when(service.getPaymentRefund("pr_123", requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, paymentRefund));

        // when
        ResourceResponse<PaymentRefund> response = service.getPaymentRefund("pr_123", requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_UpdatePaymentRefundWorks() throws IOException {
        service = Mockito.mock(PaymentsService.class, withSettings().useConstructor(options));

        PaymentRefundUpdateOptions updateOptions = PaymentRefundUpdateOptions.builder()
            .description("cake")
            .build();

        // given
        ResourceResponse<PaymentRefund> expectedResponse = getResourceResponse(200, paymentRefund);
        when(service.updatePaymentRefund("pr_123", updateOptions, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, paymentRefund));

        // when
        ResourceResponse<PaymentRefund> response = service.updatePaymentRefund("pr_123", updateOptions, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }
}
