package lol.pbu.z4j.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@Serdeable
public abstract class OffsetPaginationResponse {
    @Nullable @JsonProperty("count") @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer count;
    
    @Nullable @JsonProperty("next_page") @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String nextPage;
    
    @Nullable @JsonProperty("previous_page") @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String previousPage;
}
