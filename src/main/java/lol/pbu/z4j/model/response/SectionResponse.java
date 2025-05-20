package lol.pbu.z4j.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.Valid;
import lol.pbu.z4j.model.Section;

import java.util.Objects;

/**
 * SectionResponse
 *
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder(SectionResponse.JSON_PROPERTY_SECTION)
public class SectionResponse {

    public static final String JSON_PROPERTY_SECTION = "section";

    @Nullable
    @Valid
    @JsonProperty(JSON_PROPERTY_SECTION)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Section section;

    /**
     * @return the section property value
     */
    public Section getSection() {
        return section;
    }

    /**
     * Set the section property value
     *
     * @param section property value to set
     */
    public void setSection(Section section) {
        this.section = section;
    }

    /**
     * Set section in a chainable fashion.
     *
     * @return The same instance of SectionResponse for chaining.
     */
    public SectionResponse section(Section section) {
        this.section = section;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        var sectionResponse = (SectionResponse) o;
        return Objects.equals(section, sectionResponse.section);
    }

    @Override
    public int hashCode() {
        return Objects.hash(section);
    }

    @Override
    public String toString() {
        return "SectionResponse("
                + "section: " + getSection()
                + ")";
    }

}