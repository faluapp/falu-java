package io.falu.models.payments;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type of payment.
 * Usually represent the medium used to make payment.
 */
public enum PaymentType {
    @JsonProperty("mpesa")
    MPESA,
    @JsonProperty("airtelmoney")
    AIRTEL_MONEY,
    @JsonProperty("mtnmoney")
    MTN_MONEY,
    @JsonProperty("pesalink")
    PESALINK,
    @JsonProperty("tkash")
    TKASH
}
