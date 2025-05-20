package lol.pbu.z4j.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.micronaut.serde.annotation.Serdeable;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * The set of users who can manage this topic.
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
public enum TopicManageableBy {

    @JsonProperty("staff")
    STAFF("staff"),
    @JsonProperty("managers")
    MANAGERS("managers"),
    ;

    public static final Map<String, TopicManageableBy> VALUE_MAPPING = Map.copyOf(Arrays.stream(values())
        .collect(Collectors.toMap(v -> v.value, Function.identity())));

    private final String value;

    TopicManageableBy(String value) {
        this.value = value;
    }

    /**
     * @return The value represented by this enum
     */
    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    /**
     * Create this enum from a value.
     *
     * @param value The value
     *
     * @return The enum
     */
    @JsonCreator
    public static TopicManageableBy fromValue(String value) {
        if (!VALUE_MAPPING.containsKey(value)) {
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
        return VALUE_MAPPING.get(value);
    }
}