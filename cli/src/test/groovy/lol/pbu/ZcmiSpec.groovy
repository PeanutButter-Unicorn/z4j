package lol.pbu

import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext
import io.micronaut.context.env.Environment
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

import java.util.regex.Pattern

class ZcmiSpec extends Specification {

    @Shared
    Pattern blankRegex

    @Shared
    @AutoCleanup
    ApplicationContext ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)

    def setupSpec() {
        blankRegex = Pattern.compile "^\\s*\$"
    }

        /**
     * Executes a command with the given arguments and a specific application context,
     * capturing stdout and stderr.
     *
     * @param ctx The application context to use for running the command.
     * @param args The arguments to pass to the command.
     * @return An array containing the captured stdout (at index 0) and stderr (at index 1)
     *         as String representations of the output streams.
     */
    String[] executeCommand(Class<Runnable> clazz, ApplicationContext ctx, String... args) {
        OutputStream out = new ByteArrayOutputStream()
        OutputStream err = new ByteArrayOutputStream()
        System.setOut(new PrintStream(out))
        System.setErr(new PrintStream(err))
        PicocliRunner.run(clazz, ctx, args)
        return new String[]{out.toString().trim(), err.toString().trim()}
    }
}
