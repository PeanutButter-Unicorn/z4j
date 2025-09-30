package lol.pbu.z4j.cli.util;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.ReflectiveAccess;
import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Spec;

import java.io.PrintWriter;
import java.util.Optional;

import static picocli.CommandLine.Help.Ansi.AUTO;

@Command
public class BaseCommand implements ConsoleOutput{

    @Spec
    @ReflectiveAccess
    protected CommandSpec spec;

    @Override
    public void out(String message) {
        outWriter().ifPresent(writer -> writer.println(AUTO.string(message)));
    }

    public void err(String message) {
        errWriter().ifPresent(writer -> writer.println(AUTO.string("@|bold,red | Error|@ " + message)));
    }

    public void warning(String message) {
        outWriter().ifPresent(writer -> writer.println(AUTO.string("@|bold,red | Warning|@ " + message)));
    }

    @Override
    public void green(String message) {
        outWriter().ifPresent(writer -> writer.println(AUTO.string("@|bold,green " + message + "|@")));
    }

    @Override
    public void red(String message) {
        outWriter().ifPresent(writer -> writer.println(AUTO.string("@|bold,red " + message + "|@")));
    }

    @Override
    public boolean showStacktrace() {
        return false;
    }

    @Override
    public boolean verbose() {
        return false;
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
