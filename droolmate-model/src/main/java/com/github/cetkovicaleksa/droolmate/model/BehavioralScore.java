package com.github.cetkovicaleksa.droolmate.model;

/**
 * Fact representing the result of behavioral trait evaluation.
 * Emitted by Layer 2 (behavioral.drl) rules after assessing behavioral compatibility.
 * 
 * @source: Hart (1985) - Behavioral profiles of dog breeds using cluster analysis
 * Factors: Reactivity (tenderness/protectiveness), Aggression (dominance), Trainability (obedience)
 */
public class BehavioralScore {
    private String breedName;
    private String roleId;
    
    private double reactivityScore;    // 0-10, breed's inherent reactivity
    private double aggressionScore;    // 0-10, breed's inherent aggression
    private double trainabilityScore;  // 0-10, breed's inherent trainability
    
    private double roleReactivityFit;  // 0-100, how well breed's reactivity matches role needs
    private double roleAggressionFit;  // 0-100, how well breed's aggression matches role needs
    private double roleTrainabilityFit; // 0-100, how well breed's trainability matches role needs
    
    private double behavioralScore;    // 0-100, combined behavioral fit
    private String reasoning;
    private long timestamp;

    public BehavioralScore(String breedName, String roleId, 
                          double reactivityScore, double aggressionScore, double trainabilityScore,
                          double roleReactivityFit, double roleAggressionFit, double roleTrainabilityFit,
                          double behavioralScore, String reasoning) {
        this.breedName = breedName;
        this.roleId = roleId;
        this.reactivityScore = reactivityScore;
        this.aggressionScore = aggressionScore;
        this.trainabilityScore = trainabilityScore;
        this.roleReactivityFit = roleReactivityFit;
        this.roleAggressionFit = roleAggressionFit;
        this.roleTrainabilityFit = roleTrainabilityFit;
        this.behavioralScore = behavioralScore;
        this.reasoning = reasoning;
        this.timestamp = System.currentTimeMillis();
    }

    // Getters
    public String getBreedName() { return breedName; }
    public String getRoleId() { return roleId; }
    public double getReactivityScore() { return reactivityScore; }
    public double getAggressionScore() { return aggressionScore; }
    public double getTrainabilityScore() { return trainabilityScore; }
    public double getRoleReactivityFit() { return roleReactivityFit; }
    public double getRoleAggressionFit() { return roleAggressionFit; }
    public double getRoleTrainabilityFit() { return roleTrainabilityFit; }
    public double getBehavioralScore() { return behavioralScore; }
    public String getReasoning() { return reasoning; }
    public long getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return "BehavioralScore{" +
                "breed='" + breedName + '\'' +
                ", role='" + roleId + '\'' +
                ", behavioral=" + behavioralScore +
                ", reactivity=" + reactivityScore +
                ", aggression=" + aggressionScore +
                ", trainability=" + trainabilityScore +
                '}';
    }
}

