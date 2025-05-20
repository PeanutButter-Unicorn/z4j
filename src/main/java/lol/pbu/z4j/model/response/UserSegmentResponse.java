package lol.pbu.z4j.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.Valid;
import lol.pbu.z4j.model.UserSegment;

import java.util.Objects;

/**
 * UserSegmentResponse
 *
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder(UserSegmentResponse.JSON_PROPERTY_USER_SEGMENT)
public class UserSegmentResponse {

    public static final String JSON_PROPERTY_USER_SEGMENT = "user_segment";

    @Nullable
    @Valid
    @JsonProperty(JSON_PROPERTY_USER_SEGMENT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private UserSegment userSegment;

    /**
     * @return the userSegment property value
     */
    public UserSegment getUserSegment() {
        return userSegment;
    }

    /**
     * Set the userSegment property value
     *
     * @param userSegment property value to set
     */
    public void setUserSegment(UserSegment userSegment) {
        this.userSegment = userSegment;
    }

    /**
     * Set userSegment in a chainable fashion.
     *
     * @return The same instance of UserSegmentResponse for chaining.
     */
    public UserSegmentResponse userSegment(UserSegment userSegment) {
        this.userSegment = userSegment;
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
        var userSegmentResponse = (UserSegmentResponse) o;
        return Objects.equals(userSegment, userSegmentResponse.userSegment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userSegment);
    }

    @Override
    public String toString() {
        return "UserSegmentResponse("
                + "userSegment: " + getUserSegment()
                + ")";
    }

}