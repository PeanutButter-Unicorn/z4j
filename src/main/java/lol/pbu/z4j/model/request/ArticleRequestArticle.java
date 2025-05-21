package lol.pbu.z4j.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Objects;

/**
 * ArticleRequestArticle
 *
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@Data
public class ArticleRequestArticle {
    @NotNull
    private String locale;

    @NotNull
    @JsonProperty("permission_group_id")
    private Integer permissionGroupId = 0;

    @NotNull
    private String title;

    /**
     * The id of the user segment which defines who can see this article.
     * <p>
     * See <a href="https://developer.zendesk.com/api-reference/help_center/help-center-api/user_segments/">User Segments</a>
     */
    @NotNull
    @JsonProperty("user_segment_id")
    private Integer userSegmentId;

    @Nullable
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String body;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        var articleRequestArticle = (ArticleRequestArticle) o;
        return Objects.equals(locale, articleRequestArticle.locale)
                && Objects.equals(permissionGroupId, articleRequestArticle.permissionGroupId)
                && Objects.equals(title, articleRequestArticle.title)
                && Objects.equals(userSegmentId, articleRequestArticle.userSegmentId)
                && Objects.equals(body, articleRequestArticle.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locale, permissionGroupId, title, userSegmentId, body);
    }

    @Override
    public String toString() {
        return "ArticleRequestArticle("
                + "locale: " + getLocale() + ", "
                + "permissionGroupId: " + getPermissionGroupId() + ", "
                + "title: " + getTitle() + ", "
                + "userSegmentId: " + getUserSegmentId() + ", "
                + "body: " + getBody()
                + ")";
    }
}