package io.falu.services;

import io.falu.client.ResourceResponse;
import io.falu.client.patch.JsonPatchDocument;
import io.falu.models.evaluations.Evaluation;
import io.falu.models.evaluations.EvaluationPatchModel;
import io.falu.models.evaluations.EvaluationRequest;
import io.falu.networking.RequestOptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.HashMap;

@ExtendWith(MockitoExtension.class)
public class EvaluationServiceTests extends BaseApiServiceTests {

    @Test
    public void test_GettingEvaluationsWorks() throws IOException {

        EvaluationsService service = new EvaluationsService(options);

        ResourceResponse<Evaluation[]> response = service.getEvaluations(requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_CreateEvaluationWorks() throws IOException {
        EvaluationsService service = new EvaluationsService(options);

        EvaluationRequest request = EvaluationRequest.builder()
                .build();

        RequestOptions requestOptions = RequestOptions.builder()
                .live(false)
                .build();

        ResourceResponse<Evaluation> response = service.createEvaluation(request, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_GetEvaluationWorks() throws IOException {
        EvaluationsService service = new EvaluationsService(options);

        ResourceResponse<Evaluation> response = service.getEvaluation("evt_123", requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void test_UpdateEvaluationWorks() throws IOException {
        EvaluationsService service = new EvaluationsService(options);

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


        ResourceResponse<Evaluation> response = service.updateEvaluation("evt_123", document, requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
    }
}
