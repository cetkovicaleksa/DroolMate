package com.github.cetkovicaleksa.droolmate.model;

/**
 * Goal fact used by backward-style reasoning for a breed-role pair (e.x. "Is poodle suitable for guard dog").
 */
public class ComputeBreedGoal {

    public enum Stage {
        PHYSICAL(1 << 0),
        BEHAVIORAL(1 << 1),
        COMPATIBILITY(1 << 2);
    }

    private final Breed breed;
    private final Role role;
    private final Stage stage;

    public ComputeBreedGoal(Breed breed, Role role, Stage stage) {
        this.breed = breed;
        this.role = role;
        this.stage = stage;
    }

    public Breed getBreed() { return breed; }
    public Role getRole() { return role; }
    public Stage getStage() { return stage; }

    public boolean isPhysical() { return stage | Stage.PHYSICAL != 0; }
    public boolean isBehavioral() { return stage | Stage.BEHAVIORAL != 0; }
    public boolean isCompatibility() { return stage | Stage.COMPATIBILITY != 0; }

    @Override
    public String toString() {
        return "ComputeBreedGoal{" + "breed='" + breed.getName() + '\'' + ", role='" + role.getName() + '\'' + ", stage=" + stage + '}';
    }
}



