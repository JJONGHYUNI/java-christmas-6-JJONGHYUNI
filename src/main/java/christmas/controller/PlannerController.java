package christmas.controller;

import christmas.model.day.Day;
import christmas.model.dto.MenuInfoDto;
import christmas.model.order.Order;
import christmas.model.reward.Reward;
import christmas.model.reward.Rewards;
import christmas.service.EventService;
import christmas.service.OrderService;
import christmas.service.RewardsService;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class PlannerController {
    private final InputView inputView;
    private final OutputView outputView;
    private final EventService eventService;
    private final OrderService orderService;
    private final RewardsService rewardsService;

    public PlannerController() {
        inputView = new InputView();
        outputView = new OutputView();
        eventService = new EventService();
        orderService = new OrderService();
        rewardsService = new RewardsService();
    }

    public void planning() {
        outputView.printStartMessage();
        Day day = new Day(getDate());
        Order order = new Order(getOrder(), eventService.createEvent(day));

        printPreviewRewardsMessage(day);
        printOrderMenus(order);
        printTotalPriceBeforeDiscount(order.findTotalPrice());
        printGiftItem(order);
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

    private void printGiftItem(Order order) {
        outputView.printGiftItem(order.isGiftEventApply());
    }
}
