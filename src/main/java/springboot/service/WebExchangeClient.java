package springboot.service;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import springboot.entity.SiteDto;
import springboot.entity.SitesDto;
import springboot.entity.Website;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Component
public class WebExchangeClient {
//если response возвращается в gzip
    private HttpClient httpClient = HttpClientBuilder.create().build();
    private ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
//-------------------------------------------------------------------------------------------------------------------
    private RestTemplate restTemplate = new RestTemplate(requestFactory);

    public List<SiteDto> getSites() {
        String url = "http://api.stackexchange.com/2.2/sites?page=1&pagesize=20&filter=!8IeYYZbP7kF8WkCg(i*zC";

        try {
            SitesDto response = restTemplate.getForObject(new URI(url), SitesDto.class);
            return response.getItems();
        } catch (URISyntaxException e) {
            throw new RuntimeException();
        }


    }
}
