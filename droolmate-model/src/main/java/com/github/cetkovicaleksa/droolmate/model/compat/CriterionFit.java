package com.github.cetkovicaleksa.droolmate.model.compat;

import com.github.cetkovicaleksa.droolmate.model.duty.*;
import com.github.cetkovicaleksa.droolmate.model.canine.*;

/**
 * Shared intermediate evidence fact for a single criterion (e.g., "Size", "Trainability").
 */
public class CriterionFit {
    private final Breed breed;
    private final Role role;
    private final String criterion;
    private final double score;
    private final boolean suitable;
    private final String reasoning;

    public CriterionFit(Breed breed, Role role, String criterion, double score, boolean suitable, String reasoning) {
        this.breed = breed;
        this.role = role;
        this.criterion = criterion;
        this.score = score;
        this.suitable = suitable;
        this.reasoning = reasoning;
    }

    public Breed getBreed() { return breed; }
    public Role getRole() { return role; }
    public String getCriterion() { return criterion; }
    public double getScore() { return score; }
    public boolean isSuitable() { return suitable; }
    public String getReasoning() { return reasoning; }

    @Override
    public String toString() {
        return "CriterionFit{" +
                "breed=" + breed.getName() +
                ", role=" + role.getName() +
                ", criterion='" + criterion + '\'' +
                ", score=" + score +
                ", suitable=" + suitable +
                '}';
    }
}