package io.falu.services;

import io.falu.client.ResourceResponse;
import io.falu.models.identityVerification.IdentityVerification;
import io.falu.models.identityVerification.IdentityVerificationCreateOptions;
import io.falu.models.identityVerification.IdentityVerificationListOptions;
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
public class IdentityVerificationServiceTests extends BaseApiServiceTests {

    private final IdentityVerification verification = IdentityVerification.builder()
            .id("idv_0o5Fs0EELR0fUjHjbCnEtdUwQe3")
            .created(new Date())
            .updated(new Date())
            .workspace("wksp_602a8dd0a54847479a874de4")
            .build();

    @Mock
    private IdentificationVerificationService service;

    @Test
    public void test_GettingIdentificationVerificationWorks() throws IOException {
        service = Mockito.mock(IdentificationVerificationService.class, withSettings().useConstructor(options));

        // given
        IdentityVerificationListOptions opt = IdentityVerificationListOptions.builder()
                .count(1)
                .build();

        ResourceResponse<IdentityVerification[]> response = getResourceResponse(200, new IdentityVerification[]{verification});
        when(service.getIdentityVerifications(opt, requestOptions)).thenReturn(response);

        mockWebServer.enqueue(getMockedResponse(200, new IdentityVerification[]{verification}));

        // when
        ResourceResponse<IdentityVerification[]> resp = service.getIdentityVerifications(opt, requestOptions);
        Assertions.assertNotNull(resp);
        Assertions.assertTrue(response.getResource().length > 0);
    }

    @Test
    public void test_GetIdentityVerificationWorks() throws IOException {
        service = Mockito.mock(IdentificationVerificationService.class, withSettings().useConstructor(options));

        // given
        ResourceResponse<IdentityVerification> expectedResponse = getResourceResponse(200, verification);
        when(service.getIdentityVerification("idv_0o5Fs0EELR0fUjHjbCnEtdUwQe3", requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, verification));

        // when
        ResourceResponse<IdentityVerification> response = service.getIdentityVerification("idv_0o5Fs0EELR0fUjHjbCnEtdUwQe3", requestOptions);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void test_CreateIdentityVerificationWorks() throws IOException {
        service = Mockito.mock(IdentificationVerificationService.class, withSettings().useConstructor(options));

        // given
        IdentityVerificationCreateOptions request = IdentityVerificationCreateOptions.builder()
                .returnUrl("https://example.com")
                .type("id_number")
                .build();

        ResourceResponse<IdentityVerification> expectedResponse = getResourceResponse(200, verification);
        when(service.createIdentityVerification(request, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, verification));

        // when
        ResourceResponse<IdentityVerification> response = service.createIdentityVerification(request, requestOptions);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(200, response.getStatusCode());
    }


    @Test
    public void test_CancelIdentityVerificationWorks() throws IOException {
        service = Mockito.mock(IdentificationVerificationService.class, withSettings().useConstructor(options));

        // given
        ResourceResponse<IdentityVerification> expectedResponse = getResourceResponse(200, verification);
        when(service.cancelIdentityVerification("idv_0o5Fs0EELR0fUjHjbCnEtdUwQe3", requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, verification));

        // when
        ResourceResponse<IdentityVerification> response = service.cancelIdentityVerification("idv_0o5Fs0EELR0fUjHjbCnEtdUwQe3", requestOptions);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void test_RedactIdentityVerificationWorks() throws IOException {
        service = Mockito.mock(IdentificationVerificationService.class, withSettings().useConstructor(options));

        // given
        ResourceResponse<IdentityVerification> expectedResponse = getResourceResponse(200, verification);
        when(service.redactIdentityVerification("idv_0o5Fs0EELR0fUjHjbCnEtdUwQe3", requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, verification));

        // when
        ResourceResponse<IdentityVerification> response = service.redactIdentityVerification("idv_0o5Fs0EELR0fUjHjbCnEtdUwQe3", requestOptions);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(200, response.getStatusCode());
    }
}
