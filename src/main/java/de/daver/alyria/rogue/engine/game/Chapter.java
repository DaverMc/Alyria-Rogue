package de.daver.alyria.rogue.engine.game;

import java.util.ArrayList;
import java.util.List;

public class Chapter {

    private final List<Stage> stages;

    private int currentStage;

    public Chapter() {
        stages = new ArrayList<Stage>();
    }

    public void addStage(Stage stage) {
        stages.add(stage);
    }

    public Stage getCurrentStage() {
        return stages.get(currentStage);
    }

    public boolean nextStage() {
        if (currentStage + 1 >= stages.size()) return false;
        currentStage++;
        return true;
    }
}
