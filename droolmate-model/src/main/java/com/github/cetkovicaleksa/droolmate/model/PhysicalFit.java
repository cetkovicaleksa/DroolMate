package com.github.cetkovicaleksa.droolmate.model;

/**
 * Event fact: Physical layer evaluation result (height + weight combined).
 * @source: FCI Breed Standards - physical characteristic definitions
 */
public class PhysicalFit {
    private String breedName;
    private String roleId;
    private double breedAvgHeight;
    private double roleMinHeight;
    private double roleMaxHeight;
    private boolean heightSuitable;
    private double breedAvgWeight;
    private double roleMinWeight;
    private double roleMaxWeight;
    private boolean weightSuitable;
    private String explanation;
    private long timestamp;

    public PhysicalFit(String breedName, String roleId,
                       double breedAvgHeight, double roleMinHeight, double roleMaxHeight, boolean heightSuitable,
                       double breedAvgWeight, double roleMinWeight, double roleMaxWeight, boolean weightSuitable,
                       String explanation) {
        this.breedName = breedName;
        this.roleId = roleId;
        this.breedAvgHeight = breedAvgHeight;
        this.roleMinHeight = roleMinHeight;
        this.roleMaxHeight = roleMaxHeight;
        this.heightSuitable = heightSuitable;
        this.breedAvgWeight = breedAvgWeight;
        this.roleMinWeight = roleMinWeight;
        this.roleMaxWeight = roleMaxWeight;
        this.weightSuitable = weightSuitable;
        this.explanation = explanation;
        this.timestamp = System.currentTimeMillis();
    }

    public String getBreedName() { return breedName; }
    public String getRoleId() { return roleId; }
    public double getBreedAvgHeight() { return breedAvgHeight; }
    public double getRoleMinHeight() { return roleMinHeight; }
    public double getRoleMaxHeight() { return roleMaxHeight; }
    public boolean isHeightSuitable() { return heightSuitable; }
    public double getBreedAvgWeight() { return breedAvgWeight; }
    public double getRoleMinWeight() { return roleMinWeight; }
    public double getRoleMaxWeight() { return roleMaxWeight; }
    public boolean isWeightSuitable() { return weightSuitable; }
    public String getExplanation() { return explanation; }
    public long getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return "PhysicalFit{breed='" + breedName + "', role='" + roleId + "', height=" + heightSuitable + ", weight=" + weightSuitable + "}";
    }
}
