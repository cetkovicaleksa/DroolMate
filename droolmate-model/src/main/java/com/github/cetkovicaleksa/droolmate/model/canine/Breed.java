package com.github.cetkovicaleksa.droolmate.model.canine;

/**
 * Fact representing a canine breed.
 *
 * The detailed breed facts are split into separate aggregates so rules can reason
 * over physical, behavioral, and classification data independently.
 */
public class Breed {
    private final String name;
    private final String description;
    private PhysicalTraits physicalTraits;
    private BehaviourProfile behaviouralProfile;
    private FciClassification clazz;

    public Breed(String name, String description,
                 PhysicalTraits physicalTraits,
                 BehaviourProfile behaviouralProfile,
                 FciClassification clazz) {
        this.name = name;
        this.description = description;
        this.physicalTraits = physicalTraits;
        this.behaviouralProfile = behaviouralProfile;
        this.clazz = clazz;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public PhysicalTraits getPhysicalTraits() {
        return physicalTraits;
    }

    public BehaviourProfile getBehaviouralProfile() {
        return behaviouralProfile;
    }

    public FciClassification getClazz() {
        return clazz;
    }

    public void setPhysicalTraits(PhysicalTraits physicalTraits) {
        this.physicalTraits = physicalTraits;
    }

    public void setBehaviouralProfile(BehaviourProfile behaviouralProfile) {
        this.behaviouralProfile = behaviouralProfile;
    }

    public void setClazz(FciClassification clazz) {
        this.clazz = clazz;
    }

    public String getFciGroup() {
        return clazz != null ? clazz.getFciGroup() : null;
    }

    @Override
    public String toString() {
        return "Breed{" +
                "name='" + name + '\'' +
                '}';
    }
}

