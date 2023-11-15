package christmas.controller;

import christmas.model.date.Date;
import christmas.model.dto.MenuInfoDto;
import christmas.model.dto.RewardInfoDto;
import christmas.model.event.Event;
import christmas.model.order.Order;
import christmas.model.reward.Rewards;
import christmas.service.EventService;
import christmas.service.OrderService;
import christmas.service.RewardsService;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class PlannerController {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private final EventService eventService;
    private final OrderService orderService;
    private final RewardsService rewardsService;

    public PlannerController() {
        eventService = new EventService();
        orderService = new OrderService();
        rewardsService = new RewardsService();
    }

    public void planning() {
        outputView.printStartMessage();
        Date date = getDate();
        Event event = eventService.createEvent(date);
        Order order = getOrder(event);
        Rewards rewards = rewardsService.createRewards(date.receiveDdayReward(), order.findReward(), order.findGiftReward(), order.isEventApply());

        printPreviewRewardsMessage(date);
        printOrderMenus(order);
        printTotalPriceBeforeDiscount(order);
        printGiftItem(order);
        printRewards(rewards);
        printTotalBenefit(rewards);
        printTotalPriceAfterDiscount(order, rewards);
        printBadge(rewards);
    }

    private Date getDate() {
        while (true) {
            try {
                return new Date(inputView.readDate());
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Order getOrder(Event event) {
        while (true) {
            try {
                return new Order(inputView.readMenu(), event);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void printPreviewRewardsMessage(Date date) {
        outputView.printPreviewEventMessage(date.getDay());
    }

    private void printTotalPriceBeforeDiscount(Order order) {
        outputView.printAmountBeforeDiscount(order.findTotalPrice());
    }

    private void printOrderMenus(Order order) {
        List<MenuInfoDto> menuInfoDtos = orderService.getOrderMenuInfos(order);
        outputView.printMenus(menuInfoDtos);
    }

    private void printGiftItem(Order order) {
        outputView.printGiftItem(order.isGiftEventApply());
    }

    private void printRewards(Rewards rewards) {
        List<RewardInfoDto> rewardInfoDtos = rewardsService.getRewards(rewards);
        outputView.printRewards(rewardInfoDtos);
    }

    private void printTotalBenefit(Rewards rewards) {
        outputView.printTotalBenefit(rewards.getBenfit());
    }

    private void printTotalPriceAfterDiscount(Order order, Rewards rewards) {
        outputView.printPriceAfterDiscount(order.findTotalPrice() + rewards.calculateDiscountPrice());
    }

    private void printBadge(Rewards rewards) {
        outputView.printBadge(rewards.findBadgeForBenefit());
    }
}
