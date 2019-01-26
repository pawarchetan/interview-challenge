package com.pleo.service;

import com.pleo.exception.InvalidCellHeightsException;
import org.springframework.stereotype.Service;

@Service
public class WaterContainerService {

    public int getUnitsOfWaterContained(int[] cellHeights) {

        validateCells(cellHeights);

        int totalUnitsOfWaterContained = 0;
        int leftCell = 0, rightCell = cellHeights.length - 1;
        int maxLeftCellHeight = 0, maxRightCellHeight = 0;

        while (leftCell < rightCell) {
            maxLeftCellHeight = Math.max(cellHeights[leftCell], maxLeftCellHeight);
            maxRightCellHeight = Math.max(cellHeights[rightCell], maxRightCellHeight);
            if (maxLeftCellHeight < maxRightCellHeight) {
                totalUnitsOfWaterContained += (maxLeftCellHeight - cellHeights[leftCell]);
                leftCell++;
            } else {
                totalUnitsOfWaterContained += (maxRightCellHeight - cellHeights[rightCell]);
                rightCell--;
            }
        }

        return totalUnitsOfWaterContained;
    }

    private void validateCells(int[] cellHeights) {
        if (cellHeights.length == 0)
            throw new InvalidCellHeightsException("Ohh God, why you want to try impossible things.Insert some cell heights, form a " +
                    "container and then check");

        if (cellHeights.length < 3)
            throw new InvalidCellHeightsException("Invalid number of cells present in structure.\n" +
                    "Hints: \n" +
                    "1. You need minimum 3 cells to form a basin to collect water.\n" +
                    "2. You are trying to collect water without container / basin , you naughty person its not possible.");
    }
}
