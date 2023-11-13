package christmas.controller;

import christmas.model.day.Day;
import christmas.view.InputView;

public class PlannerController {
    private final InputView inputView;

    public PlannerController() {
        inputView = new InputView();
    }

    public void planning() {
        Day day = new Day(getDate());
    }

    private String getDate() {
        return inputView.readDate();
    }
}
