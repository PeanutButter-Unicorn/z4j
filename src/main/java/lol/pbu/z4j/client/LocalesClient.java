package lol.pbu.z4j.client;


import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import lol.pbu.z4j.model.LocalesList;

/**
 * @author Jonathan Zollinger
 * @since 0.0.2
 */
@Client("${micronaut.http.services.zendesk.url}/api/v2")
public interface LocalesClient {

    @Get("/locales")
    HttpResponse<LocalesList> listLocales();


}
