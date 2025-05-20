package lol.pbu.z4j.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.Valid;
import lol.pbu.z4j.model.ContentSubscription;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ContentSubscriptionsResponse
 *
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder(ContentSubscriptionsResponse.JSON_PROPERTY_SUBSCRIPTIONS)
public class ContentSubscriptionsResponse {

    public static final String JSON_PROPERTY_SUBSCRIPTIONS = "subscriptions";

    @Nullable
    @JsonProperty(JSON_PROPERTY_SUBSCRIPTIONS)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<@Valid ContentSubscription> subscriptions;

    /**
     * @return the subscriptions property value
     */
    public List<@Valid ContentSubscription> getSubscriptions() {
        return subscriptions;
    }

    /**
     * Set the subscriptions property value
     *
     * @param subscriptions property value to set
     */
    public void setSubscriptions(List<@Valid ContentSubscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    /**
     * Set subscriptions in a chainable fashion.
     *
     * @return The same instance of ContentSubscriptionsResponse for chaining.
     */
    public ContentSubscriptionsResponse subscriptions(List<@Valid ContentSubscription> subscriptions) {
        this.subscriptions = subscriptions;
        return this;
    }

    /**
     * Add an item to the subscriptions property in a chainable fashion.
     *
     * @return The same instance of ContentSubscriptionsResponse for chaining.
     */
    public ContentSubscriptionsResponse addSubscriptionsItem(ContentSubscription subscriptionsItem) {
        if (subscriptions == null) {
            subscriptions = new ArrayList<>();
        }
        subscriptions.add(subscriptionsItem);
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
        var contentSubscriptionsResponse = (ContentSubscriptionsResponse) o;
        return Objects.equals(subscriptions, contentSubscriptionsResponse.subscriptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subscriptions);
    }

    @Override
    public String toString() {
        return "ContentSubscriptionsResponse("
                + "subscriptions: " + getSubscriptions()
                + ")";
    }

}