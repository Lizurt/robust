package util;

import org.fxmisc.richtext.InlineCssTextArea;

public abstract class TextUtils {

    public static void redBoldText(InlineCssTextArea area, String text) {
        area.append(text + "\n", "-fx-font-weight: 900; -fx-fill: red");
        area.requestFollowCaret();
    }

    public static void redText(InlineCssTextArea area, String text) {
        area.append(text + "\n", "-fx-fill: red;");
        area.requestFollowCaret();
    }

    public static void whiteBoldText(InlineCssTextArea area, String text) {
        area.append(text + "\n", "-fx-font-weight: 900; -fx-fill: white;");
        area.requestFollowCaret();
    }

    public static void whiteText(InlineCssTextArea area, String text) {
        area.append(text + "\n", "-fx-fill: white;");
        area.requestFollowCaret();
    }

    public static void greenText(InlineCssTextArea area, String text) {
        area.append(text + "\n", "-fx-fill: green;");
        area.requestFollowCaret();
    }

    public static void greenBoldText(InlineCssTextArea area, String text) {
        area.append(text + "\n", "-fx-font-weight: 900; -fx-fill: green;");
        area.requestFollowCaret();
    }

    public static void blueText(InlineCssTextArea area, String text) {
        area.append(text + "\n", "-fx-fill: blue;");
        area.requestFollowCaret();
    }

    public static void blueBoldText(InlineCssTextArea area, String text) {
        area.append(text + "\n", "-fx-font-weight: 900; -fx-fill: blue;");
        area.requestFollowCaret();
    }

}
