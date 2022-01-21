package io.falu.services;

import io.falu.AppInformation;
import io.falu.FaluClientOptions;
import io.falu.networking.RequestOptions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public abstract class BaseApiServiceTests {

    protected final AppInformation information = AppInformation.builder()
            .name("Java-Tests")
            .version("1.0")
            .build();

    protected final FaluClientOptions options = FaluClientOptions.builder()
            .apiKey("sk_test_LoLSnhr5sm4JjdOgxCx9rpCCiWuQ7kTw")
            .enableLogging(true)
            .appInformation(information)
            .build();

    protected final RequestOptions requestOptions = RequestOptions
            .builder()
            .idempotencyKey("05bc69eb-218d-46f2-8812-5bede8592abf")
            .live(false)
            .build();
}
