package com.github.cetkovicaleksa.droolmate.model;

/**
 * Event fact: Compatibility layer aggregation (physical + behavioral combined).
 * Holds references to complete PhysicalFit and BehavioralFit facts for full reasoning.
 * @source: ADI Standards - minimum thresholds for recommendation
 */
public class CompatibilityScore {
    private String breedName;
    private String roleId;
    
    private PhysicalFit physicalFit;
    private BehavioralFit behavioralFit;
    private double combinedScore;  // 30% physical + 70% behavioral
    
    private boolean physicalOk;    // physical >= 50
    private boolean behavioralOk;  // behavioral >= 75
    private boolean combinedOk;    // combined >= 75
    
    private Recommendation.Level level;
    private String explanation;
    private long timestamp;

    public CompatibilityScore(String breedName, String roleId,
                             PhysicalFit physicalFit, BehavioralFit behavioralFit, double combinedScore,
                             boolean physicalOk, boolean behavioralOk, boolean combinedOk,
                             Recommendation.Level level, String explanation) {
        this.breedName = breedName;
        this.roleId = roleId;
        this.physicalFit = physicalFit;
        this.behavioralFit = behavioralFit;
        this.combinedScore = combinedScore;
        this.physicalOk = physicalOk;
        this.behavioralOk = behavioralOk;
        this.combinedOk = combinedOk;
        this.level = level;
        this.explanation = explanation;
        this.timestamp = System.currentTimeMillis();
    }

    public String getBreedName() { return breedName; }
    public String getRoleId() { return roleId; }
    public PhysicalFit getPhysicalFit() { return physicalFit; }
    public BehavioralFit getBehavioralFit() { return behavioralFit; }
    public double getCombinedScore() { return combinedScore; }
    public boolean isPhysicalOk() { return physicalOk; }
    public boolean isBehavioralOk() { return behavioralOk; }
    public boolean isCombinedOk() { return combinedOk; }
    public Recommendation.Level getLevel() { return level; }
    public String getExplanation() { return explanation; }
    public long getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return "CompatibilityScore{breed='" + breedName + "', role='" + roleId + 
               "', combined=" + combinedScore + ", level='" + level + "'}";
    }
}
