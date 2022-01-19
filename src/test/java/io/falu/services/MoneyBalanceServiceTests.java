package io.falu.services;

import io.falu.client.ResourceResponse;
import io.falu.models.moneyBalances.MoneyBalance;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

@ExtendWith(MockitoExtension.class)
public class MoneyBalanceServiceTests extends BaseApiServiceTests {

    @Test
    public void test_GetMoneyBalancesWork() throws IOException {
        MoneyBalancesService service = new MoneyBalancesService(options);

        ResourceResponse<MoneyBalance> response = service.getMoneyBalances(requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }

    @Test
    public void test_RefreshMoneyBalancesWork() throws IOException {
        MoneyBalancesService service = new MoneyBalancesService(options);

        ResourceResponse<MoneyBalance> response = service.refreshMoneyBalances(requestOptions);
        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertNotNull(response.getResource());
    }
}
