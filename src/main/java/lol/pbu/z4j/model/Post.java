package lol.pbu.z4j.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotNull;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Post
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder({
    Post.JSON_PROPERTY_TITLE,
    Post.JSON_PROPERTY_AUTHOR_ID,
    Post.JSON_PROPERTY_CLOSED,
    Post.JSON_PROPERTY_COMMENT_COUNT,
    Post.JSON_PROPERTY_CONTENT_TAG_IDS,
    Post.JSON_PROPERTY_CREATED_AT,
    Post.JSON_PROPERTY_DETAILS,
    Post.JSON_PROPERTY_FEATURED,
    Post.JSON_PROPERTY_FOLLOWER_COUNT,
    Post.JSON_PROPERTY_HTML_URL,
    Post.JSON_PROPERTY_ID,
    Post.JSON_PROPERTY_NON_AUTHOR_EDITOR_ID,
    Post.JSON_PROPERTY_NON_AUTHOR_UPDATED_AT,
    Post.JSON_PROPERTY_PINNED,
    Post.JSON_PROPERTY_STATUS,
    Post.JSON_PROPERTY_TOPIC_ID,
    Post.JSON_PROPERTY_UPDATED_AT,
    Post.JSON_PROPERTY_URL,
    Post.JSON_PROPERTY_VOTE_COUNT,
    Post.JSON_PROPERTY_VOTE_SUM,
})
public class Post {

    public static final String JSON_PROPERTY_TITLE = "title";
    public static final String JSON_PROPERTY_AUTHOR_ID = "author_id";
    public static final String JSON_PROPERTY_CLOSED = "closed";
    public static final String JSON_PROPERTY_COMMENT_COUNT = "comment_count";
    public static final String JSON_PROPERTY_CONTENT_TAG_IDS = "content_tag_ids";
    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    public static final String JSON_PROPERTY_DETAILS = "details";
    public static final String JSON_PROPERTY_FEATURED = "featured";
    public static final String JSON_PROPERTY_FOLLOWER_COUNT = "follower_count";
    public static final String JSON_PROPERTY_HTML_URL = "html_url";
    public static final String JSON_PROPERTY_ID = "id";
    public static final String JSON_PROPERTY_NON_AUTHOR_EDITOR_ID = "non_author_editor_id";
    public static final String JSON_PROPERTY_NON_AUTHOR_UPDATED_AT = "non_author_updated_at";
    public static final String JSON_PROPERTY_PINNED = "pinned";
    public static final String JSON_PROPERTY_STATUS = "status";
    public static final String JSON_PROPERTY_TOPIC_ID = "topic_id";
    public static final String JSON_PROPERTY_UPDATED_AT = "updated_at";
    public static final String JSON_PROPERTY_URL = "url";
    public static final String JSON_PROPERTY_VOTE_COUNT = "vote_count";
    public static final String JSON_PROPERTY_VOTE_SUM = "vote_sum";

    /**
     * The title of the post
     */
    @NotNull
    @JsonProperty(JSON_PROPERTY_TITLE)
    private String title;

    /**
     * The id of the author of the post. *Writable on create by Help Center managers -- see Create Post
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_AUTHOR_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer authorId;

    /**
     * Whether further comments are allowed
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_CLOSED)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Boolean closed;

    /**
     * The number of comments on the post
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_COMMENT_COUNT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer commentCount;

    /**
     * The list of content tags attached to the post
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_CONTENT_TAG_IDS)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private List<@NotNull Integer> contentTagIds;

    /**
     * When the post was created. Writable on create by Help Center managers -- see <a href="#create-post">Create Post</a>
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private ZonedDateTime createdAt;

    /**
     * The details of the post made by the author. See <a href="#user-content">User content</a>
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_DETAILS)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String details;

    /**
     * Whether the post is featured
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_FEATURED)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Boolean featured;

    /**
     * The number of followers of the post
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_FOLLOWER_COUNT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer followerCount;

    /**
     * The community url of the post
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_HTML_URL)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String htmlUrl;

    /**
     * Automatically assigned when the post is created
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer id;

    /**
     * The user id of whoever performed the most recent (if any) non-author edit. A non-author edit consists of an edit make by a user other than the author that creates or updates the &#x60;title&#x60; or &#x60;details&#x60;. Note that only edits made after May 17, 2021 will be reflected in this field. If no non-author edits have occured since May 17, 2021, then this field will be &#x60;null&#x60;.
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_NON_AUTHOR_EDITOR_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer nonAuthorEditorId;

    /**
     * When the post was last edited by a non-author user
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_NON_AUTHOR_UPDATED_AT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private ZonedDateTime nonAuthorUpdatedAt;

    /**
     * When true, pins the post to the top of its topic
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_PINNED)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Boolean pinned;

    /**
     * The status of the post. Possible values: \&quot;planned\&quot;, \&quot;not_planned\&quot; , \&quot;answered\&quot;, or \&quot;completed\&quot;
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_STATUS)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String status;

    /**
     * The id of the topic that the post belongs to
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_TOPIC_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer topicId;

    /**
     * When the post was last updated
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_UPDATED_AT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private ZonedDateTime updatedAt;

    /**
     * The API url of the post
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_URL)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String url;

    /**
     * The total number of upvotes and downvotes
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_VOTE_COUNT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer voteCount;

    /**
     * The sum of upvotes (+1) and downvotes (-1), which may be positive or negative
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_VOTE_SUM)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer voteSum;

    public Post(String title) {
        this.title = title;
    }

    /**
     * The title of the post
     *
     * @return the title property value
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the title property value
     *
     * @param title property value to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Set title in a chainable fashion.
     *
     * @return The same instance of Post for chaining.
     */
    public Post title(String title) {
        this.title = title;
        return this;
    }

    /**
     * The id of the author of the post. *Writable on create by Help Center managers -- see Create Post
     *
     * @return the authorId property value
     */
    public Integer getAuthorId() {
        return authorId;
    }

    /**
     * Set the authorId property value
     *
     * @param authorId property value to set
     */
    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    /**
     * Whether further comments are allowed
     *
     * @return the closed property value
     */
    public Boolean getClosed() {
        return closed;
    }

    /**
     * Set the closed property value
     *
     * @param closed property value to set
     */
    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    /**
     * Set closed in a chainable fashion.
     *
     * @return The same instance of Post for chaining.
     */
    public Post closed(Boolean closed) {
        this.closed = closed;
        return this;
    }

    /**
     * The number of comments on the post
     *
     * @return the commentCount property value
     */
    public Integer getCommentCount() {
        return commentCount;
    }

    /**
     * Set the commentCount property value
     *
     * @param commentCount property value to set
     */
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * The list of content tags attached to the post
     *
     * @return the contentTagIds property value
     */
    public List<@NotNull Integer> getContentTagIds() {
        return contentTagIds;
    }

    /**
     * Set the contentTagIds property value
     *
     * @param contentTagIds property value to set
     */
    public void setContentTagIds(List<@NotNull Integer> contentTagIds) {
        this.contentTagIds = contentTagIds;
    }

    /**
     * Set contentTagIds in a chainable fashion.
     *
     * @return The same instance of Post for chaining.
     */
    public Post contentTagIds(List<@NotNull Integer> contentTagIds) {
        this.contentTagIds = contentTagIds;
        return this;
    }
    /**
     * Add an item to the contentTagIds property in a chainable fashion.
     *
     * @return The same instance of Post for chaining.
     */
    public Post addContentTagIdsItem(Integer contentTagIdsItem) {
        if (contentTagIds == null) {
            contentTagIds = new ArrayList<>();
        }
        contentTagIds.add(contentTagIdsItem);
        return this;
    }

    /**
     * When the post was created. Writable on create by Help Center managers -- see <a href="#create-post">Create Post</a>
     *
     * @return the createdAt property value
     */
    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Set the createdAt property value
     *
     * @param createdAt property value to set
     */
    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * The details of the post made by the author. See <a href="#user-content">User content</a>
     *
     * @return the details property value
     */
    public String getDetails() {
        return details;
    }

    /**
     * Set the details property value
     *
     * @param details property value to set
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * Set details in a chainable fashion.
     *
     * @return The same instance of Post for chaining.
     */
    public Post details(String details) {
        this.details = details;
        return this;
    }

    /**
     * Whether the post is featured
     *
     * @return the featured property value
     */
    public Boolean getFeatured() {
        return featured;
    }

    /**
     * Set the featured property value
     *
     * @param featured property value to set
     */
    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    /**
     * Set featured in a chainable fashion.
     *
     * @return The same instance of Post for chaining.
     */
    public Post featured(Boolean featured) {
        this.featured = featured;
        return this;
    }

    /**
     * The number of followers of the post
     *
     * @return the followerCount property value
     */
    public Integer getFollowerCount() {
        return followerCount;
    }

    /**
     * Set the followerCount property value
     *
     * @param followerCount property value to set
     */
    public void setFollowerCount(Integer followerCount) {
        this.followerCount = followerCount;
    }

    /**
     * The community url of the post
     *
     * @return the htmlUrl property value
     */
    public String getHtmlUrl() {
        return htmlUrl;
    }

    /**
     * Set the htmlUrl property value
     *
     * @param htmlUrl property value to set
     */
    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    /**
     * Automatically assigned when the post is created
     *
     * @return the id property value
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set the id property value
     *
     * @param id property value to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * The user id of whoever performed the most recent (if any) non-author edit. A non-author edit consists of an edit make by a user other than the author that creates or updates the &#x60;title&#x60; or &#x60;details&#x60;. Note that only edits made after May 17, 2021 will be reflected in this field. If no non-author edits have occured since May 17, 2021, then this field will be &#x60;null&#x60;.
     *
     * @return the nonAuthorEditorId property value
     */
    public Integer getNonAuthorEditorId() {
        return nonAuthorEditorId;
    }

    /**
     * Set the nonAuthorEditorId property value
     *
     * @param nonAuthorEditorId property value to set
     */
    public void setNonAuthorEditorId(Integer nonAuthorEditorId) {
        this.nonAuthorEditorId = nonAuthorEditorId;
    }

    /**
     * When the post was last edited by a non-author user
     *
     * @return the nonAuthorUpdatedAt property value
     */
    public ZonedDateTime getNonAuthorUpdatedAt() {
        return nonAuthorUpdatedAt;
    }

    /**
     * Set the nonAuthorUpdatedAt property value
     *
     * @param nonAuthorUpdatedAt property value to set
     */
    public void setNonAuthorUpdatedAt(ZonedDateTime nonAuthorUpdatedAt) {
        this.nonAuthorUpdatedAt = nonAuthorUpdatedAt;
    }

    /**
     * When true, pins the post to the top of its topic
     *
     * @return the pinned property value
     */
    public Boolean getPinned() {
        return pinned;
    }

    /**
     * Set the pinned property value
     *
     * @param pinned property value to set
     */
    public void setPinned(Boolean pinned) {
        this.pinned = pinned;
    }

    /**
     * Set pinned in a chainable fashion.
     *
     * @return The same instance of Post for chaining.
     */
    public Post pinned(Boolean pinned) {
        this.pinned = pinned;
        return this;
    }

    /**
     * The status of the post. Possible values: \&quot;planned\&quot;, \&quot;not_planned\&quot; , \&quot;answered\&quot;, or \&quot;completed\&quot;
     *
     * @return the status property value
     */
    public String getStatus() {
        return status;
    }

    /**
     * Set the status property value
     *
     * @param status property value to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Set status in a chainable fashion.
     *
     * @return The same instance of Post for chaining.
     */
    public Post status(String status) {
        this.status = status;
        return this;
    }

    /**
     * The id of the topic that the post belongs to
     *
     * @return the topicId property value
     */
    public Integer getTopicId() {
        return topicId;
    }

    /**
     * Set the topicId property value
     *
     * @param topicId property value to set
     */
    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    /**
     * Set topicId in a chainable fashion.
     *
     * @return The same instance of Post for chaining.
     */
    public Post topicId(Integer topicId) {
        this.topicId = topicId;
        return this;
    }

    /**
     * When the post was last updated
     *
     * @return the updatedAt property value
     */
    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Set the updatedAt property value
     *
     * @param updatedAt property value to set
     */
    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * The API url of the post
     *
     * @return the url property value
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set the url property value
     *
     * @param url property value to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * The total number of upvotes and downvotes
     *
     * @return the voteCount property value
     */
    public Integer getVoteCount() {
        return voteCount;
    }

    /**
     * Set the voteCount property value
     *
     * @param voteCount property value to set
     */
    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    /**
     * The sum of upvotes (+1) and downvotes (-1), which may be positive or negative
     *
     * @return the voteSum property value
     */
    public Integer getVoteSum() {
        return voteSum;
    }

    /**
     * Set the voteSum property value
     *
     * @param voteSum property value to set
     */
    public void setVoteSum(Integer voteSum) {
        this.voteSum = voteSum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        var post = (Post) o;
        return Objects.equals(title, post.title)
            && Objects.equals(authorId, post.authorId)
            && Objects.equals(closed, post.closed)
            && Objects.equals(commentCount, post.commentCount)
            && Objects.equals(contentTagIds, post.contentTagIds)
            && Objects.equals(createdAt, post.createdAt)
            && Objects.equals(details, post.details)
            && Objects.equals(featured, post.featured)
            && Objects.equals(followerCount, post.followerCount)
            && Objects.equals(htmlUrl, post.htmlUrl)
            && Objects.equals(id, post.id)
            && Objects.equals(nonAuthorEditorId, post.nonAuthorEditorId)
            && Objects.equals(nonAuthorUpdatedAt, post.nonAuthorUpdatedAt)
            && Objects.equals(pinned, post.pinned)
            && Objects.equals(status, post.status)
            && Objects.equals(topicId, post.topicId)
            && Objects.equals(updatedAt, post.updatedAt)
            && Objects.equals(url, post.url)
            && Objects.equals(voteCount, post.voteCount)
            && Objects.equals(voteSum, post.voteSum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, authorId, closed, commentCount, contentTagIds, createdAt, details, featured, followerCount, htmlUrl, id, nonAuthorEditorId, nonAuthorUpdatedAt, pinned, status, topicId, updatedAt, url, voteCount, voteSum);
    }

    @Override
    public String toString() {
        return "Post("
            + "title: " + getTitle() + ", "
            + "authorId: " + getAuthorId() + ", "
            + "closed: " + getClosed() + ", "
            + "commentCount: " + getCommentCount() + ", "
            + "contentTagIds: " + getContentTagIds() + ", "
            + "createdAt: " + getCreatedAt() + ", "
            + "details: " + getDetails() + ", "
            + "featured: " + getFeatured() + ", "
            + "followerCount: " + getFollowerCount() + ", "
            + "htmlUrl: " + getHtmlUrl() + ", "
            + "id: " + getId() + ", "
            + "nonAuthorEditorId: " + getNonAuthorEditorId() + ", "
            + "nonAuthorUpdatedAt: " + getNonAuthorUpdatedAt() + ", "
            + "pinned: " + getPinned() + ", "
            + "status: " + getStatus() + ", "
            + "topicId: " + getTopicId() + ", "
            + "updatedAt: " + getUpdatedAt() + ", "
            + "url: " + getUrl() + ", "
            + "voteCount: " + getVoteCount() + ", "
            + "voteSum: " + getVoteSum()
            + ")";
    }

}