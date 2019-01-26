package com.pleo.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WaterContainerServiceTest {

    private WaterContainerService waterContainerService;

    @Before
    public void setUp(){
        waterContainerService = new WaterContainerService();
    }

    @Test
    public void shouldReturn2UnitsOfWaterContainedForGivenCellHeights(){
        int[] cellHeights = new int[] {1, 2, 0, 2};
        int expectedUnitsOfWaterContained = 2;
        int actualUnitsOfWaterContained = waterContainerService.getUnitsOfWaterContained(cellHeights);
        assertEquals(expectedUnitsOfWaterContained, actualUnitsOfWaterContained);
    }

    @Test
    public void shouldReturn17UnitsOfWaterContainedForGivenCellHeights(){
        int[] cellHeights = new int[] {2, 5, 1, 3, 1, 2, 1, 7, 7, 6};
        int expectedUnitsOfWaterContained = 17;
        int actualUnitsOfWaterContained = waterContainerService.getUnitsOfWaterContained(cellHeights);
        assertEquals(expectedUnitsOfWaterContained, actualUnitsOfWaterContained);
    }

    @Test
    public void shouldReturn8UnitsOfWaterContainedForGivenCellHeights(){
        int[] cellHeights = new int[] {0, 1, 2, 3, 0, 2, 1, 0, 1, 0, 2};
        int expectedUnitsOfWaterContained = 8;
        int actualUnitsOfWaterContained = waterContainerService.getUnitsOfWaterContained(cellHeights);
        assertEquals(expectedUnitsOfWaterContained, actualUnitsOfWaterContained);
    }

}
