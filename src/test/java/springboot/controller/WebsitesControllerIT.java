package springboot.controller;

import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import springboot.Application;
import springboot.entity.Website;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebsitesControllerIT {
    //TestRestTemplate template = new TestRestTemplate();
    @Autowired
    MockMvc mockMvc;

    @Test
    public void testGetListOfProviders() throws Exception{
        //test
//        ResponseEntity<List<Website>> responseEntity = template.exchange("http://localhost:8090/api/web",
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<Website>>() {
//                });
//        List<Website> actualList = responseEntity.getBody();
//        List<String> actualTitles = actualList.stream()
//                                        .map(Website::getTitle)
//                                        .collect(collectingAndThen(toList(), ImmutableList::copyOf));
//        assertThat(actualTitles, containsInAnyOrder("website1", "website2"));
        mockMvc.perform(get("http://localhost:8090/api/web").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                //.andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
    }
}