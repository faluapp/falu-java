package io.falu.services;

import io.falu.AppInformation;
import io.falu.FaluClientOptions;
import io.falu.client.ResourceResponse;
import io.falu.models.identity.*;
import io.falu.networking.RequestOptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Date;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IdentityServiceTests {

    private final IdentityRecord identityRecord = IdentityRecord.builder()
            .id("idt_123")
            .created(new Date())
            .updated(new Date())
            .documentType(IdentityDocumentType.NATIONAL_ID)
            .documentNumber("123")
            .country("KE")
            .name("Cake")
            .birthday(new Date())
            .gender(Gender.MALE)
            .build();

    private final MarketingResult marketingResult = MarketingResult.builder()
            .created(new Date())
            .updated(new Date())
            .phones(new String[]{"+254722000000", "+255722000000"})
            .build();


    @Test
    public void test_SearchIdentityWork() {
        try (MockedConstruction<IdentityService> mocked = Mockito.mockConstruction(IdentityService.class)) {
            AppInformation information = AppInformation.builder()
                    .name("Java-Tests")
                    .version("1.0")
                    .build();
            FaluClientOptions options = FaluClientOptions.builder()
                    .apiKey("")
                    .enableLogging(true)
                    .appInformation(information)
                    .build();

            RequestOptions requestOptions = RequestOptions
                    .builder()
                    .idempotencyKey("05bc69eb-218d-46f2-8812-5bede8592abf")
                    .live(false)
                    .build();

            ResourceResponse<IdentityRecord> response = new ResourceResponse<>();
            response.setResource(identityRecord);
            response.setStatusCode(200);

            IdentitySearchModel searchModel = IdentitySearchModel.builder()
                    .documentNumber(identityRecord.getDocumentNumber())
                    .documentType(identityRecord.getDocumentType())
                    .country(identityRecord.getCountry())
                    .build();

            IdentityService service = new IdentityService(options);

            when(service.searchIdentity(searchModel, requestOptions)).thenReturn(response);

            Assertions.assertEquals(200, response.getStatusCode());
            Assertions.assertNotNull(response.getResource());
            Assertions.assertEquals(identityRecord.getDocumentNumber(), response.getResource().getDocumentNumber());
            Assertions.assertEquals(identityRecord.getDocumentType(), response.getResource().getDocumentType());
            Assertions.assertEquals(identityRecord.getCountry(), response.getResource().getCountry());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
