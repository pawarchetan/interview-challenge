package com.pleo.controller;

import com.pleo.service.WaterContainerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(WaterContainerController.class)
public class WaterContainerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WaterContainerService waterContainerService;

    @Test
    public void shouldReturnUnitsOfWaterContained() throws Exception {
        int[] cellHeights = new int[]{1,2,0,2};
        when(waterContainerService.getUnitsOfWaterContained(cellHeights)).thenReturn(2);
        mockMvc.perform(get("/watercontainer/api/v1/units?height=1&height=2&height=0&height=2")
                .contentType("application/json")
                .accept("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().string("2"))
                .andExpect(content().contentTypeCompatibleWith("application/json;charset=UTF-8"));
    }

}
