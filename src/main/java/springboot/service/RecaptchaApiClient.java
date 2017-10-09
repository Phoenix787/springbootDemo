package springboot.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import springboot.dto.RecaptchaResponseDto;

@Component
public class RecaptchaApiClient {
    @Value("${app.reCaptcha.apiUrl}")
    private String reCaptchaApiUrl;
    @Value("${app.reCaptcha.secretKey}")
    private String secretKey;
    private RestTemplate restTemplate = new RestTemplate();

    public RecaptchaResponseDto verify(@NonNull String recaptchaResponse) {
        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("secret", secretKey);
        form.add("response", recaptchaResponse);

        return restTemplate.postForObject(reCaptchaApiUrl, form, RecaptchaResponseDto.class);
    }
}
