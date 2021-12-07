package io.falu.models.identity;

import com.google.gson.annotations.SerializedName;

public enum IdentityDocumentType {
    @SerializedName("nationalId")
    NATIONAL_ID,
    @SerializedName("passport")
    PASSPORT,
    @SerializedName("militaryId")
    MILITARY_ID,
    @SerializedName("alienId")
    ALIEN_ID,
    @SerializedName("drivingLicense")
    DRIVING_LICENSE
}
