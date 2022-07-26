package io.falu.services;

import io.falu.client.ResourceResponse;
import io.falu.models.evaluationReports.EvaluationReport;
import io.falu.models.evaluationReports.EvaluationReportsListOptions;
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
public class EvaluationReportsServiceTests extends BaseApiServiceTests {

    private final EvaluationReport report = EvaluationReport.builder()
            .id("ev_0o5Fs0EELR0fUjHjbCnEtdUwQe3")
            .created(new Date())
            .updated(new Date())
            .workspace("wksp_602a8dd0a54847479a874de4")
            .build();

    @Mock
    private EvaluationReportsService service;

    @Test
    public void test_GettingEvaluationReportsWorks() throws IOException {
        service = Mockito.mock(EvaluationReportsService.class, withSettings().useConstructor(options));

        // given
        EvaluationReportsListOptions opt = EvaluationReportsListOptions.builder()
                .count(1)
                .build();

        ResourceResponse<EvaluationReport[]> response = getResourceResponse(200, new EvaluationReport[]{report});
        when(service.getEvaluationReports(opt, requestOptions)).thenReturn(response);

        mockWebServer.enqueue(getMockedResponse(200, new EvaluationReport[]{report}));

        // when
        ResourceResponse<EvaluationReport[]> resp = service.getEvaluationReports(opt, requestOptions);
        Assertions.assertNotNull(resp);
        Assertions.assertTrue(response.getResource().length > 0);
    }

    @Test
    public void test_GetEvaluationReportWorks() throws IOException {
        service = Mockito.mock(EvaluationReportsService.class, withSettings().useConstructor(options));

        // given
        ResourceResponse<EvaluationReport> expectedResponse = getResourceResponse(200, report);
        when(service.getEvaluationReport("ev_0o5Fs0EELR0fUjHjbCnEtdUwQe3", requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, report));

        // when
        ResourceResponse<EvaluationReport> response = service.getEvaluationReport("ev_0o5Fs0EELR0fUjHjbCnEtdUwQe3", requestOptions);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(200, response.getStatusCode());
    }
}
