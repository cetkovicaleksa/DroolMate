package com.github.cetkovicaleksa.droolmate.model;

/**
 * Fact representing the result of physical trait evaluation.
 * Emitted by Layer 1 (physical.drl) rules after assessing breed suitability.
 * 
 * @source: FCI Breed Standards - physical characteristic definitions
 */
public class PhysicalScore {
    private String breedName;
    private String roleId;
    
    private boolean heightSuitable;
    private boolean weightSuitable;
    private double physicalScore; // 0-100
    
    private String reasoning;
    private long timestamp;

    public PhysicalScore(String breedName, String roleId, boolean heightSuitable, 
                        boolean weightSuitable, double physicalScore, String reasoning) {
        this.breedName = breedName;
        this.roleId = roleId;
        this.heightSuitable = heightSuitable;
        this.weightSuitable = weightSuitable;
        this.physicalScore = physicalScore;
        this.reasoning = reasoning;
        this.timestamp = System.currentTimeMillis();
    }

    // Getters
    public String getBreedName() { return breedName; }
    public String getRoleId() { return roleId; }
    public boolean isHeightSuitable() { return heightSuitable; }
    public boolean isWeightSuitable() { return weightSuitable; }
    public double getPhysicalScore() { return physicalScore; }
    public String getReasoning() { return reasoning; }
    public long getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return "PhysicalScore{" +
                "breed='" + breedName + '\'' +
                ", role='" + roleId + '\'' +
                ", score=" + physicalScore +
                ", suitable=" + (heightSuitable && weightSuitable) +
                '}';
    }
}

