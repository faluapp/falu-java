package io.falu.services;

import io.falu.ApiResultCallback;
import io.falu.AppInformation;
import io.falu.FaluClientOptions;
import io.falu.models.evaluations.Evaluation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EvaluationServiceTest {
    @Test
    public void test_GettingEvaluations() {
        AppInformation information = AppInformation.builder()
                .name("Java-Tests")
                .version("1.0")
                .build();
        FaluClientOptions options = FaluClientOptions.builder()
                .apiKey("pk_12345678")
                .enableLogging(true)
                .appInformation(information)
                .build();
        EvaluationsService service = new EvaluationsService(options);

        service.getEvaluations(new ApiResultCallback<Evaluation[]>() {
            @Override
            public void onSuccess(Evaluation[] evaluations) {

            }

            @Override
            public void onError(Exception e) {

            }
        });
    }
}
