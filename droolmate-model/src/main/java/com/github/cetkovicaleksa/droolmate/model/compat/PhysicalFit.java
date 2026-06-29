package com.github.cetkovicaleksa.droolmate.model.compat;

import com.github.cetkovicaleksa.droolmate.model.duty.*;
import com.github.cetkovicaleksa.droolmate.model.canine.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Physical layer summary fact composed from per-criterion evidence.
 */
public class PhysicalFit {
    private final Breed breed;
    private final Role role;
    private final List<CriterionFit> evidence;
    private final double score;
    private final boolean meetsThreshold;
    private final String reasoning;

    public PhysicalFit(Breed breed,
                       Role role,
                       List<CriterionFit> evidence,
                       double score,
                       boolean meetsThreshold,
                       String reasoning) {
        this.breed = breed;
        this.role = role;
        this.evidence = Collections.unmodifiableList(new ArrayList<>(evidence));
        this.score = score;
        this.meetsThreshold = meetsThreshold;
        this.reasoning = reasoning;
    }

    public Breed getBreed() {
        return breed;
    }

    public Role getRole() {
        return role;
    }

    public List<CriterionFit> getEvidence() {
        return evidence;
    }

    public double getScore() {
        return score;
    }

    public boolean isMeetsThreshold() {
        return meetsThreshold;
    }

    public String getReasoning() {
        return reasoning;
    }

    @Override
    public String toString() {
        return "PhysicalFit{" +
                "breed=" + breed.getName() +
                ", role=" + role.getName() +
                ", score=" + score +
                '}';
    }
}
