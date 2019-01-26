package com.pleo.service;

import org.springframework.stereotype.Service;

@Service
public class WaterContainerService {

    public int getUnitsOfWaterContained(int[] cellHeights) {
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
}
