package lol.pbu.z4j.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.Valid;
import lol.pbu.z4j.model.Vote;

import java.util.Objects;


/**
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder(VoteResponse.JSON_PROPERTY_VOTE)
public class VoteResponse {

    public static final String JSON_PROPERTY_VOTE = "vote";

    @Nullable
    @Valid
    @JsonProperty(JSON_PROPERTY_VOTE)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Vote vote;

    /**
     * @return the vote property value
     */
    public Vote getVote() {
        return vote;
    }

    /**
     * Set the vote property value
     *
     * @param vote property value to set
     */
    public void setVote(Vote vote) {
        this.vote = vote;
    }

    /**
     * Set vote in a chainable fashion.
     *
     * @return The same instance of VoteResponse for chaining.
     */
    public VoteResponse vote(Vote vote) {
        this.vote = vote;
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
        var voteResponse = (VoteResponse) o;
        return Objects.equals(vote, voteResponse.vote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vote);
    }

    @Override
    public String toString() {
        return "VoteResponse("
                + "vote: " + getVote()
                + ")";
    }

}