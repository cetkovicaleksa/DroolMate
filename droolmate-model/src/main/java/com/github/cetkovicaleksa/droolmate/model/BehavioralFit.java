package com.github.cetkovicaleksa.droolmate.model;

/**
 * Event fact: Behavioral layer evaluation result (all Hart factors combined).
 * @source: Hart (1985) - Behavioral profiles - quantitative behavioral assessment
 * @source: ADI Standards - behavioral requirements for assistance/working dogs
 */
public class BehavioralFit {
    private String breedName;
    private String roleId;
    
    // Breed's raw Hart factors (0-10 scale)
    private double breedReactivity;
    private double breedAggression;
    private double breedTrainability;
    
    // Role requirements
    private double roleMinReactivity;
    private double roleMaxReactivity;
    private double roleMaxAggression;
    private double roleMinTrainability;
    
    // Fit scores (0-100) for each factor
    private double reactivityFit;
    private double aggressionFit;
    private double trainabilityFit;
    
    private String explanation;
    private long timestamp;

    public BehavioralFit(String breedName, String roleId,
                         double breedReactivity, double breedAggression, double breedTrainability,
                         double roleMinReactivity, double roleMaxReactivity, double roleMaxAggression, double roleMinTrainability,
                         double reactivityFit, double aggressionFit, double trainabilityFit,
                         String explanation) {
        this.breedName = breedName;
        this.roleId = roleId;
        this.breedReactivity = breedReactivity;
        this.breedAggression = breedAggression;
        this.breedTrainability = breedTrainability;
        this.roleMinReactivity = roleMinReactivity;
        this.roleMaxReactivity = roleMaxReactivity;
        this.roleMaxAggression = roleMaxAggression;
        this.roleMinTrainability = roleMinTrainability;
        this.reactivityFit = reactivityFit;
        this.aggressionFit = aggressionFit;
        this.trainabilityFit = trainabilityFit;
        this.explanation = explanation;
        this.timestamp = System.currentTimeMillis();
    }

    public String getBreedName() { return breedName; }
    public String getRoleId() { return roleId; }
    public double getBreedReactivity() { return breedReactivity; }
    public double getBreedAggression() { return breedAggression; }
    public double getBreedTrainability() { return breedTrainability; }
    public double getRoleMinReactivity() { return roleMinReactivity; }
    public double getRoleMaxReactivity() { return roleMaxReactivity; }
    public double getRoleMaxAggression() { return roleMaxAggression; }
    public double getRoleMinTrainability() { return roleMinTrainability; }
    public double getReactivityFit() { return reactivityFit; }
    public double getAggressionFit() { return aggressionFit; }
    public double getTrainabilityFit() { return trainabilityFit; }
    public String getExplanation() { return explanation; }
    public long getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return "BehavioralFit{breed='" + breedName + "', role='" + roleId + 
               "', reactivity=" + reactivityFit + ", aggression=" + aggressionFit + 
               ", trainability=" + trainabilityFit + "}";
    }
}
