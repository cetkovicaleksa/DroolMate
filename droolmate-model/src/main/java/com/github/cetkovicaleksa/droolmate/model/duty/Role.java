package com.github.cetkovicaleksa.droolmate.model.duty;

/**
 * Fact representing a canine duty role (e.g., "Search and Rescue", "Therapy Dog").
 */
public class Role {
    private final String name;
    private final String description;
    private PhysicalRequirements physicalRequirements;
    private BehaviouralRequirements behavioralRequirements;

    public Role(String name, String description, PhysicalRequirements physicalRequirements, BehaviouralRequirements behavioralRequirements) {
        this.name = name;
        this.description = description;
        this.physicalRequirements = physicalRequirements;
        this.behavioralRequirements = behavioralRequirements;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public PhysicalRequirements getPhysicalRequirements() {
        return physicalRequirements;
    }

    public void setPhysicalRequirements(PhysicalRequirements physicalRequirements) {
        this.physicalRequirements = physicalRequirements;
    }

    public BehaviouralRequirements getBehavioralRequirements() {
        return behavioralRequirements;
    }

    public void setBehavioralRequirements(BehaviouralRequirements behavioralRequirements) {
        this.behavioralRequirements = behavioralRequirements;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", physicalRequirements=" + physicalRequirements +
                ", behavioralRequirements=" + behavioralRequirements +
                '}';
    }
}