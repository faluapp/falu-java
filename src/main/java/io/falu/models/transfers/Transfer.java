package io.falu.models.transfers;

import io.falu.models.FaluModel;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * Represents a transaction made by the business to customer or another business.
 */
@Getter
@SuperBuilder
public class Transfer extends FaluModel {
    /**
     * Unique identifier for the object.
     */
    private String id;

    /**
     * Three-letter ISO currency code, in lowercase.
     */
    private String currency;

    /**
     * Amount of the transfer in smallest currency unit.
     */
    private long amount;

    /**
     * The status of a transfer.
     */
    private String status;

    /**
     * The medium used for the transfer.
     */
    private String type;

    /**
     * The purpose of a transfer.
     */
    private String purpose;

    /**
     * Represents the provider details for a MPESA transfer.
     */
    private TransferMpesaDetails mpesa;
}
