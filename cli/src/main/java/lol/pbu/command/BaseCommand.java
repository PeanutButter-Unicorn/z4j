package lol.pbu.command;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.ReflectiveAccess;
import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Spec;

import java.io.PrintWriter;
import java.util.Optional;

import static picocli.CommandLine.Help.Ansi.AUTO;

/**
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Command
public class BaseCommand {

    @Spec
    @ReflectiveAccess
    protected CommandSpec spec;


    public void out(String message) {
        outWriter().ifPresent(writer -> writer.println(AUTO.string(message)));
    }

    public void err(String message) {
        errWriter().ifPresent(writer -> writer.println(AUTO.string("@|bold,red | Error|@ " + message)));
    }

    public void warning(String message) {
        outWriter().ifPresent(writer -> writer.println(AUTO.string("@|bold,red | Warning|@ " + message)));
    }

    public void green(String message) {
        outWriter().ifPresent(writer -> writer.println(AUTO.string("@|bold,green " + message + "|@")));
    }

    public void red(String message) {
        outWriter().ifPresent(writer -> writer.println(AUTO.string("@|bold,red " + message + "|@")));
    }

    @NonNull
    public Optional<PrintWriter> outWriter() {
        return getSpec().map(spec -> spec.commandLine().getOut());
    }

    @NonNull
    public Optional<PrintWriter> errWriter() {
        return getSpec().map(spec -> spec.commandLine().getErr());
    }

    @NonNull
    public Optional<CommandSpec> getSpec() {
        return Optional.ofNullable(spec);
    }
}
