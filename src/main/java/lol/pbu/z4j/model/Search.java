package lol.pbu.z4j.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Objects;

/**
 * Search
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder(Search.JSON_PROPERTY_RESULTS)
public class Search {

    public static final String JSON_PROPERTY_RESULTS = "results";

    /**
     * An array with the base articles or community posts
     */
    @NotNull
    @JsonProperty(JSON_PROPERTY_RESULTS)
    private List<@Valid SearchResultsInner> results;

    public Search(List<@Valid SearchResultsInner> results) {
        this.results = results;
    }

    /**
     * An array with the base articles or community posts
     *
     * @return the results property value
     */
    public List<@Valid SearchResultsInner> getResults() {
        return results;
    }

    /**
     * Set the results property value
     *
     * @param results property value to set
     */
    public void setResults(List<@Valid SearchResultsInner> results) {
        this.results = results;
    }

    /**
     * Set results in a chainable fashion.
     *
     * @return The same instance of Search for chaining.
     */
    public Search results(List<@Valid SearchResultsInner> results) {
        this.results = results;
        return this;
    }
    /**
     * Add an item to the results property in a chainable fashion.
     *
     * @return The same instance of Search for chaining.
     */
    public Search addResultsItem(SearchResultsInner resultsItem) {
        results.add(resultsItem);
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
        var search = (Search) o;
        return Objects.equals(results, search.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }

    @Override
    public String toString() {
        return "Search("
            + "results: " + getResults()
            + ")";
    }

}