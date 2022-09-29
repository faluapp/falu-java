package io.falu.services;

import io.falu.client.ResourceResponse;
import io.falu.models.temporaryKeys.TemporaryKey;
import io.falu.models.temporaryKeys.TemporaryKeyCreateRequest;
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
public class TemporaryKeyServiceTests extends BaseApiServiceTests {

    private final TemporaryKey temporaryKey = TemporaryKey.builder()
            .id("key_123")
            .objects(new String[]{"idv_1234567890"})
            .expires(new Date())
            .secret("ftkt_1234567890")
            .build();

    @Mock
    private TemporaryKeyService service;

    @Test
    public void test_CreateTemporaryKeyWorks() throws IOException {
        service = Mockito.mock(TemporaryKeyService.class, withSettings().useConstructor(options));

        TemporaryKeyCreateRequest request = TemporaryKeyCreateRequest.builder()
                .identityVerification("idv_1234567890")
                .build();

        // given
        ResourceResponse<TemporaryKey> expectedResponse = getResourceResponse(200, temporaryKey);
        when(service.createTemporaryKey(request, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, temporaryKey));

        // when
        ResourceResponse<TemporaryKey> response = service.createTemporaryKey(request, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_DeleteTemporaryKeyWorks() throws IOException {
        service = Mockito.mock(TemporaryKeyService.class, withSettings().useConstructor(options));

        // given
        ResourceResponse expectedResponse = getResourceResponse(200, null);
        when(service.deleteTemporaryKey("key_123", requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, temporaryKey));

        // when
        ResourceResponse response = service.deleteTemporaryKey("key_123", requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
    }
}
