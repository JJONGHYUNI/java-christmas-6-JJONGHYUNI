package christmas.view;

import christmas.view.constant.OutputMessageConstants;

public class OutputView {
    public void printStartMessage() {
        System.out.println(OutputMessageConstants.START_MESSAGE.getMessage());
    }

    public void printPreviewEventMessage() {
        System.out.println(OutputMessageConstants.PREVIEW_EVENT_MESSAGE.getMessage());
    }
}
