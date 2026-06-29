package com.github.cetkovicaleksa.droolmate.model.compat;

import com.github.cetkovicaleksa.droolmate.model.duty.*;
import com.github.cetkovicaleksa.droolmate.model.canine.*;

/**
 * Final recommendation fact for a breed-role pairing.
 */
public class Recommendation {
    private final Breed breed;
    private final Role role;
    private final PhysicalFit physicalFit;
    private final BehaviouralFit behaviouralFit;
    private final double score;
    private final boolean recommended;
    private final Level level;
    private final String reasoning;

    public Recommendation(Breed breed,
                          Role role,
                          PhysicalFit physicalFit,
                          BehaviouralFit behaviouralFit,
                          double score,
                          boolean recommended,
                          Level level,
                          String reasoning) {
        this.breed = breed;
        this.role = role;
        this.physicalFit = physicalFit;
        this.behaviouralFit = behaviouralFit;
        this.score = score;
        this.recommended = recommended;
        this.level = level;
        this.reasoning = reasoning;
    }

    public Breed getBreed() {
        return breed;
    }

    public Role getRole() {
        return role;
    }

    public PhysicalFit getPhysicalFit() {
        return physicalFit;
    }

    public BehaviouralFit getBehaviouralFit() {
        return behaviouralFit;
    }

    public double getScore() {
        return score;
    }

    public double getPhysicalScore() {
        return physicalFit != null ? physicalFit.getScore() : 0;
    }

    public double getBehaviouralScore() {
        return behaviouralFit != null ? behaviouralFit.getScore() : 0;
    }

    public boolean isRecommended() {
        return recommended;
    }

    public Level getLevel() {
        return level;
    }

    public String getLevelDisplayName() {
        return level != null ? level.getDisplayName() : "Unknown";
    }

    public String getReasoning() {
        return reasoning;
    }

    @Override
    public String toString() {
        return "Recommendation{" +
                "breed=" + breed.getName() +
                ", role=" + role.getName() +
                ", combined=" + score +
                ", level=" + level +
                '}';
    }

    /**
     * Recommendation level enum for breed-role suitability assessment.
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

        public static Level fromScore(double score) {
            if (score >= EXCELLENT.minScore) {
                return EXCELLENT;
            }
            if (score >= GOOD.minScore) {
                return GOOD;
            }
            if (score >= FAIR.minScore) {
                return FAIR;
            }
            return NOT_RECOMMENDED;
        }
    }
}

