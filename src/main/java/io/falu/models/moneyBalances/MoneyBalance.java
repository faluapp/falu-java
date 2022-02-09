package io.falu.models.moneyBalances;

import io.falu.models.FaluModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.HashMap;

/**
 * Funds that are available to be transferred.
 * They are categorized by provider and currency.
 */
@Getter
@NoArgsConstructor
@SuperBuilder
public class MoneyBalance extends FaluModel {
    /**
     * Breakdown of balance by business code.
     * The value is represented in the smallest currency unit.
     */
    public HashMap<String, Long> mpesa;
}
