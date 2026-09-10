package lol.pbu.z4j.ratelimit;

import io.micronaut.context.annotation.ConfigurationProperties;
import lombok.Data;

@ConfigurationProperties("z4j.rate-limit")
@Data
public class RateLimitConfiguration {
    public static final String PREFIX = "z4j.rate-limit";

    /**
     * Whether to automatically wait/pause when approaching rate limits before sending a request.
     */
    private boolean autoWaitEnabled = true;

    /**
     * The duration to wait (in seconds) before proceeding, if approaching a rate limit.
     */
    private long waitDurationSeconds = 60;

    /**
     * The remaining request count threshold to trigger the auto-wait.
     */
    private int approachThreshold = 50;
}
