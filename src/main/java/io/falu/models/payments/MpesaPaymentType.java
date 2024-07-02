package io.falu.models.payments;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum MpesaPaymentType {
    @JsonProperty("paybill")
    PAYBILL
}
