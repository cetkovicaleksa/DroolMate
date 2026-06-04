package com.github.cetkovicaleksa.droolmate.model;

/**
 * Fact representing a dog breed with its physical and behavioral characteristics.
 * 
 * @source: FCI (Fédération Cynologique Internationale) Breed Standards - physical and behavioral definitions
 * @source: Hart (1985) - Behavioral profiles - quantitative behavioral factors
 */
public class Breed {
    private String name;
    private String fciGroup;
    private double minHeightCm;
    private double maxHeightCm;
    private double minWeightKg;
    private double maxWeightKg;
    
    // Hart (1985) behavioral factors on scale 0-10
    // Reactivity: tenderness, protectiveness
    private double reactivityScore;
    
    // Aggression: dominance, snapping, biting
    private double aggressionScore;
    
    // Trainability: obedience, willingness to work
    private double trainabilityScore;
    
    private String description;
    private long timestamp;

    public Breed(String name, String fciGroup, double minHeightCm, double maxHeightCm, 
                 double minWeightKg, double maxWeightKg, double reactivityScore, 
                 double aggressionScore, double trainabilityScore, String description) {
        this.name = name;
        this.fciGroup = fciGroup;
        this.minHeightCm = minHeightCm;
        this.maxHeightCm = maxHeightCm;
        this.minWeightKg = minWeightKg;
        this.maxWeightKg = maxWeightKg;
        this.reactivityScore = reactivityScore;
        this.aggressionScore = aggressionScore;
        this.trainabilityScore = trainabilityScore;
        this.description = description;
        this.timestamp = System.currentTimeMillis();
    }

    // Getters
    public String getName() { return name; }
    public String getFciGroup() { return fciGroup; }
    public double getMinHeightCm() { return minHeightCm; }
    public double getMaxHeightCm() { return maxHeightCm; }
    public double getMinWeightKg() { return minWeightKg; }
    public double getMaxWeightKg() { return maxWeightKg; }
    public double getReactivityScore() { return reactivityScore; }
    public double getAggressionScore() { return aggressionScore; }
    public double getTrainabilityScore() { return trainabilityScore; }
    public String getDescription() { return description; }
    public long getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return "Breed{" +
                "name='" + name + '\'' +
                ", reactivity=" + reactivityScore +
                ", aggression=" + aggressionScore +
                ", trainability=" + trainabilityScore +
                '}';
    }
}

