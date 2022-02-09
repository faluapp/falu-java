package io.falu.services;

import io.falu.client.ResourceResponse;
import io.falu.models.moneyBalances.MoneyBalance;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

@ExtendWith(MockitoExtension.class)
public class MoneyBalanceServiceTests extends BaseApiServiceTests {

    private final MoneyBalance moneyBalance = MoneyBalance.builder()
            .build();
    @Mock
    private MoneyBalancesService service;

    @Test
    public void test_GetMoneyBalancesWork() throws IOException {
        service = Mockito.mock(MoneyBalancesService.class, withSettings().useConstructor(options));

        // given
        ResourceResponse<MoneyBalance> expectedResponse = getResourceResponse(200, moneyBalance);
        when(service.getMoneyBalances(requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, moneyBalance));

        // when
        ResourceResponse<MoneyBalance> response = service.getMoneyBalances(requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_RefreshMoneyBalancesWork() throws IOException {
        service = Mockito.mock(MoneyBalancesService.class, withSettings().useConstructor(options));

        // given
        ResourceResponse<MoneyBalance> expectedResponse = getResourceResponse(200, moneyBalance);
        when(service.refreshMoneyBalances(requestOptions)).thenReturn(expectedResponse);

        mockWebServer.enqueue(getMockedResponse(200, moneyBalance));
        // when
        ResourceResponse<MoneyBalance> response = service.refreshMoneyBalances(requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }
}
