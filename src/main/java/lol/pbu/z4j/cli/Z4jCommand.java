package lol.pbu.z4j.cli;

import io.micronaut.configuration.picocli.PicocliRunner;
import lol.pbu.z4j.cli.util.BaseCommand;
import lol.pbu.z4j.cli.util.Z4jVersionProvider;
import picocli.CommandLine.Command;
import picocli.CommandLine.ParameterException;
import picocli.jansi.graalvm.AnsiConsole;

@Command(mixinStandardHelpOptions = true,
        name = "z4j", versionProvider = Z4jVersionProvider.class,
        description = "z4j-cli is a terminal tool to help specialists and admin using Z4j")
public class Z4jCommand extends BaseCommand implements Runnable {

    public static void main(String[] args) {
        try (AnsiConsole ignored = AnsiConsole.windowsInstall()) {
            PicocliRunner.run(Z4jCommand.class, args);
        }
    }

    @Override
    public void run() {
        err("No command specified");
    }
}

