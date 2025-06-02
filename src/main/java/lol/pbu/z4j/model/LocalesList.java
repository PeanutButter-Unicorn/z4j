package lol.pbu.z4j.model;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;

import java.util.List;

/**
 * @author Jonathan Zollinger
 * @since 0.0.2
 */
@Serdeable
@Data
public class LocalesList {
    List<Locale> locales;
}
