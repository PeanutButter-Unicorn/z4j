package lol.pbu.z4j.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;
import lombok.experimental.Accessors;
import java.util.List;

@Accessors(chain = true)
@Data
@Serdeable
public class ViewExecuteResponse {
    @Nullable @JsonProperty("rows") @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<ViewRow> rows;

    @Nullable @JsonProperty("columns") @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<Object> columns;

    @Nullable @JsonProperty("users") @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<User> users;
    
    @Nullable @JsonProperty("groups") @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<Group> groups;

    @Nullable @JsonProperty("organizations") @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<Organization> organizations;
    
    @Nullable @JsonProperty("count") @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer count;
    
    @Nullable @JsonProperty("next_page") @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String nextPage;
    
    @Nullable @JsonProperty("previous_page") @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String previousPage;
}
