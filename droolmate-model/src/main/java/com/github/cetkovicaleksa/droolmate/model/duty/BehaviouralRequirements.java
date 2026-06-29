package com.github.cetkovicaleksa.droolmate.model.duty;

/**
 * Behavioural requirements for a canine duty.
 */
public class BehaviouralRequirements {
    private final double minReactivityScore;
    private final double maxReactivityScore;
    private final double maxAggressionScore;
    private final double minTrainabilityScore;

    public BehaviouralRequirements(double minReactivityScore,
                                     double maxReactivityScore, double maxAggressionScore,
                                     double minTrainabilityScore) {
        this.minReactivityScore = minReactivityScore;
        this.maxReactivityScore = maxReactivityScore;
        this.maxAggressionScore = maxAggressionScore;
        this.minTrainabilityScore = minTrainabilityScore;
    }

    public double getMinReactivityScore() {
        return minReactivityScore;
    }

    public double getMaxReactivityScore() {
        return maxReactivityScore;
    }

    public double getMaxAggressionScore() {
        return maxAggressionScore;
    }

    public double getMinTrainabilityScore() {
        return minTrainabilityScore;
    }
}