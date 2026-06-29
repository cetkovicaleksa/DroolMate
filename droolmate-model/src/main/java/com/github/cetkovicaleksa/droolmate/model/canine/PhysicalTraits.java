package com.github.cetkovicaleksa.droolmate.model.canine;

/**
 * Physical traits for a canine or a canine breed.
 */
public class PhysicalTraits {
    private final double minHeightCm;
    private final double maxHeightCm;
    private final double minWeightKg;
    private final double maxWeightKg;

    public PhysicalTraits(double minHeightCm, double maxHeightCm,
                          double minWeightKg, double maxWeightKg) {
        this.minHeightCm = minHeightCm;
        this.maxHeightCm = maxHeightCm;
        this.minWeightKg = minWeightKg;
        this.maxWeightKg = maxWeightKg;
    }

    public double getMinHeightCm() {
        return minHeightCm;
    }

    public double getMaxHeightCm() {
        return maxHeightCm;
    }

    public double getMinWeightKg() {
        return minWeightKg;
    }

    public double getMaxWeightKg() {
        return maxWeightKg;
    }
}