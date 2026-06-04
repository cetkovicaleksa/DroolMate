package com.github.cetkovicaleksa.droolmate.model;

/**
 * Fact representing role-specific requirements for a dog.
 * Used to define what characteristics are needed for a particular working or assistance role.
 *
 * @source: ADI (Assistance Dogs International) Standards and Ethics - role-specific criteria
 * @source: Handbook on Animal-Assisted Therapy - selection and behavioral test requirements
 */
public class RoleRequirement {
    private String roleId;
    private String roleName;

    // Optional hierarchical parent role (for recursive/backward reasoning)
    private String parentRoleId;

    // Physical requirements
    private double minHeightCm;
    private double maxHeightCm;
    private double minWeightKg;
    private double maxWeightKg;

    // Behavioral requirements (Hart's factors)
    private double minReactivityScore;   // Lower = less reactive, better for therapy
    private double maxReactivityScore;
    private double maxAggressionScore;   // Must be low/zero for any service role
    private double minTrainabilityScore; // Must be high for trainable dogs

    private String description;
    private long timestamp;

    public RoleRequirement(String roleId, String roleName,
                          double minHeightCm, double maxHeightCm,
                          double minWeightKg, double maxWeightKg,
                          double minReactivityScore, double maxReactivityScore,
                          double maxAggressionScore, double minTrainabilityScore,
                          String description) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.minHeightCm = minHeightCm;
        this.maxHeightCm = maxHeightCm;
        this.minWeightKg = minWeightKg;
        this.maxWeightKg = maxWeightKg;
        this.minReactivityScore = minReactivityScore;
        this.maxReactivityScore = maxReactivityScore;
        this.maxAggressionScore = maxAggressionScore;
        this.minTrainabilityScore = minTrainabilityScore;
        this.description = description;
        this.timestamp = System.currentTimeMillis();
    }

    // Alternative constructor allowing parent role
    public RoleRequirement(String roleId, String roleName,
                          double minHeightCm, double maxHeightCm,
                          double minWeightKg, double maxWeightKg,
                          double minReactivityScore, double maxReactivityScore,
                          double maxAggressionScore, double minTrainabilityScore,
                          String description, String parentRoleId) {
        this(roleId, roleName, minHeightCm, maxHeightCm, minWeightKg, maxWeightKg,
             minReactivityScore, maxReactivityScore, maxAggressionScore, minTrainabilityScore, description);
        this.parentRoleId = parentRoleId;
    }

    // Getters
    public String getRoleId() { return roleId; }
    public String getRoleName() { return roleName; }
    public double getMinHeightCm() { return minHeightCm; }
    public double getMaxHeightCm() { return maxHeightCm; }
    public double getMinWeightKg() { return minWeightKg; }
    public double getMaxWeightKg() { return maxWeightKg; }
    public double getMinReactivityScore() { return minReactivityScore; }
    public double getMaxReactivityScore() { return maxReactivityScore; }
    public double getMaxAggressionScore() { return maxAggressionScore; }
    public double getMinTrainabilityScore() { return minTrainabilityScore; }
    public String getDescription() { return description; }
    public long getTimestamp() { return timestamp; }
    public String getParentRoleId() { return parentRoleId; }

    @Override
    public String toString() {
        return "RoleRequirement{" +
                "roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
