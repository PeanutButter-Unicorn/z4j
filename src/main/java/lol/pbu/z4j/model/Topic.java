package lol.pbu.z4j.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * The &#x60;manageable_by&#x60; attribute takes one of the following values:  | Value     | Users                       | |-----------|---------------------------- | | staff     | agents and managers         | | managers  | only Help Center managers   |  Note that &#x60;manageable_by&#x60; is only displayed to users who can manage the topic.
 * 
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Serdeable
@JsonPropertyOrder({
    Topic.JSON_PROPERTY_NAME,
    Topic.JSON_PROPERTY_CREATED_AT,
    Topic.JSON_PROPERTY_DESCRIPTION,
    Topic.JSON_PROPERTY_FOLLOWER_COUNT,
    Topic.JSON_PROPERTY_HTML_URL,
    Topic.JSON_PROPERTY_ID,
    Topic.JSON_PROPERTY_MANAGEABLE_BY,
    Topic.JSON_PROPERTY_POSITION,
    Topic.JSON_PROPERTY_UPDATED_AT,
    Topic.JSON_PROPERTY_URL,
    Topic.JSON_PROPERTY_USER_SEGMENT_ID,
})
public class Topic {

    public static final String JSON_PROPERTY_NAME = "name";
    public static final String JSON_PROPERTY_CREATED_AT = "created_at";
    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    public static final String JSON_PROPERTY_FOLLOWER_COUNT = "follower_count";
    public static final String JSON_PROPERTY_HTML_URL = "html_url";
    public static final String JSON_PROPERTY_ID = "id";
    public static final String JSON_PROPERTY_MANAGEABLE_BY = "manageable_by";
    public static final String JSON_PROPERTY_POSITION = "position";
    public static final String JSON_PROPERTY_UPDATED_AT = "updated_at";
    public static final String JSON_PROPERTY_URL = "url";
    public static final String JSON_PROPERTY_USER_SEGMENT_ID = "user_segment_id";

    /**
     * The name of the topic
     */
    @NotNull
    @JsonProperty(JSON_PROPERTY_NAME)
    private String name;

    /**
     * When the topic was created
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_CREATED_AT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String createdAt;

    /**
     * The description of the topic. By default an empty string
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String description;

    /**
     * The number of users following the topic
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_FOLLOWER_COUNT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer followerCount;

    /**
     * The community url of the topic
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_HTML_URL)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String htmlUrl;

    /**
     * Automatically assigned when the topic is created
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer id;

    @Nullable
    @JsonProperty(JSON_PROPERTY_MANAGEABLE_BY)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private TopicManageableBy manageableBy;

    /**
     * The position of the topic relative to other topics in the community
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_POSITION)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer position;

    /**
     * When the topic was last updated
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_UPDATED_AT)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String updatedAt;

    /**
     * The API url of the topic
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_URL)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private String url;

    /**
     * The id of the user segment to which this topic belongs
     */
    @Nullable
    @JsonProperty(JSON_PROPERTY_USER_SEGMENT_ID)
    @JsonInclude(JsonInclude.Include.USE_DEFAULTS)
    private Integer userSegmentId;

    public Topic(String name) {
        this.name = name;
    }

    /**
     * The name of the topic
     *
     * @return the name property value
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name property value
     *
     * @param name property value to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set name in a chainable fashion.
     *
     * @return The same instance of Topic for chaining.
     */
    public Topic name(String name) {
        this.name = name;
        return this;
    }

    /**
     * When the topic was created
     *
     * @return the createdAt property value
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Set the createdAt property value
     *
     * @param createdAt property value to set
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * The description of the topic. By default an empty string
     *
     * @return the description property value
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description property value
     *
     * @param description property value to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Set description in a chainable fashion.
     *
     * @return The same instance of Topic for chaining.
     */
    public Topic description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The number of users following the topic
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
     * The community url of the topic
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
     * Automatically assigned when the topic is created
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
     * @return the manageableBy property value
     */
    public TopicManageableBy getManageableBy() {
        return manageableBy;
    }

    /**
     * Set the manageableBy property value
     *
     * @param manageableBy property value to set
     */
    public void setManageableBy(TopicManageableBy manageableBy) {
        this.manageableBy = manageableBy;
    }

    /**
     * Set manageableBy in a chainable fashion.
     *
     * @return The same instance of Topic for chaining.
     */
    public Topic manageableBy(TopicManageableBy manageableBy) {
        this.manageableBy = manageableBy;
        return this;
    }

    /**
     * The position of the topic relative to other topics in the community
     *
     * @return the position property value
     */
    public Integer getPosition() {
        return position;
    }

    /**
     * Set the position property value
     *
     * @param position property value to set
     */
    public void setPosition(Integer position) {
        this.position = position;
    }

    /**
     * Set position in a chainable fashion.
     *
     * @return The same instance of Topic for chaining.
     */
    public Topic position(Integer position) {
        this.position = position;
        return this;
    }

    /**
     * When the topic was last updated
     *
     * @return the updatedAt property value
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Set the updatedAt property value
     *
     * @param updatedAt property value to set
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * The API url of the topic
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
     * The id of the user segment to which this topic belongs
     *
     * @return the userSegmentId property value
     */
    public Integer getUserSegmentId() {
        return userSegmentId;
    }

    /**
     * Set the userSegmentId property value
     *
     * @param userSegmentId property value to set
     */
    public void setUserSegmentId(Integer userSegmentId) {
        this.userSegmentId = userSegmentId;
    }

    /**
     * Set userSegmentId in a chainable fashion.
     *
     * @return The same instance of Topic for chaining.
     */
    public Topic userSegmentId(Integer userSegmentId) {
        this.userSegmentId = userSegmentId;
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
        var topic = (Topic) o;
        return Objects.equals(name, topic.name)
            && Objects.equals(createdAt, topic.createdAt)
            && Objects.equals(description, topic.description)
            && Objects.equals(followerCount, topic.followerCount)
            && Objects.equals(htmlUrl, topic.htmlUrl)
            && Objects.equals(id, topic.id)
            && Objects.equals(manageableBy, topic.manageableBy)
            && Objects.equals(position, topic.position)
            && Objects.equals(updatedAt, topic.updatedAt)
            && Objects.equals(url, topic.url)
            && Objects.equals(userSegmentId, topic.userSegmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, createdAt, description, followerCount, htmlUrl, id, manageableBy, position, updatedAt, url, userSegmentId);
    }

    @Override
    public String toString() {
        return "Topic("
            + "name: " + getName() + ", "
            + "createdAt: " + getCreatedAt() + ", "
            + "description: " + getDescription() + ", "
            + "followerCount: " + getFollowerCount() + ", "
            + "htmlUrl: " + getHtmlUrl() + ", "
            + "id: " + getId() + ", "
            + "manageableBy: " + getManageableBy() + ", "
            + "position: " + getPosition() + ", "
            + "updatedAt: " + getUpdatedAt() + ", "
            + "url: " + getUrl() + ", "
            + "userSegmentId: " + getUserSegmentId()
            + ")";
    }

}