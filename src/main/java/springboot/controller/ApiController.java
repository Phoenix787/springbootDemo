package springboot.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.entity.Visitor;
import springboot.repository.VisitorRepository;

@RestController
//@EnableAutoConfiguration
@RequestMapping("/api")
public class ApiController {

    private VisitorRepository vr;

    public ApiController(VisitorRepository vr) {
        this.vr = vr;
    }

    @GetMapping("/visits")
    public Iterable<Visitor> getVisits() {
        return vr.findAll();
    }


}
