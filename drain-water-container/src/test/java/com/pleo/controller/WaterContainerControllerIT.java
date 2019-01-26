package com.pleo.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WaterContainerControllerIT {

    private MockMvc mockMvc;

    @Autowired
    private WaterContainerController waterContainerController;

    @Before
    public void setup() {
        mockMvc = standaloneSetup(this.waterContainerController).build();
    }

    @Test
    public void shouldReturnUnitsOfWaterContained() throws Exception {
        mockMvc.perform(get("/watercontainer/api/v1/units?height=1&height=2&height=0&height=2")
                .contentType("application/json")
                .accept("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().string("2"))
                .andExpect(content().contentTypeCompatibleWith("application/json;charset=UTF-8"));
    }
}
