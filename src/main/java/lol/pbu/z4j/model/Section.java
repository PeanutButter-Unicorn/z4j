package lol.pbu.z4j.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * Section
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder({
    Section.JSON_PROPERTY_LOCALE,
    Section.JSON_PROPERTY_NAME,
    Section.JSON_PROPERTY_CATEGORY_ID,
    Section.JSON_PROPERTY_CREATED_AT,
    Section.JSON_PROPERTY_DESCRIPTION,
    Section.JSON_PROPERTY_HTML_URL,
    Section.JSON_PROPERTY_ID,
    Section.JSON_PROPERTY_OUTDATED,
    Section.JSON_PROPERTY_PARENT_SECTION_ID,
    Section.JSON_PROPERTY_POSITION,
    Section.JSON_PROPERTY_SOURCE_LOCALE,
    Section.JSON_PROPERTY_THEME_TEMPLATE,
    Section.JSON_PROPERTY_UPDATED_AT,
    Section.JSON_PROPERTY_URL,
})
public class Section {

    public static final String JSON_PROPERTY_LOCALE = "locale";
    public static final String JSON_PROPERTY_NAME = "name";
    public static final String JSON_PROPERTY_CATEGORY_ID = "category_id";
    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    public static final String JSON_PROPERTY_HTML_URL = "html_url";
    public static final String JSON_PROPERTY_ID = "id";
    public static final String JSON_PROPERTY_OUTDATED = "outdated";
    public static final String JSON_PROPERTY_PARENT_SECTION_ID = "parent_section_id";
    public static final String JSON_PROPERTY_POSITION = "position";
    public static final String JSON_PROPERTY_SOURCE_LOCALE = "source_locale";
    public static final String JSON_PROPERTY_THEME_TEMPLATE = "theme_template";
    public static final String JSON_PROPERTY_UPDATED_AT = "updated_at";
    public static final String JSON_PROPERTY_URL = "url";

    /**
     * The locale in which the section is displayed
     */
    @NotNull
    @JsonProperty(JSON_PROPERTY_LOCALE)
    private String locale;

    /**
     * The name of the section
     */
    @NotNull
    @JsonProperty(JSON_PROPERTY_NAME)
    private String name;

    /**
     * The id of the category to which this section belongs
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_CATEGORY_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer categoryId;

    /**
     * The time at which the section was created
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String createdAt;

    /**
     * The description of the section
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String description;

    /**
     * The url of this section in HC
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_HTML_URL)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String htmlUrl;

    /**
     * Automatically assigned when creating subscriptions
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer id;

    /**
     * Whether the section is out of date
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_OUTDATED)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Boolean outdated;

    /**
     * The id of the section to which this section belongs. Only writable for Guide Enterprise customers
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_PARENT_SECTION_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer parentSectionId;

    /**
     * The position of this section in the section list. Used when sorting is set to ´manual´. By default the section is added to the end of the list
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_POSITION)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer position;

    /**
     * The source (default) locale of the section
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_SOURCE_LOCALE)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String sourceLocale;

    /**
     * The theme template name used to display this section in Help Center.
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_THEME_TEMPLATE)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String themeTemplate;

    /**
     * The time at which the section was last updated
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_UPDATED_AT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String updatedAt;

    /**
     * The API url of this section
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_URL)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String url;

    public Section(String locale, String name) {
        this.locale = locale;
        this.name = name;
    }

    /**
     * The locale in which the section is displayed
     *
     * @return the locale property value
     */
    public String getLocale() {
        return locale;
    }

    /**
     * Set the locale property value
     *
     * @param locale property value to set
     */
    public void setLocale(String locale) {
        this.locale = locale;
    }

    /**
     * Set locale in a chainable fashion.
     *
     * @return The same instance of Section for chaining.
     */
    public Section locale(String locale) {
        this.locale = locale;
        return this;
    }

    /**
     * The name of the section
     *
     * @return the name property value
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name property value
     *
     * @param name property value to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set name in a chainable fashion.
     *
     * @return The same instance of Section for chaining.
     */
    public Section name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The id of the category to which this section belongs
     *
     * @return the categoryId property value
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * Set the categoryId property value
     *
     * @param categoryId property value to set
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * Set categoryId in a chainable fashion.
     *
     * @return The same instance of Section for chaining.
     */
    public Section categoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    /**
     * The time at which the section was created
     *
     * @return the createdAt property value
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Set the createdAt property value
     *
     * @param createdAt property value to set
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * The description of the section
     *
     * @return the description property value
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description property value
     *
     * @param description property value to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Set description in a chainable fashion.
     *
     * @return The same instance of Section for chaining.
     */
    public Section description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The url of this section in HC
     *
     * @return the htmlUrl property value
     */
    public String getHtmlUrl() {
        return htmlUrl;
    }

    /**
     * Set the htmlUrl property value
     *
     * @param htmlUrl property value to set
     */
    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    /**
     * Automatically assigned when creating subscriptions
     *
     * @return the id property value
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set the id property value
     *
     * @param id property value to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Whether the section is out of date
     *
     * @return the outdated property value
     */
    public Boolean getOutdated() {
        return outdated;
    }

    /**
     * Set the outdated property value
     *
     * @param outdated property value to set
     */
    public void setOutdated(Boolean outdated) {
        this.outdated = outdated;
    }

    /**
     * The id of the section to which this section belongs. Only writable for Guide Enterprise customers
     *
     * @return the parentSectionId property value
     */
    public Integer getParentSectionId() {
        return parentSectionId;
    }

    /**
     * Set the parentSectionId property value
     *
     * @param parentSectionId property value to set
     */
    public void setParentSectionId(Integer parentSectionId) {
        this.parentSectionId = parentSectionId;
    }

    /**
     * Set parentSectionId in a chainable fashion.
     *
     * @return The same instance of Section for chaining.
     */
    public Section parentSectionId(Integer parentSectionId) {
        this.parentSectionId = parentSectionId;
        return this;
    }

    /**
     * The position of this section in the section list. Used when sorting is set to ´manual´. By default the section is added to the end of the list
     *
     * @return the position property value
     */
    public Integer getPosition() {
        return position;
    }

    /**
     * Set the position property value
     *
     * @param position property value to set
     */
    public void setPosition(Integer position) {
        this.position = position;
    }

    /**
     * Set position in a chainable fashion.
     *
     * @return The same instance of Section for chaining.
     */
    public Section position(Integer position) {
        this.position = position;
        return this;
    }

    /**
     * The source (default) locale of the section
     *
     * @return the sourceLocale property value
     */
    public String getSourceLocale() {
        return sourceLocale;
    }

    /**
     * Set the sourceLocale property value
     *
     * @param sourceLocale property value to set
     */
    public void setSourceLocale(String sourceLocale) {
        this.sourceLocale = sourceLocale;
    }

    /**
     * The theme template name used to display this section in Help Center.
     *
     * @return the themeTemplate property value
     */
    public String getThemeTemplate() {
        return themeTemplate;
    }

    /**
     * Set the themeTemplate property value
     *
     * @param themeTemplate property value to set
     */
    public void setThemeTemplate(String themeTemplate) {
        this.themeTemplate = themeTemplate;
    }

    /**
     * Set themeTemplate in a chainable fashion.
     *
     * @return The same instance of Section for chaining.
     */
    public Section themeTemplate(String themeTemplate) {
        this.themeTemplate = themeTemplate;
        return this;
    }

    /**
     * The time at which the section was last updated
     *
     * @return the updatedAt property value
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Set the updatedAt property value
     *
     * @param updatedAt property value to set
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * The API url of this section
     *
     * @return the url property value
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set the url property value
     *
     * @param url property value to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        var section = (Section) o;
        return Objects.equals(locale, section.locale)
            && Objects.equals(name, section.name)
            && Objects.equals(categoryId, section.categoryId)
            && Objects.equals(createdAt, section.createdAt)
            && Objects.equals(description, section.description)
            && Objects.equals(htmlUrl, section.htmlUrl)
            && Objects.equals(id, section.id)
            && Objects.equals(outdated, section.outdated)
            && Objects.equals(parentSectionId, section.parentSectionId)
            && Objects.equals(position, section.position)
            && Objects.equals(sourceLocale, section.sourceLocale)
            && Objects.equals(themeTemplate, section.themeTemplate)
            && Objects.equals(updatedAt, section.updatedAt)
            && Objects.equals(url, section.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locale, name, categoryId, createdAt, description, htmlUrl, id, outdated, parentSectionId, position, sourceLocale, themeTemplate, updatedAt, url);
    }

    @Override
    public String toString() {
        return "Section("
            + "locale: " + getLocale() + ", "
            + "name: " + getName() + ", "
            + "categoryId: " + getCategoryId() + ", "
            + "createdAt: " + getCreatedAt() + ", "
            + "description: " + getDescription() + ", "
            + "htmlUrl: " + getHtmlUrl() + ", "
            + "id: " + getId() + ", "
            + "outdated: " + getOutdated() + ", "
            + "parentSectionId: " + getParentSectionId() + ", "
            + "position: " + getPosition() + ", "
            + "sourceLocale: " + getSourceLocale() + ", "
            + "themeTemplate: " + getThemeTemplate() + ", "
            + "updatedAt: " + getUpdatedAt() + ", "
            + "url: " + getUrl()
            + ")";
    }

}