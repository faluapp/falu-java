package io.falu.models.payments;

import com.google.gson.annotations.SerializedName;

/**
 * The type of payment.
 * Usually represent the medium used to make payment.
 */
public enum PaymentType {
    @SerializedName("mpesa")
    MPESA,
    @SerializedName("airtelmoney")
    AIRTEL_MONEY,
    @SerializedName("mtnmoney")
    MTN_MONEY,
    @SerializedName("pesalink")
    PESALINK,
    @SerializedName("tkash")
    TKASH
}
