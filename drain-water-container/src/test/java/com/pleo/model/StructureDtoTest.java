package com.pleo.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class StructureDtoTest {

    private StructureDto structureDto;

    @Before
    public void setUp() {
        structureDto = new StructureDto();
    }

    @Test
    public void shouldVerifyStructureDtoGetterAndSetters() {
        structureDto.setWaterContainedCells(new int[]{1, 2, 3});
        structureDto.setTotalUnitsOfWaterContained(0);

        assertEquals(0, structureDto.getTotalUnitsOfWaterContained());
        assertArrayEquals(new int[]{1, 2, 3}, structureDto.getWaterContainedCells());
    }
}
