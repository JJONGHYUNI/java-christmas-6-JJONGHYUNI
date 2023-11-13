package christmas.controller;

import christmas.model.day.Day;
import christmas.model.order.Order;
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

    private String getOrder() {
        return inputView.readMenu();
    }
}
