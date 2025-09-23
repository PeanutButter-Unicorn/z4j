package lol.pbu.command;

import io.micronaut.configuration.picocli.PicocliRunner;
import lol.pbu.command.provider.ZcmiVersionProvider;
import picocli.CommandLine.Command;

/**
 * @author Jonathan Zollinger
 * @since 0.0.1
 */
@Command(name = "zcmi", description = "...", mixinStandardHelpOptions = true,
        versionProvider = ZcmiVersionProvider.class,
        subcommands = LocaleCommand.class)
public class ZcmiCommand extends BaseCommand implements Runnable {

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(ZcmiCommand.class, args);
    }

    public void run() {
        err("No command specified");
    }
}
