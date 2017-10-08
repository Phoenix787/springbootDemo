package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import springboot.entity.Website;
import springboot.service.WebsiteService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/web")
public class WebsitesController {

   @Autowired
    private WebsiteService websiteService;

    @RequestMapping
    public List<Website> getListOfProviders() {
        return websiteService.findAll();
    }
//    public ModelAndView index(){
//        Map<String, String> model = new HashMap<String, String>();
//        model.put("name", "Xenia");
//        return new ModelAndView("websites", model);
//    }


}
