package christmas.view;

import christmas.model.dto.MenuInfoDto;
import christmas.model.event.constant.EventConstants;
import christmas.view.constant.OutputMessageConstants;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class OutputView {
    public void printStartMessage() {
        System.out.println(OutputMessageConstants.START_MESSAGE.getMessage());
    }

    public void printPreviewEventMessage(int day) {
        System.out.println(String.format(
                OutputMessageConstants.PREVIEW_EVENT_MESSAGE.getMessage(), day
        ));
        printNewLine();
    }

    public void printMenus(List<MenuInfoDto> menuInfoDtos) {
        System.out.println(OutputMessageConstants.ORDER_MENU_MESSAGE.getMessage());
        menuInfoDtos.forEach(OutputView::printMenu);
        printNewLine();
    }

    public void printAmountBeforeDiscount(int totalPrice) {
        System.out.println(OutputMessageConstants.TOTAL_AMOUNT_BEFORE_DISCOUNT_NOTICE_MESSAGE.getMessage());
        System.out.println(String.format(
                OutputMessageConstants.TOTAL_AMOUNT_BEFORE_DISCOUNT_MESSAGE.getMessage(), totalPrice
        ));
        printNewLine();
    }

    public void printGiftItem(boolean giftEventApplied) {
        System.out.println(OutputMessageConstants.GIFT_ITEM_NOTICE_MESSAGE.getMessage());
        if(giftEventApplied) {
            System.out.println(String.format(
                    OutputMessageConstants.GIFT_ITEM_MESSAGE.getMessage(), EventConstants.GIFT_EVENT_ITEM.getSaleTitle(), EventConstants.GIFT_EVENT_ITEM.getSalePrice()
            ));
            printNewLine();
            return;
        }
        System.out.println(OutputMessageConstants.NOTHING_MESSAGE.getMessage());
        printNewLine();
    }

    private static void printMenu(MenuInfoDto menuInfoDto) {
        System.out.println(String.format(
                OutputMessageConstants.MENU_INFO_MESSAGE.getMessage(), menuInfoDto.getName(), menuInfoDto.getCount()
        ));
    }

    private static void printNewLine() {
        System.out.println();
    }
}
