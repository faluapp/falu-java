package io.falu.models.transfers;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Information for initiating a transfer to customer or another business via MPESA.
 */
@Setter
@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class TransferCreateRequestMpesaOptions {
    /**
     * Details about initiation of an MPESA payment to customer.
     * This is also referred to as a Business To Customer (B2C) transfer.
     */
    private TransferCreateRequestMpesaToCustomer customer;

    /**
     * Details about initiation of an MPESA payment to another business.
     * This is also referred to as a Business To Business (B2B) transfer.
     */
    private TransferCreateRequestMpesaToBusiness business;
}
