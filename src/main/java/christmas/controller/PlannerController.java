package christmas.controller;

import christmas.model.day.Day;
import christmas.model.dto.MenuInfoDto;
import christmas.model.order.Order;
import christmas.service.EventService;
import christmas.service.OrderService;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class PlannerController {
    private final InputView inputView;
    private final OutputView outputView;
    private final EventService eventService;
    private final OrderService orderService;

    public PlannerController() {
        inputView = new InputView();
        outputView = new OutputView();
        eventService = new EventService();
        orderService = new OrderService();
    }

    public void planning() {
        outputView.printStartMessage();
        Day day = new Day(getDate());
        Order order = new Order(getOrder(), eventService.createEvent(day));

        printPreviewRewardsMessage(day);
        printOrderMenus(order);
        printTotalPriceBeforeDiscount(order.findTotalPrice());
    }

    private String getDate() {
        return inputView.readDate();
    }

    private String getOrder() {
        return inputView.readMenu();
    }

    private void printPreviewRewardsMessage(Day day) {
        outputView.printPreviewEventMessage(day.getDay());
    }

    private void printTotalPriceBeforeDiscount(int totalPrice) {
        outputView.printAmountBeforeDiscount(totalPrice);
    }

    private void printOrderMenus(Order order) {
        List<MenuInfoDto> menuInfoDtos = orderService.getOrderMenuInfos(order);
        outputView.printMenus(menuInfoDtos);
    }
}
