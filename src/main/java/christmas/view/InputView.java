package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.view.constant.InputMessageConstants;

public class InputView {
    public String readDate() {
        System.out.println(InputMessageConstants.DATE_INPUT_MESSAGE.getMessage());
        String input = Console.readLine();
        return input;
    }

    public String readMenu() {
        System.out.println(InputMessageConstants.MENU_INPUT_MESSAGE.getMessage());
        String input = Console.readLine();
        return input;
    }
}
