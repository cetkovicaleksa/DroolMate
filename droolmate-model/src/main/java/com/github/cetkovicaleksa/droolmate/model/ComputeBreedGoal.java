package com.github.cetkovicaleksa.droolmate.model;

/**
 * Goal fact used by backward-style reasoning: compute assessment for a single breed-role pair.
 * Stage indicates which subgoal is requested, enabling recursive/subgoal chaining.
 */
public class ComputeBreedGoal {
    private String breedName;
    private String roleId;
    private GoalStage stage;
    private long timestamp;

    public ComputeBreedGoal(String breedName, String roleId, GoalStage stage) {
        this.breedName = breedName;
        this.roleId = roleId;
        this.stage = stage;
        this.timestamp = System.currentTimeMillis();
    }

    public String getBreedName() { return breedName; }
    public String getRoleId() { return roleId; }
    public GoalStage getStage() { return stage; }
    public long getTimestamp() { return timestamp; }

    // Convenience boolean accessors to ease pattern matching in DRL (avoids static enum access issues)
    public boolean isPhysical() { return stage == GoalStage.PHYSICAL; }
    public boolean isBehavioral() { return stage == GoalStage.BEHAVIORAL; }
    public boolean isCompatibility() { return stage == GoalStage.COMPATIBILITY; }

    @Override
    public String toString() {
        return "ComputeBreedGoal{" + "breed='" + breedName + '\'' + ", role='" + roleId + '\'' + ", stage=" + stage + '}';
    }
}



