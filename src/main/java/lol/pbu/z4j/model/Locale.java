package lol.pbu.z4j.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;

@Serdeable
@Data
public class Locale {
    @JsonProperty("created_at")
    String createdAt; //: "2009-07-20T22:55:29Z"
    Long id; //: 1
    String locale; //: "en-US"
    String name; //: "English"
    @JsonProperty("updated_at")
    String updatedAt; //: "2011-05-05T10:38:52Z"
    String url; //: "https://company.zendesk.com/api/v2/locales/en-US.json"
}
