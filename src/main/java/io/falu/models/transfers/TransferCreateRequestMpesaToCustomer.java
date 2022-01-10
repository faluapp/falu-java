package io.falu.models.transfers;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Information for initiating an outgoing payment to customer via MPESA.
 */
@Setter
@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class TransferCreateRequestMpesaToCustomer {
    /**
     * The business short code to be debited.
     * This code must be configured in the workspace.
     * When not provided, either the default outgoing business code
     * or the first business code for the workspace is used.
     */
    public String source;

    /**
     * The phone number to which the money is to be sent.
     */
    public String phone;
}
