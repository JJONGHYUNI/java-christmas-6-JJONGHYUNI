package christmas.controller;

import christmas.model.day.Day;
import christmas.model.order.Order;
import christmas.service.EventService;
import christmas.view.InputView;

public class PlannerController {
    private final InputView inputView;
    private final EventService eventService;

    public PlannerController() {
        inputView = new InputView();
        eventService = new EventService();
    }

    public void planning() {
        Day day = new Day(getDate());
        Order order = new Order(getOrder(), eventService.createEvent(day));
    }

    private String getDate() {
        return inputView.readDate();
    }

    private String getOrder() {
        return inputView.readMenu();
    }
}
