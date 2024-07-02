package io.falu.services;

import io.falu.client.ResourceResponse;
import io.falu.common.Optional;
import io.falu.models.transfers.*;
import io.falu.models.transfers.reversals.TransferReversal;
import io.falu.models.transfers.reversals.TransferReversalCreateOptions;
import io.falu.models.transfers.reversals.TransferReversalsListOptions;
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
public class TransferServiceTests extends BaseApiServiceTests {

    private final Transfer transfer = Transfer.builder()
        .currency("kes")
        .id("tr_123")
        .created(new Date())
        .updated(new Date())
        .amount(4_000_00)
        .build();

    private final TransferReversal transferReversal = TransferReversal.builder()
        .amount(4_000_00)
        .transfer("tr_123")
        .currency("kes")
        .created(new Date())
        .updated(new Date())
        .build();

    @Mock
    private TransfersService service;

    @Test
    public void test_GetTransfersWorks() throws IOException {
        service = Mockito.mock(TransfersService.class, withSettings().useConstructor(options));

        TransferListOptions opt = TransferListOptions.builder()
            .count(1)
            .build();

        // given
        ResourceResponse<Transfer[]> expectedResponse = getResourceResponse(200, new Transfer[]{transfer});
        when(service.getTransfers(opt, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, new Transfer[]{transfer}));

        // when
        ResourceResponse<Transfer[]> response = service.getTransfers(opt, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_CreateTransferWorks() throws IOException {
        service = Mockito.mock(TransfersService.class, withSettings().useConstructor(options));

        TransferCreateRequestMpesaOptions mpesa = TransferCreateRequestMpesaOptions.builder()
            .customer(TransferCreateRequestMpesaToCustomer.builder().phone("+254722000000").build())
            .build();

        TransferCreateOptions request = TransferCreateOptions.builder()
            .amount(1000)
            .currency("kes")
            .purpose("salary")
            .mpesa(mpesa)
            .build();

        // given
        ResourceResponse<Transfer> expectedResponse = getResourceResponse(200, transfer);
        when(service.createTransfer(request, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, new Transfer[]{transfer}));

        // when
        ResourceResponse<Transfer> response = service.createTransfer(request, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_UpdateTransferWorks() throws IOException {
        service = Mockito.mock(TransfersService.class, withSettings().useConstructor(options));

        TransferUpdateOptions updateOptions = TransferUpdateOptions.builder()
            .description(Optional.of("cake"))
            .build();

        // given
        ResourceResponse<Transfer> expectedResponse = getResourceResponse(200, transfer);
        when(service.updateTransfer("tr_123", updateOptions, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, new Transfer[]{transfer}));

        // when
        ResourceResponse<Transfer> response = service.updateTransfer("tr_123", updateOptions, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_GetTransferWorks() throws IOException {
        service = Mockito.mock(TransfersService.class, withSettings().useConstructor(options));

        // given
        ResourceResponse<Transfer> expectedResponse = getResourceResponse(200, transfer);
        when(service.getTransfer("tr_123", requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, new Transfer[]{transfer}));

        // when
        ResourceResponse<Transfer> response = service.getTransfer("tr_123", requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_GetTransferReversalsWorks() throws IOException {
        service = Mockito.mock(TransfersService.class, withSettings().useConstructor(options));

        TransferReversalsListOptions opt = TransferReversalsListOptions.builder()
            .count(1)
            .build();

        // given
        ResourceResponse<TransferReversal[]> expectedResponse = getResourceResponse(200, new TransferReversal[]{transferReversal});
        when(service.getTransferReversals(opt, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, new TransferReversal[]{transferReversal}));

        // when
        ResourceResponse<TransferReversal[]> response = service.getTransferReversals(opt, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_CreateTransferReversalWorks() throws IOException {
        service = Mockito.mock(TransfersService.class, withSettings().useConstructor(options));

        TransferReversalCreateOptions request = TransferReversalCreateOptions.builder()
            .transfer("tr_123")
            .reason("customerRequested")
            .build();

        // given
        ResourceResponse<TransferReversal> expectedResponse = getResourceResponse(200, transferReversal);
        when(service.createTransferReversal(request, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, transferReversal));

        // when
        ResourceResponse<TransferReversal> response = service.createTransferReversal(request, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_GetTransferReversalWorks() throws IOException {
        service = Mockito.mock(TransfersService.class, withSettings().useConstructor(options));

        // given
        ResourceResponse<TransferReversal> expectedResponse = getResourceResponse(200, transferReversal);
        when(service.getTransferReversal("trr_123", requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, transferReversal));

        // when
        ResourceResponse<TransferReversal> response = service.getTransferReversal("trr_123", requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }
}
