package lol.pbu.z4j.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Objects;

/**
 * ArticleRequest
 *
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@Data
public class ArticleRequest {

    @NotNull
    @Valid
    private ArticleRequestArticle article;

    @Nullable
    @JsonProperty("notify_subscribers")
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Boolean notifySubscribers;

    public ArticleRequest(ArticleRequestArticle article) {
        this.article = article;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        var articleRequest = (ArticleRequest) o;
        return Objects.equals(article, articleRequest.article)
                && Objects.equals(notifySubscribers, articleRequest.notifySubscribers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article, notifySubscribers);
    }

    @Override
    public String toString() {
        return "ArticleRequest("
                + "article: " + getArticle() + ", "
                + "notifySubscribers: " + getNotifySubscribers()
                + ")";
    }

}