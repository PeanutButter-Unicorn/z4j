package lol.pbu.z4j.model.request;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Objects;

/**
 * SectionPutRequest
 *
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@Data
public class SectionPutRequest {

    @NotNull
    @Valid
    private SectionPutRequestSection section;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        var sectionPutRequest = (SectionPutRequest) o;
        return Objects.equals(section, sectionPutRequest.section);
    }

    @Override
    public int hashCode() {
        return Objects.hash(section);
    }

    @Override
    public String toString() {
        return "SectionPutRequest("
                + "section: " + getSection()
                + ")";
    }

}