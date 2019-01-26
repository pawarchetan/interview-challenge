package com.pleo.service;

import com.pleo.exception.InvalidCellHeightsException;
import org.springframework.stereotype.Service;

@Service
public class WaterContainerService {

    public int getUnitsOfWaterContained(int[] cellHeights) {

        validateCells(cellHeights);

        int totalUnitsOfWaterContained = 0;

        for (int index = 0; index < cellHeights.length - 1; index++) {
            int maxLeftCellHeight;
            int maxRightCellHeight;

            maxRightCellHeight = getMaxRightCellHeight(index, cellHeights);
            maxLeftCellHeight = getMaxLeftCellHeight(index, cellHeights);

            totalUnitsOfWaterContained = totalUnitsOfWaterContained + Math.min(maxLeftCellHeight, maxRightCellHeight) - cellHeights[index];
        }
        return totalUnitsOfWaterContained;
    }

    private int getMaxLeftCellHeight(int index, int[] cellHeights) {
        int maxLeftCellHeight = 0;
        for (int j = index; j >= 0; j--) {
            maxLeftCellHeight = Math.max(maxLeftCellHeight, cellHeights[j]);
        }
        return maxLeftCellHeight;
    }

    private int getMaxRightCellHeight(int index, int[] cellHeights) {
        int maxRightCellHeight = 0;
        for (int j = index; j < cellHeights.length; j++) {
            maxRightCellHeight = Math.max(maxRightCellHeight, cellHeights[j]);
        }
        return maxRightCellHeight;
    }

    private void validateCells(int[] cellHeights) {
        if (cellHeights.length == 0)
            throw new InvalidCellHeightsException("Ohh God, why you want to try impossible things.Insert some cell heights, form a " +
                    "container and then " +
                    "check");

        if (cellHeights.length == 2)
            throw new InvalidCellHeightsException("Invalid number of cells present in structure.\n" +
                    "Hints: \n" +
                    "1. You need minimum 3 cells to form a basin to collect water.\n" +
                    "2. You are trying to collect water without container / basin , you naughty person its not possible.");
    }
}
