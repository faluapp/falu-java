package io.falu.services;

import io.falu.ApiResultCallback;
import io.falu.AppInformation;
import io.falu.FaluClientOptions;
import io.falu.client.ResourceResponse;
import io.falu.models.evaluations.Evaluation;
import io.falu.networking.RequestOptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EvaluationServiceTest {

    @Captor
    private ArgumentCaptor<ApiResultCallback<Evaluation[]>> callbackCaptor;

    @Test
    public void test_GettingEvaluationsWork() {
        try (MockedConstruction<EvaluationsService> mocked = Mockito.mockConstruction(EvaluationsService.class)) {
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
}
