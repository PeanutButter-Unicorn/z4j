package lol.pbu.z4j.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.Valid;
import lol.pbu.z4j.model.ArticleAttachment;
import lombok.Data;

import java.util.Objects;

/**
 * ArticleAttachmentResponse
 *
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@Data
public class ArticleAttachmentResponse {

    @Nullable
    @Valid
    @JsonProperty("article_attachment")
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private ArticleAttachment articleAttachment;
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        var articleAttachmentResponse = (ArticleAttachmentResponse) o;
        return Objects.equals(articleAttachment, articleAttachmentResponse.articleAttachment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleAttachment);
    }

    @Override
    public String toString() {
        return "ArticleAttachmentResponse("
                + "articleAttachment: " + getArticleAttachment()
                + ")";
    }

}