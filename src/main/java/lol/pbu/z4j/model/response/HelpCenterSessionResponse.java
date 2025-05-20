package lol.pbu.z4j.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.Valid;
import lol.pbu.z4j.model.HelpCenterSession;

import java.util.Objects;

/**
 * HelpCenterSessionResponse
 *
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder(HelpCenterSessionResponse.JSON_PROPERTY_CURRENT_SESSION)
public class HelpCenterSessionResponse {

    public static final String JSON_PROPERTY_CURRENT_SESSION = "current_session";

    @Nullable
    @Valid
    @JsonProperty(JSON_PROPERTY_CURRENT_SESSION)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private HelpCenterSession currentSession;

    /**
     * @return the currentSession property value
     */
    public HelpCenterSession getCurrentSession() {
        return currentSession;
    }

    /**
     * Set the currentSession property value
     *
     * @param currentSession property value to set
     */
    public void setCurrentSession(HelpCenterSession currentSession) {
        this.currentSession = currentSession;
    }

    /**
     * Set currentSession in a chainable fashion.
     *
     * @return The same instance of HelpCenterSessionResponse for chaining.
     */
    public HelpCenterSessionResponse currentSession(HelpCenterSession currentSession) {
        this.currentSession = currentSession;
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
        var helpCenterSessionResponse = (HelpCenterSessionResponse) o;
        return Objects.equals(currentSession, helpCenterSessionResponse.currentSession);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentSession);
    }

    @Override
    public String toString() {
        return "HelpCenterSessionResponse("
                + "currentSession: " + getCurrentSession()
                + ")";
    }

}