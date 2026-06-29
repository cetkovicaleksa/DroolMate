package com.github.cetkovicaleksa.droolmate.model.canine;

/**
 * Fédération Cynologique Internationale (FCI) classification of a canine breed.
 */
public class FciClassification {
    private final String fciGroup;
    private final String fciSection;
    private final String fciSubgroup;

    public FciClassification(String fciGroup, String fciSection, String fciSubgroup) {
        this.fciGroup = fciGroup;
        this.fciSection = fciSection;
        this.fciSubgroup = fciSubgroup;
    }

    public String getFciGroup() {
        return fciGroup;
    }

    public String getFciSection() {
        return fciSection;
    }

    public String getFciSubgroup() {
        return fciSubgroup;
    }
}