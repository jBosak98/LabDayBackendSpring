package pl.wroclaw.asi.labdaybackendspring.controllers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.wroclaw.asi.labdaybackendspring.repositories.EventRepository;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class AppDataControllerTest {


    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }


    @Test
    public void getAppDataTestStatus() throws Exception {
        String responseContentType = "application/json;charset=UTF-8";
        MvcResult mvcResult = this.mockMvc
                .perform(get("/api/app_data").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        Assert.assertEquals(responseContentType,mvcResult.getResponse().getContentType());
    }

    @Test
    public void getAppDataTestContent() throws Exception {
        String responseContentType = "application/json;charset=UTF-8";
        MvcResult mvcResult = this.mockMvc
                .perform(get("/api/app_data").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.events",is(empty())))
                .andExpect(jsonPath("$.map_others",is(empty())))
                .andExpect(jsonPath("$.paths",is(empty())))
                .andExpect(jsonPath("$.timetables",is(empty())))
                .andExpect(jsonPath("$.speakers",is(empty())))

                .andReturn();
        Assert.assertEquals(responseContentType,mvcResult.getResponse().getContentType());
    }
}