package io.falu.services;

import io.falu.client.ResourceResponse;
import io.falu.models.identity.*;
import io.falu.networking.RequestOptions;
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
public class IdentityServiceTests extends BaseApiServiceTests {

    private final IdentityRecord identityRecord = IdentityRecord.builder()
            .id("idt_123")
            .created(new Date())
            .updated(new Date())
            .documentType("nationalId")
            .documentNumber("123")
            .country("ken")
            .name("Cake")
            .birthday(new Date())
            .gender("male")
            .build();

    private final MarketingResult marketingResult = MarketingResult.builder()
            .created(new Date())
            .updated(new Date())
            .phones(new String[]{"+254722000000", "+255722000000"})
            .build();

    @Mock
    private IdentityService service;

    @Test
    public void test_SearchIdentityWork() throws IOException {
        service = Mockito.mock(IdentityService.class, withSettings().useConstructor(options));

        RequestOptions requestOptions = RequestOptions
                .builder()
                .idempotencyKey("05bc69eb-218d-46f2-8812-5bede8592abf")
                .live(false)
                .build();

        IdentitySearchModel searchModel = IdentitySearchModel.builder()
                .documentNumber(identityRecord.getDocumentNumber())
                .documentType(IdentityDocumentType.NATIONAL_ID)
                .country(identityRecord.getCountry())
                .build();

        // given
        ResourceResponse<IdentityRecord> expectedResponse = getResourceResponse(200, identityRecord);
        when(service.searchIdentity(searchModel, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, identityRecord));

        // when
        ResourceResponse<IdentityRecord> response = service.searchIdentity(searchModel, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
        Assertions.assertEquals(identityRecord.getDocumentNumber(), response.getResource().getDocumentNumber());
        Assertions.assertEquals(identityRecord.getDocumentType(), response.getResource().getDocumentType());
        Assertions.assertEquals(identityRecord.getCountry(), response.getResource().getCountry());
    }


    @Test
    public void test_MarketingResultsWork() throws IOException {
        service = Mockito.mock(IdentityService.class, withSettings().useConstructor(options));

        RequestOptions requestOptions = RequestOptions
                .builder()
                .idempotencyKey("05bc69eb-218d-46f2-8812-5bede8592abf")
                .live(false)
                .build();

        MarketingListOptions listOptions = MarketingListOptions.builder()
                .count(1)
                .build();

        // given
        ResourceResponse<MarketingResult[]> expectedResponse = getResourceResponse(200, new MarketingResult[]{marketingResult});
        when(service.getMarketingResults(listOptions, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, new MarketingResult[]{marketingResult}));

        // when
        ResourceResponse<MarketingResult[]> response = service.getMarketingResults(listOptions, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
        Assertions.assertTrue(response.getResource().length > 0);
    }
}
