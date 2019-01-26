package com.pleo.service;

import com.pleo.exception.InvalidCellHeightsException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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

    @Test
    public void shouldThrownAnExceptionWhenCellHeightsAreIsEmpty() {
        expectedException.expect(InvalidCellHeightsException.class);
        expectedException.expectMessage("Ohh God, why you want to try impossible things.Insert some cell heights, form a container and " +
                "then check");
        waterContainerService.getUnitsOfWaterContained(new int[]{});
    }

    @Test
    public void shouldThrowAnInvalidCellHeightsExceptionWhenNumberOfCellsAreLessThan3() {
        expectedException.expect(InvalidCellHeightsException.class);
        expectedException.expectMessage("Invalid number of cells present in structure.\n" +
                "Hints: \n" +
                "1. You need minimum 3 cells to form a basin to collect water.\n" +
                "2. You are trying to collect water without container / basin , you naughty person its not possible.");
        waterContainerService.getUnitsOfWaterContained(new int[]{0, 1});
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

}
