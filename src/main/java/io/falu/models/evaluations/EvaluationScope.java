package io.falu.models.evaluations;

import com.google.gson.annotations.SerializedName;

public enum EvaluationScope {
    @SerializedName("business")
    BUSINESS,
    @SerializedName("personal")
    PERSONAL;

    String getDescription() {
        switch (this) {
            case BUSINESS -> {
                return "business";
            }
            case PERSONAL -> {
                return "personal";
            }
        }
        return "";
    }
}
