package io.falu.networking;

import io.falu.client.headers.RetriesHeaderProvider;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RetriesHeaderProviderTest {
    private RetriesHeaderProvider retriesHeaderProvider;
    private Interceptor.Chain mockChain;
    private Request mockRequest;

    @BeforeEach
    public void setUp() {
        retriesHeaderProvider = new RetriesHeaderProvider(3); // Set max retries to 3
        mockChain = Mockito.mock(Interceptor.Chain.class);
        mockRequest = Mockito.mock(Request.class);

        when(mockChain.request()).thenReturn(mockRequest);
    }

    @Test
    public void test_NoRetry() throws IOException {
        Response mockResponse = mock(Response.class);
        when(mockResponse.header("X-Should-Retry")).thenReturn("false");
        when(mockResponse.code()).thenReturn(200); // No need to retry
        when(mockChain.proceed(mockRequest)).thenReturn(mockResponse);

        Response response = retriesHeaderProvider.intercept(mockChain);
        assertEquals(mockResponse, response);
        verify(mockChain, times(1)).proceed(mockRequest);
    }

    @Test
    public void test_RetryWithHeader() throws IOException {
        Response mockResponse = mock(Response.class);
        when(mockResponse.header("X-Should-Retry")).thenReturn("true");
        when(mockChain.proceed(mockRequest)).thenReturn(mockResponse);

        Response response = retriesHeaderProvider.intercept(mockChain);
        assertEquals(mockResponse, response);
        verify(mockChain, times(4)).proceed(mockRequest); // 1 initial + 3 retries
    }

    @Test
    public void test_RetryOn409Conflict() throws IOException {
        Response mockResponse = mock(Response.class);
        when(mockResponse.header("X-Should-Retry")).thenReturn("false");
        when(mockResponse.code()).thenReturn(409); // Conflict
        when(mockChain.proceed(mockRequest)).thenReturn(mockResponse);

        Response response = retriesHeaderProvider.intercept(mockChain);
        assertEquals(mockResponse, response);
        verify(mockChain, times(4)).proceed(mockRequest); // 1 initial + 3 retries
    }

    @Test
    public void test_RetryOn408Timeout() throws IOException {
        Response mockResponse = mock(Response.class);
        when(mockResponse.header("X-Should-Retry")).thenReturn("false");
        when(mockResponse.code()).thenReturn(408); // Request timeout
        when(mockChain.proceed(mockRequest)).thenReturn(mockResponse);

        Response response = retriesHeaderProvider.intercept(mockChain);
        assertEquals(mockResponse, response);
        verify(mockChain, times(4)).proceed(mockRequest); // 1 initial + 3 retries
    }

    @Test
    public void test_MaxRetriesExceeded() throws IOException {
        Response mockResponse = mock(Response.class);
        when(mockResponse.header("X-Should-Retry")).thenReturn("true");
        when(mockChain.proceed(mockRequest)).thenReturn(mockResponse);

        retriesHeaderProvider = new RetriesHeaderProvider(2); // Max 2 retries
        Response response = retriesHeaderProvider.intercept(mockChain);
        assertEquals(mockResponse, response);
        verify(mockChain, times(3)).proceed(mockRequest); // 1 initial + 2 retries
    }

    @Test
    public void test_RetryWhenHeaderIsNull() throws IOException {
        Response mockResponse = mock(Response.class);
        when(mockResponse.header("X-Should-Retry")).thenReturn(null);
        when(mockResponse.code()).thenReturn(503); // Service Unavailable, should trigger retry
        when(mockChain.proceed(mockRequest)).thenReturn(mockResponse);

        Response response = retriesHeaderProvider.intercept(mockChain);
        assertEquals(mockResponse, response);
        verify(mockChain, times(4)).proceed(mockRequest); // 1 initial + 3 retries
    }
}
