package springboot.controller;

import com.google.common.collect.ImmutableList;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import springboot.entity.Website;
import springboot.service.WebsiteService;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WebsitesControllerTest {
    @Mock
    private WebsiteService websiteService;
    @InjectMocks
    WebsitesController sut;

    @org.junit.Test
    public void getListOfProviders() throws Exception {
        //prepare
        when(websiteService.findAll()).thenReturn(ImmutableList.of());
        //testing
        List<Website> listOfProviders = sut.getListOfProviders();
        //validate _ нам необходимо проверить что метод findAll() вызывался
        verify(websiteService).findAll();
    }

}