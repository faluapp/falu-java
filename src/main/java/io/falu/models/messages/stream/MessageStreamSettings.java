package io.falu.models.messages.stream;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Settings of a message stream.
 */
@Data
@Getter
@Setter
@NoArgsConstructor
public class MessageStreamSettings {

    /**
     * Settings for using the Crossgate provider.
     */
    private CrossgateSettings crossgate;

    /**
     * Settings for using the Mobi4tech provider.
     */
    private Mobi4techSettings mobi4tech;

    /**
     * Settings for using the Mtech provider.
     */
    private MtechSettings mtech;
}
