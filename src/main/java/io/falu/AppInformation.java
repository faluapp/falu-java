package io.falu;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.jetbrains.annotations.NotNull;

/**
 * Information about the application ("app") which owns this integration.
 */
@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
public class AppInformation {
    /**
     * Name of your application.
     */
    @NotNull
    String name;

    /**
     * Version of your application.
     */
    String version;

    /**
     * Website/Url for your application
     */
    String url;

    public String getUserAgent() {
        String versionName = System.getenv("VERSION_NAME");
        String versionCode = System.getenv("VERSION_CODE");
        System.getenv().forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
        return "falu-java/" + versionName + "(" + versionCode + ")" + " (" + getName() + ";SDK " + getVersion() + ";)";
    }
}
