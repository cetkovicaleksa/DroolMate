package com.github.cetkovicaleksa.droolmate.model;

/**
 * Fact representing the final recommendation for a breed-role pairing.
 * Emitted by Layer 3 (compatibility.drl) rules after combining all scores.
 * Holds complete fact references (PhysicalFit, BehavioralFit) for full reasoning.
 *
 * @source: Hart (1985) + ADI Standards - combined assessment framework
 */
public class Recommendation {
    private String breedName;
    private String roleId;
    private String roleName;

    private PhysicalFit physicalFit;
    private BehavioralFit behavioralFit;
    private double combinedScore;  // 0-100, weighted average

    private boolean recommended;   // true if meets minimum thresholds
    private Level level;

    private String reasoning;
    private long timestamp;

    public Recommendation(String breedName, String roleId, String roleName,
                         PhysicalFit physicalFit, BehavioralFit behavioralFit, double combinedScore,
                         boolean recommended, Level level, String reasoning) {
        this.breedName = breedName;
        this.roleId = roleId;
        this.roleName = roleName;
        this.physicalFit = physicalFit;
        this.behavioralFit = behavioralFit;
        this.combinedScore = combinedScore;
        this.recommended = recommended;
        this.level = level;
        this.reasoning = reasoning;
        this.timestamp = System.currentTimeMillis();
    }

    // Getters
    public String getBreedName() { return breedName; }
    public String getRoleId() { return roleId; }
    public String getRoleName() { return roleName; }
    public PhysicalFit getPhysicalFit() { return physicalFit; }
    public BehavioralFit getBehavioralFit() { return behavioralFit; }
    public double getCombinedScore() { return combinedScore; }
    public double getPhysicalScore() { return physicalFit != null ? (physicalFit.isHeightSuitable() && physicalFit.isWeightSuitable() ? 100 : 50) : 0; }
    public double getBehavioralScore() { return behavioralFit != null ? behavioralFit.getTrainabilityFit() : 0; }
    public boolean isRecommended() { return recommended; }
    public Recommendation.Level getLevel() { return level; }
    public String getLevelDisplayName() { return level != null ? level.getDisplayName() : "Unknown"; }
    public String getReasoning() { return reasoning; }
    public long getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return "Recommendation{" +
                "breed='" + breedName + '\'' +
                ", role='" + roleId + '\'' +
                ", combined=" + combinedScore +
                ", level='" + level + '\'' +
                ", recommended=" + recommended +
                '}';
    }

    /**
     * Recommendation level enum for breed-role suitability assessment.
     * @source: ADI Standards - classification framework
     */
    public enum Level {
        EXCELLENT(85, "Excellent"),
        GOOD(75, "Good"),
        FAIR(60, "Fair"),
        NOT_RECOMMENDED(0, "Not Recommended");

        private final int minScore;
        private final String displayName;

        Level(int minScore, String displayName) {
            this.minScore = minScore;
            this.displayName = displayName;
        }

        public int getMinScore() {
            return minScore;
        }

        public String getDisplayName() {
            return displayName;
        }

        /**
         * Determine level from combined score.
         */
        public static Level fromScore(double score) {
            if (score >= EXCELLENT.minScore) return EXCELLENT;
            if (score >= GOOD.minScore) return GOOD;
            if (score >= FAIR.minScore) return FAIR;
            return NOT_RECOMMENDED;
        }
    }

}

