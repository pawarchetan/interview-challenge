package com.pleo.controller;

import com.pleo.model.StructureDto;
import com.pleo.service.WaterContainerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/watercontainer/api/v1")
@Api(description = "Operation to return/get units of water contained in container formed by cells.")
public class WaterContainerController {

    private final WaterContainerService waterContainerService;

    @Autowired
    public WaterContainerController(WaterContainerService waterContainerService) {
        this.waterContainerService = waterContainerService;
    }

    @GetMapping(value = "/units", produces = "application/json")
    @ApiOperation(value = "Get units of water contained in container formed by cells.", response = StructureDto.class)
    public StructureDto getUnitsOfWaterContained(@RequestParam(value = "height") int[] cellHeights) {
        return waterContainerService.getUnitsOfWaterContained(cellHeights);
    }
}
