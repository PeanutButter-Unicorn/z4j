package lol.pbu.z4j.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;

import java.util.Objects;

/**
 * SectionPutRequestSection
 *
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@Data
public class SectionPutRequestSection {

    /**
     * The id of the category to which this section belongs
     */
    @Nullable
    @JsonProperty("category_id")
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer categoryId;

    /**
     * The description of the section
     */
    @Nullable
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String description;

    /**
     * The name of the section
     */
    @Nullable
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String name;

    /**
     * The id of the section to which this section belongs. Only writable for Guide Enterprise customers
     */
    @Nullable
    @JsonProperty("parent_section_id")
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer parentSectionId;

    /**
     * The position of this section in the section list. Used when sorting is set to ´manual´.
     */
    @Nullable
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer position;

    @Nullable
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private SectionPutRequestSectionSorting sorting;

    /**
     * The theme template name used to display this section in Help Center.
     */
    @Nullable
    @JsonProperty("theme_template")
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String themeTemplate;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        var sectionPutRequestSection = (SectionPutRequestSection) o;
        return Objects.equals(categoryId, sectionPutRequestSection.categoryId)
                && Objects.equals(description, sectionPutRequestSection.description)
                && Objects.equals(name, sectionPutRequestSection.name)
                && Objects.equals(parentSectionId, sectionPutRequestSection.parentSectionId)
                && Objects.equals(position, sectionPutRequestSection.position)
                && Objects.equals(sorting, sectionPutRequestSection.sorting)
                && Objects.equals(themeTemplate, sectionPutRequestSection.themeTemplate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, description, name, parentSectionId, position, sorting, themeTemplate);
    }

    @Override
    public String toString() {
        return "SectionPutRequestSection("
                + "categoryId: " + getCategoryId() + ", "
                + "description: " + getDescription() + ", "
                + "name: " + getName() + ", "
                + "parentSectionId: " + getParentSectionId() + ", "
                + "position: " + getPosition() + ", "
                + "sorting: " + getSorting() + ", "
                + "themeTemplate: " + getThemeTemplate()
                + ")";
    }

}