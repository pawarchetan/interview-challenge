package com.pleo.controller;

import com.pleo.model.StructureDto;
import com.pleo.service.WaterContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/watercontainer/api/v1")
public class WaterContainerController {

    private final WaterContainerService waterContainerService;

    @Autowired
    public WaterContainerController(WaterContainerService waterContainerService) {
        this.waterContainerService = waterContainerService;
    }

    @GetMapping("/units")
    public StructureDto getUnitsOfWaterContained(@RequestParam(value = "height") int[] cellHeights) {
        return waterContainerService.getUnitsOfWaterContained(cellHeights);
    }
}
