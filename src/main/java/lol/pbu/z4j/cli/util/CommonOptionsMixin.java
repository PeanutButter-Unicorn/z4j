package lol.pbu.z4j.cli.util;

import io.micronaut.core.annotation.ReflectiveAccess;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

/**
 * Mixin that adds help, version and other common options to a command. Example usage:
 * <pre>
 * &#064;Command(name = "command")
 * class App {
 *     &#064;Mixin
 *     CommonOptionsMixin commonOptions // adds common options to the command
 *
 *     // ...
 * }
 * </pre>
 *
 * @author Jonathan Zollinger
 * @version 0.0.7
 */
@Command(mixinStandardHelpOptions = true, versionProvider = Z4jVersionProvider.class)
@SuppressWarnings("checkstyle:VisibilityModifier")
public class CommonOptionsMixin {

    @Option(names = {"-x", "--stacktrace"}, defaultValue = "false", description = "Show full stack trace when exceptions occur.")
    @ReflectiveAccess
    public boolean showStacktrace;

    @Option(names = {"-v", "--verbose"}, defaultValue = "false", description = "Create verbose output.")
    @ReflectiveAccess
    public boolean verbose;
}