package lol.pbu.z4j.client;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.client.annotation.Client;
import lol.pbu.z4j.model.response.LocaleResponse;
import lol.pbu.z4j.model.response.LocalesResponse;
import reactor.core.publisher.Mono;

@Client("${micronaut.http.services.zendesk.url}/api/v2")
public interface LocalesClient {

  /**
   * Lists the translation locales available for the account.
   * <p><strong>Note</strong>: You can alter the list by passing an updated <code>locale_ids</code> array to the <a href="/api-reference/ticketing/account-configuration/account_settings/#update-account-settings">Update Account Settings</a> endpoint.</p>
   * <h4 id="allowed-for">Allowed For</h4>
   * <ul>
   * <li>Anyone</li>
   * </ul>
   * @return 200 - Success
   */
  @Get("/locales")
  Mono<LocalesResponse> listLocales();

  @Get("/locales/{locale_id}")
  Mono<LocaleResponse> showLocaleById(@PathVariable("locale_id") Long localeId);

  @Get("/locales/agent")
  Mono<LocalesResponse> listLocalesForAgent();

  @Get("/locales/current")
  Mono<LocaleResponse> showCurrentLocale();

  @Get("/locales/detect_best_locale")
  Mono<LocaleResponse> detectBestLocale();

  @Get("/locales/public")
  Mono<LocalesResponse> listAvailablePublicLocales();

}
