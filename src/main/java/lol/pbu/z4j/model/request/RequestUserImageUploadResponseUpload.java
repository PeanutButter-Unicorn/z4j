package lol.pbu.z4j.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;

import java.util.Map;
import java.util.Objects;

/**
 * RequestUserImageUploadResponseUpload
 *
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@Data
public class RequestUserImageUploadResponseUpload {


    @Nullable
    @JsonInclude(content = JsonInclude.Include.ALWAYS, value = JsonInclude.Include.USE_DEFAULTS)
    private Map<String, Object> headers;

    @Nullable
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String token;

    @Nullable
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String url;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        var requestUserImageUploadResponseUpload = (RequestUserImageUploadResponseUpload) o;
        return Objects.equals(headers, requestUserImageUploadResponseUpload.headers)
                && Objects.equals(token, requestUserImageUploadResponseUpload.token)
                && Objects.equals(url, requestUserImageUploadResponseUpload.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(headers, token, url);
    }

    @Override
    public String toString() {
        return "RequestUserImageUploadResponseUpload("
                + "headers: " + getHeaders() + ", "
                + "token: " + getToken() + ", "
                + "url: " + getUrl()
                + ")";
    }

}