package lol.pbu.z4j.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.Valid;
import lol.pbu.z4j.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * PostsResponse
 *
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder(PostsResponse.JSON_PROPERTY_POSTS)
public class PostsResponse {

    public static final String JSON_PROPERTY_POSTS = "posts";

    @Nullable
    @JsonProperty(JSON_PROPERTY_POSTS)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<@Valid Post> posts;

    /**
     * @return the posts property value
     */
    public List<@Valid Post> getPosts() {
        return posts;
    }

    /**
     * Set the posts property value
     *
     * @param posts property value to set
     */
    public void setPosts(List<@Valid Post> posts) {
        this.posts = posts;
    }

    /**
     * Set posts in a chainable fashion.
     *
     * @return The same instance of PostsResponse for chaining.
     */
    public PostsResponse posts(List<@Valid Post> posts) {
        this.posts = posts;
        return this;
    }

    /**
     * Add an item to the posts property in a chainable fashion.
     *
     * @return The same instance of PostsResponse for chaining.
     */
    public PostsResponse addPostsItem(Post postsItem) {
        if (posts == null) {
            posts = new ArrayList<>();
        }
        posts.add(postsItem);
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
        var postsResponse = (PostsResponse) o;
        return Objects.equals(posts, postsResponse.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(posts);
    }

    @Override
    public String toString() {
        return "PostsResponse("
                + "posts: " + getPosts()
                + ")";
    }

}