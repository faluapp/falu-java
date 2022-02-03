package io.falu.models.transfers;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Represents the provider details for a MPESA transfer.
 */
@Data
@Getter
@NoArgsConstructor
public class TransferMpesaDetails {
    /**
     * Destination of where the transfer is/was sent to.
     */
    private String destination;

    /**
     * Charges for the transaction in the smallest currency unit.
     */
    private long charges;

    /**
     * Details of the receiver.
     */
    private String receiver;

    /**
     * The target MPESA business short code.
     */
    @SerializedName("business_short_code")
    private String businessShortCode;

    /**
     * Unique identifier for request as issued by MPESA. Only populated for flows that initiate the transaction instead of MPESA. The value is only available after the request is sent to MPESA.
     * <p>
     * This is also referred to as the {ConversationId}.
     */
    private String requestId;

    /**
     * Unique transaction identifier generated by MPESA. Only populated for completed transactions.
     */
    private String receipt;
}
