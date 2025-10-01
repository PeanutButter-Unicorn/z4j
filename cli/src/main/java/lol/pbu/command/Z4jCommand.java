package lol.pbu.command;

import io.micronaut.configuration.picocli.PicocliRunner;
import lol.pbu.command.provider.Z4jVersionProvider;
import picocli.CommandLine.Command;
import picocli.jansi.graalvm.AnsiConsole;

/**
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Command(name = "zcmi", description = "...", mixinStandardHelpOptions = true,
        versionProvider = Z4jVersionProvider.class,
        subcommands = LocaleCommand.class)
public class Z4jCommand extends BaseCommand implements Runnable {

    public static void main(String[] args) {
        try (AnsiConsole ignored = AnsiConsole.windowsInstall()) {
            PicocliRunner.run(Z4jCommand.class, args);
        }
    }

    public void run() {
        err("No command specified");
    }
}
