package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.service.HealthService;

@RestController

public class HealthCheckController {

    @Autowired
    private HealthService healthService;

    @RequestMapping("/check")
    public String checkStatus() {
        healthService.clearAttempt();
        return healthService.getHealth();
    }
}
