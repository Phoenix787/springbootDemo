package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.service.CsvWebsiteWriter;
import springboot.service.WebsiteService;

@RestController
@RequestMapping("/csv")
public class CsvController {

    @Autowired
    private WebsiteService websiteService;

    @Autowired
    private CsvWebsiteWriter csvWebsiteWriter;

    @RequestMapping
    public void exportToCsv(){
        String fileName = "export.csv";

        csvWebsiteWriter.write(fileName, websiteService.findAll());
    }
}
