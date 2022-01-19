package io.falu.services;

import io.falu.client.ResourceResponse;
import io.falu.models.evaluations.EvaluationRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EvaluationServiceTests extends BaseApiServiceTests {

    @Test
    public void test_GettingEvaluationsWork() {
        try (MockedConstruction<EvaluationsService> mocked = Mockito.mockConstruction(EvaluationsService.class)) {
            ResourceResponse response = ResourceResponse.builder()
                    .statusCode(200)
                    .error(null)
                    .build();

            EvaluationsService service = new EvaluationsService(options);

            when(service.getEvaluations(requestOptions)).thenReturn(response);

            Assertions.assertEquals(200, response.getStatusCode());
            //Assertions.assertNotNull(response.getResource());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_CreateEvaluationWork() throws IOException {
        try (MockedConstruction<EvaluationsService> mocked = Mockito.mockConstruction(EvaluationsService.class)) {
            EvaluationRequest request = EvaluationRequest.builder()
                    .build();

            ResourceResponse response = ResourceResponse.builder()
                    .statusCode(200)
                    .error(null)
                    .build();

            EvaluationsService service = new EvaluationsService(options);

            when(service.createEvaluation(request, requestOptions)).thenReturn(response);

            Assertions.assertEquals(200, response.getStatusCode());
            Assertions.assertNotNull(response.getResource());
        }
    }

    @Test
    public void test_GetEvaluationWork() throws IOException {
        try (MockedConstruction<EvaluationsService> mocked = Mockito.mockConstruction(EvaluationsService.class)) {
            EvaluationRequest request = EvaluationRequest.builder()
                    .build();

            ResourceResponse response = ResourceResponse.builder()
                    .statusCode(200)
                    .error(null)
                    .build();

            EvaluationsService service = new EvaluationsService(options);

            when(service.getEvaluation("evt_123", requestOptions)).thenReturn(response);

            Assertions.assertEquals(200, response.getStatusCode());
        }
    }


}
