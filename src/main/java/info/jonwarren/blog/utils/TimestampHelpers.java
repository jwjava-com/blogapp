/**
 * 
 */
package info.jonwarren.blog.utils;

import java.time.Duration;
import java.time.Instant;

/**
 * Static helper methods for dealing with timestamps.
 *
 * @author Jon Warren &lt;jon&#064;jonwarren.info&gt;
 */
public class TimestampHelpers {

    /**
     * Checks to see if two timestamps, of type {@link Instant}, are close to each other. Close is defined as
     * within 1-second or less.
     * 
     * @param a
     *            the first timestamp to compare
     * @param b
     *            the second timestamp to compare
     * @return true if the two timestamps are within 1-second or less of each other, false otherwise
     */
    public static boolean timestampsClose(Instant a, Instant b) {
        if (a == null || b == null) {
            return false;
        }

        Duration diff = Duration.between(a, b);
        if (diff.getSeconds() > 1) {
            return false;
        }

        return true;
    }

}
