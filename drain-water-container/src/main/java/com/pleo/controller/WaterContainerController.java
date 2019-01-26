package com.pleo.controller;

import com.pleo.service.WaterContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/watercontainer/api/v1")
public class WaterContainerController {

    @Autowired
    private WaterContainerService waterContainerService;

    @GetMapping("/units")
    public int getUnitsOfWaterContained(@RequestParam(value="height") int[] cellHeights){
        return waterContainerService.getUnitsOfWaterContained(cellHeights);
    }
}
