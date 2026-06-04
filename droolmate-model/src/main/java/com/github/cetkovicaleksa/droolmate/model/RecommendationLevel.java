package com.github.cetkovicaleksa.droolmate.model;

/**
 * Recommendation level enum for breed-role suitability assessment.
 * @source: ADI Standards - classification framework
 */
public enum RecommendationLevel {
    EXCELLENT(85, "Excellent"),
    GOOD(75, "Good"),
    FAIR(60, "Fair"),
    NOT_RECOMMENDED(0, "Not Recommended");

    private final int minScore;
    private final String displayName;

    RecommendationLevel(int minScore, String displayName) {
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
    public static RecommendationLevel fromScore(double score) {
        if (score >= EXCELLENT.minScore) return EXCELLENT;
        if (score >= GOOD.minScore) return GOOD;
        if (score >= FAIR.minScore) return FAIR;
        return NOT_RECOMMENDED;
    }
}
