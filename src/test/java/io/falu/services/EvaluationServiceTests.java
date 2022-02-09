package io.falu.services;

import io.falu.client.ResourceResponse;
import io.falu.client.patch.JsonPatchDocument;
import io.falu.models.evaluations.Evaluation;
import io.falu.models.evaluations.EvaluationPatchModel;
import io.falu.models.evaluations.EvaluationRequest;
import io.falu.models.evaluations.EvaluationsListOptions;
import io.falu.networking.RequestOptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

@ExtendWith(MockitoExtension.class)
public class EvaluationServiceTests extends BaseApiServiceTests {

    private final Evaluation evaluation = Evaluation.builder()
            .id("ev_0o5Fs0EELR0fUjHjbCnEtdUwQe3")
            .currency("kes")
            .scope("personal")
            .status("created")
            .created(new Date())
            .updated(new Date())
            .workspace("wksp_602a8dd0a54847479a874de4")
            .build();

    @Mock
    private EvaluationsService service;

    @Test
    public void test_GettingEvaluationsWorks() throws IOException {
        service = Mockito.mock(EvaluationsService.class, withSettings().useConstructor(options));

        // given
        EvaluationsListOptions opt = EvaluationsListOptions.builder()
                .count(1)
                .build();

        ResourceResponse<Evaluation[]> response = getResourceResponse(200, new Evaluation[]{evaluation});
        when(service.getEvaluations(opt, requestOptions)).thenReturn(response);

        mockWebServer.enqueue(getMockedResponse(200, new Evaluation[]{evaluation}));

        // when
        ResourceResponse<Evaluation[]> resp = service.getEvaluations(opt, requestOptions);
        Assertions.assertNotNull(resp);
        Assertions.assertTrue(response.getResource().length > 0);
    }

    @Test
    public void test_GetEvaluationWorks() throws IOException {
        service = Mockito.mock(EvaluationsService.class, withSettings().useConstructor(options));

        // given
        ResourceResponse<Evaluation> expectedResponse = getResourceResponse(200, evaluation);
        when(service.getEvaluation("evt_123", requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, evaluation));

        // when
        ResourceResponse<Evaluation> response = service.getEvaluation("evt_123", requestOptions);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void test_CreateEvaluationWorks() throws IOException {
        service = Mockito.mock(EvaluationsService.class, withSettings().useConstructor(options));

        // given
        EvaluationRequest request = EvaluationRequest.builder()
                .currency("kes")
                .scope("personal")
                .provider("mpesa")
                .phone("+254722000000")
                .file("file_123")
                .password("test")
                .name("John Kamau")
                .build();

        ResourceResponse<Evaluation> expectedResponse = getResourceResponse(200, evaluation);
        when(service.createEvaluation(request, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, evaluation));

        // when
        ResourceResponse<Evaluation> response = service.createEvaluation(request, requestOptions);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void test_UpdateEvaluationWorks() throws IOException {
        service = Mockito.mock(EvaluationsService.class, withSettings().useConstructor(options));

        HashMap<String, String> map = new HashMap<>();
        map.put("", "");

        EvaluationPatchModel patchModel = EvaluationPatchModel.builder()
                .description("Cake")
                .metadata(map)
                .build();

        RequestOptions requestOptions = RequestOptions.builder()
                .live(false)
                .build();

        JsonPatchDocument<EvaluationPatchModel> document = new JsonPatchDocument<EvaluationPatchModel>()
                .replace("description", patchModel.getDescription())
                .replace("medadata", patchModel.getMetadata());

        // given
        ResourceResponse<Evaluation> expectedResponse = getResourceResponse(200, evaluation);
        when(service.updateEvaluation("evt_123", document, requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, evaluation));

        // when
        ResourceResponse<Evaluation> response = service.updateEvaluation("evt_123", document, requestOptions);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void test_ScoringWorks() throws IOException {
        service = Mockito.mock(EvaluationsService.class, withSettings().useConstructor(options));

        // given
        ResourceResponse<Evaluation> expectedResponse = getResourceResponse(200, evaluation);
        when(service.scoreEvaluation("evt_123", requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, evaluation));

        // when
        ResourceResponse<Evaluation> response = service.scoreEvaluation("evt_123", requestOptions);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(200, response.getStatusCode());
    }
}
