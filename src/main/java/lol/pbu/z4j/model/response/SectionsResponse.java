package lol.pbu.z4j.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.Valid;
import lol.pbu.z4j.model.Section;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * SectionsResponse
 *
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder(SectionsResponse.JSON_PROPERTY_SECTIONS)
public class SectionsResponse {

    public static final String JSON_PROPERTY_SECTIONS = "sections";

    @Nullable
    @JsonProperty(JSON_PROPERTY_SECTIONS)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<@Valid Section> sections;

    /**
     * @return the sections property value
     */
    public List<@Valid Section> getSections() {
        return sections;
    }

    /**
     * Set the sections property value
     *
     * @param sections property value to set
     */
    public void setSections(List<@Valid Section> sections) {
        this.sections = sections;
    }

    /**
     * Set sections in a chainable fashion.
     *
     * @return The same instance of SectionsResponse for chaining.
     */
    public SectionsResponse sections(List<@Valid Section> sections) {
        this.sections = sections;
        return this;
    }

    /**
     * Add an item to the sections property in a chainable fashion.
     *
     * @return The same instance of SectionsResponse for chaining.
     */
    public SectionsResponse addSectionsItem(Section sectionsItem) {
        if (sections == null) {
            sections = new ArrayList<>();
        }
        sections.add(sectionsItem);
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
        var sectionsResponse = (SectionsResponse) o;
        return Objects.equals(sections, sectionsResponse.sections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sections);
    }

    @Override
    public String toString() {
        return "SectionsResponse("
                + "sections: " + getSections()
                + ")";
    }

}