package lol.pbu.z4j.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;

import java.net.URL;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Locale Object
 *
 * @author jonathan zollinger
 * @since 0.0.2
 */
@Serdeable
@Data
public class Locale {

    /**
     * The ISO 8601 formatted date-time the locale was created
     * Example: "2009-07-20T22:55:29Z"
     */
    @JsonProperty("created_at")
    private OffsetDateTime createdAt;

    /**
     * unique ID for the locale
     */
    private Long id;
    /**
     * the name of the locale
     */
    private String locale;

    /**
     * the name of the language
     */
    private String name;

    /**
     * The ISO 8601 formatted date-time the locale was last updated
     * Example: "2009-07-20T22:55:29Z"
     */
    @JsonProperty("updated_at")
    private OffsetDateTime updatedAt;

    /**
     * url of the locale record
     * Example: {@code https://company.zendesk.com/api/v2/locales/en-US.json}
     */
    private URL url;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        var local = (Locale) o;
        return Objects.equals(id, local.id)
                && Objects.equals(createdAt, local.createdAt)
                && Objects.equals(locale, local.locale)
                && Objects.equals(name, local.name)
                && Objects.equals(url, local.url);
    }
}
