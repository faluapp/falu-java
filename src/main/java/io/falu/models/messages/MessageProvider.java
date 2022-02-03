package io.falu.models.messages;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Details about the provider used to send a message.
 */
@Data
@Getter
@NoArgsConstructor
public class MessageProvider {

    /**
     * Unique identifier for the request as provided by the provider.
     */
    @SerializedName("request_id")
    private String requestId;

    /**
     * The error message from the provider.
     */
    private String error;
}
