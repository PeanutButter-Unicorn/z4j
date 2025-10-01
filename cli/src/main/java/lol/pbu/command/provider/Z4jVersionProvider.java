package lol.pbu.command.provider;

import io.micronaut.context.annotation.Value;
import picocli.CommandLine.IVersionProvider;


/**
 * Generates version information. Example usage:
 * <pre>
 * &#064;Command(name = 'command', versionProvider = ZcmiVersionProvider)
 * class App {
 *     &#064;Option(names = {"-V", "--version"}, versionHelp = true, description = "Display version information and quit.")
 *     boolean isVersionRequested
 * }
 * </pre>
 * Or use picocli's built-in standard usage help option (--help and -h) and version help option (-V and --version).
 * <pre>
 * &#064;Command(name = 'command', mixinStandardHelpOptions = true, versionProvider = ZcmiVersionProvider)
 * class App {
 *     // ...
 * }
 * </pre>
 *
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
public class Z4jVersionProvider implements IVersionProvider {

    @Value("${micronaut.application.version}")
    String z4jVersion;

    @Override
    public String[] getVersion() {
        return new String[]{z4jVersion};
    }
}

