package io.falu.models.transfers;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Information for creating a transfer.
 */
@Setter
@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class TransferCreateRequest {
    /**
     * Three-letter ISO currency code, in lowercase.
     */
    private String currency;

    /**
     * Amount of the payment in smallest currency unit.
     */
    private long amount;

    /**
     * Purpose of the transfer.
     */
    private String purpose;

    /**
     * Details about initiation of an MPESA transfer to a customer or another business.
     */
    private TransferCreateRequestMpesa mpesa;
}
