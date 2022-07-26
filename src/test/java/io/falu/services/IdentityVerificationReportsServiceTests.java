package io.falu.services;

import io.falu.client.ResourceResponse;
import io.falu.models.identiityVerificationReports.IdentityVerificationReport;
import io.falu.models.identiityVerificationReports.IdentityVerificationReportsListOptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Date;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

public class IdentityVerificationReportsServiceTests extends BaseApiServiceTests {

    private final IdentityVerificationReport report = IdentityVerificationReport.builder()
            .id("idvr_0o5Fs0EELR0fUjHjbCnEtdUwQe3")
            .created(new Date())
            .updated(new Date())
            .workspace("wksp_602a8dd0a54847479a874de4")
            .build();

    @Mock
    private IdentityVerificationReportsService service;

    @Test
    public void test_GettingIdentificationVerificationReportWorks() throws IOException {
        service = Mockito.mock(IdentityVerificationReportsService.class, withSettings().useConstructor(options));

        // given
        IdentityVerificationReportsListOptions opt = IdentityVerificationReportsListOptions.builder()
                .count(1)
                .build();

        ResourceResponse<IdentityVerificationReport[]> response = getResourceResponse(200, new IdentityVerificationReport[]{report});
        when(service.getIdentityVerificationReports(opt, requestOptions)).thenReturn(response);

        mockWebServer.enqueue(getMockedResponse(200, new IdentityVerificationReport[]{report}));

        // when
        ResourceResponse<IdentityVerificationReport[]> resp = service.getIdentityVerificationReports(opt, requestOptions);
        Assertions.assertNotNull(resp);
        Assertions.assertTrue(response.getResource().length > 0);
    }

    @Test
    public void test_GetIdentityVerificationWorks() throws IOException {
        service = Mockito.mock(IdentityVerificationReportsService.class, withSettings().useConstructor(options));

        // given
        ResourceResponse<IdentityVerificationReport> expectedResponse = getResourceResponse(200, report);
        when(service.getIdentityVerificationReport("idv_0o5Fs0EELR0fUjHjbCnEtdUwQe3", requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, report));

        // when
        ResourceResponse<IdentityVerificationReport> response = service.getIdentityVerificationReport("idv_0o5Fs0EELR0fUjHjbCnEtdUwQe3", requestOptions);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(200, response.getStatusCode());
    }
}
