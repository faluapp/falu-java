package io.falu.services;

import io.falu.client.ResourceResponse;
import io.falu.client.patch.JsonPatchDocument;
import io.falu.models.AbstractCreationRequest;
import io.falu.models.payments.refunds.PaymentRefundReason;
import io.falu.models.transfers.*;
import io.falu.models.transfers.reversals.TransferReversal;
import io.falu.models.transfers.reversals.TransferReversalCreateRequest;
import io.falu.networking.RequestOptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class TransferServiceTests extends BaseApiServiceTests {

    @Test
    public void test_GetTransfersWorks() throws IOException {
        TransfersService service = new TransfersService(options);

        ResourceResponse<Transfer[]> response = service.getTransfers(requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_CreateTransferWorks() throws IOException {
        TransfersService service = new TransfersService(options);

        TransferCreateRequestMpesa mpesa = TransferCreateRequestMpesa.builder()
                .customer(TransferCreateRequestMpesaToCustomer.builder().phone("+254722000000").build())
                .build();

        TransferCreateRequest request = TransferCreateRequest.builder()
                .amount(1000)
                .currency("kes")
                .purpose(TransferPurpose.SALARY)
                .mpesa(mpesa)
                .build();
        RequestOptions requestOptions = RequestOptions.builder()
                .live(false)
                .build();

        ResourceResponse<Transfer> response = service.createTransfer(request, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_UpdateTransferWorks() throws IOException {
        TransfersService service = new TransfersService(options);

        RequestOptions requestOptions = RequestOptions.builder()
                .live(false)
                .build();

        JsonPatchDocument<TransferPatchModel> document = new JsonPatchDocument<TransferPatchModel>()
                .replace("description", "cake");

        ResourceResponse<Transfer> response = service.updateTransfer("tr_123", document, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_GetTransferWorks() throws IOException {
        TransfersService service = new TransfersService(options);

        ResourceResponse<Transfer> response = service.getTransfer("tr_123", requestOptions);
        Assertions.assertEquals(204, response.getStatusCode());
        Assertions.assertNull(response.getResource());
    }

    @Test
    public void test_GetTransferReversalsWorks() throws IOException {
        TransfersService service = new TransfersService(options);

        ResourceResponse<TransferReversal[]> response = service.getTransferReversals(requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_CreateTransferReversalWorks() throws IOException {
        TransfersService service = new TransfersService(options);

        TransferReversalCreateRequest request = TransferReversalCreateRequest.builder()
                .transfer("tr_123")
                .reason(PaymentRefundReason.CUSTOMER_REQUESTED)
                .build();

        RequestOptions requestOptions = RequestOptions.builder()
                .live(false)
                .build();

        ResourceResponse<TransferReversal> response = service.createTransferReversal(request, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_GetTransferReversalWorks() throws IOException {
        TransfersService service = new TransfersService(options);

        ResourceResponse<TransferReversal> response = service.getTransferReversal("trr_123", requestOptions);
        Assertions.assertEquals(204, response.getStatusCode());
        Assertions.assertNull(response.getResource());
    }
}
