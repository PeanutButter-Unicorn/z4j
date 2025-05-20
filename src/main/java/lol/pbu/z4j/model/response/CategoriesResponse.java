package lol.pbu.z4j.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.Valid;
import lol.pbu.z4j.model.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * CategoriesResponse
 *
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder(CategoriesResponse.JSON_PROPERTY_CATEGORIES)
public class CategoriesResponse {

    public static final String JSON_PROPERTY_CATEGORIES = "categories";

    @Nullable
    @JsonProperty(JSON_PROPERTY_CATEGORIES)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<@Valid Category> categories;

    /**
     * @return the categories property value
     */
    public List<@Valid Category> getCategories() {
        return categories;
    }

    /**
     * Set the categories property value
     *
     * @param categories property value to set
     */
    public void setCategories(List<@Valid Category> categories) {
        this.categories = categories;
    }

    /**
     * Set categories in a chainable fashion.
     *
     * @return The same instance of CategoriesResponse for chaining.
     */
    public CategoriesResponse categories(List<@Valid Category> categories) {
        this.categories = categories;
        return this;
    }

    /**
     * Add an item to the categories property in a chainable fashion.
     *
     * @return The same instance of CategoriesResponse for chaining.
     */
    public CategoriesResponse addCategoriesItem(Category categoriesItem) {
        if (categories == null) {
            categories = new ArrayList<>();
        }
        categories.add(categoriesItem);
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
        var categoriesResponse = (CategoriesResponse) o;
        return Objects.equals(categories, categoriesResponse.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categories);
    }

    @Override
    public String toString() {
        return "CategoriesResponse("
                + "categories: " + getCategories()
                + ")";
    }

}