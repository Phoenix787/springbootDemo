package springboot.service;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.Cleanup;
import lombok.NonNull;
import org.springframework.stereotype.Component;
import springboot.entity.SitesDto;
import springboot.entity.Website;

import java.io.*;
import java.util.List;

@Component
public class CsvWebsiteWriter {
    private CsvMapper csvMapper = new CsvMapper();
    private CsvSchema schema = csvMapper.schemaFor(Website.class).withHeader()
            .sortedBy("title", "iconImageUrl", "website", "description");


     public void write(@NonNull String fileName, @NonNull List<Website> data) {

        try {
            @Cleanup Writer writer = new PrintWriter(new FileWriter(new File(fileName)));
            doWrite(writer, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void doWrite(@NonNull Writer writer, @NonNull List<Website> data) throws IOException {
        csvMapper.writer().with(schema).writeValues(writer).writeAll(data);
    }
}
