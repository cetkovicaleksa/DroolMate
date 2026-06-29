package com.github.cetkovicaleksa.droolmate.model.canine;

/**
 * Behavioral profile scores for a canine or a canine breed.
 */
public class BehaviourProfile {
    private final double reactivityScore;
    private final double aggressionScore;
    private final double trainabilityScore;

    public BehaviourProfile(double reactivityScore, double aggressionScore, double trainabilityScore) {
        this.reactivityScore = reactivityScore;
        this.aggressionScore = aggressionScore;
        this.trainabilityScore = trainabilityScore;
    }

    public double getReactivityScore() {
        return reactivityScore;
    }

    public double getAggressionScore() {
        return aggressionScore;
    }

    public double getTrainabilityScore() {
        return trainabilityScore;
    }
}