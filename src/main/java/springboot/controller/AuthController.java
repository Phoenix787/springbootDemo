package springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springboot.dto.RecaptchaResponseDto;
import springboot.dto.RegisterDto;
import springboot.service.RecaptchaApiClient;

@Slf4j
@RestController
public class AuthController {
    @Autowired
    private RecaptchaApiClient recaptchaApiClient;


    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(RegisterDto registerDto) {
        log.info("" + registerDto);

        RecaptchaResponseDto recaptchaResponse = recaptchaApiClient.verify(registerDto.getRecaptchaResponse());
        log.info("" + recaptchaResponse);

        if (!recaptchaResponse.isSuccess()) {
            throw new RuntimeException();
        }


    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleRuntimeException(RuntimeException ex) {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
