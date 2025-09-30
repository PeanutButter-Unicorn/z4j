package lol.pbu.z4j.cli.command;

import io.micronaut.context.annotation.Value;
import io.micronaut.core.annotation.ReflectiveAccess;
import jakarta.inject.Inject;
import jakarta.inject.Provider;
import lol.pbu.z4j.cli.util.BaseCommand;
import lol.pbu.z4j.client.LocalesClient;
import lol.pbu.z4j.model.Locale;
import picocli.CommandLine.Command;

import java.util.List;

/**
 * @author Jonathan Zollinger
 * @since 0.0.7
 */
@Command(name = "locale", description = "Manage locales for your Zendesk account",
        mixinStandardHelpOptions = true)
public class LocaleCommand extends BaseCommand implements Runnable {

    @Inject @ReflectiveAccess
    Provider<LocalesClient> localesClientProvider;

    @Value("$z4j.token")
    String token;

    @Value("$z4j.url")
    String zendeskUrl;

    LocalesClient localesClient;

    @Override
    public void run() {
        err("No command specified for Locales command");
    }

    @Command(name = "list", aliases = "ls", description = "list locales for this zendesk account")
    List<Locale> getLocales(){
        return getLocalesClient().listLocales().body().getLocales();
    }


    private LocalesClient getLocalesClient() throws IllegalStateException{
        if (null != localesClient){
            return localesClient;
        }
        if (token == null || token.isBlank()) {
            err("Error: The Environment Variable Z4J_TOKEN is not set.");
            throw new IllegalStateException("The Environment Variable Z4J_TOKEN is not set.");
        }
        if (zendeskUrl == null || zendeskUrl.isBlank()) {
            err("Error: The Environment Variable Z4J_URL is not set.");
            throw new IllegalStateException("The Environment Variable Z4J_URL is not set.");
        }
        localesClient = localesClientProvider.get();
        return localesClient;
    }
}
