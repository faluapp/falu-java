package io.falu.models.evaluations;

import com.google.gson.annotations.SerializedName;

public enum EvaluationStatus {
    @SerializedName("created")
    CREATED,

    @SerializedName("scoring")
    SCORING,

    @SerializedName("completed")
    COMPLETED,

    @SerializedName("failed")
    FAILED
}
