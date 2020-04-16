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

    public static void greenText(InlineCssTextArea area, String text) {
        area.append(text + "\n", "-fx-fill: green;");
        area.requestFollowCaret();
    }

}
