package springboot.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import springboot.entity.Visitor;
import springboot.repository.VisitorRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Controller
//@EnableAutoConfiguration
public class ExampleController {

//    private VisitorRepository visitorRepository;
//
//    public ExampleController(VisitorRepository visitorRepository) {
//        this.visitorRepository = visitorRepository;
//    }
//
//    @RequestMapping("/index")
////    public String setHelloWorld() {
////        return "index";
////    }
//    public ModelAndView index(){
//        Map<String, String> model = new HashMap<String, String>();
//        model.put("name", "Xenia");
//        Visitor visitor = new Visitor();
//        visitor.setDescription(String.format("Visit at site on %s", LocalDateTime.now()));
//        visitorRepository.save(visitor);
//
//        return new ModelAndView("index", model);
//    }
}
