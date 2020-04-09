package util;

import org.fxmisc.richtext.InlineCssTextArea;

public abstract class TextUtils {

    public static void badEventText(InlineCssTextArea area, String text) {
        area.append(text + "\n", "-fx-font-weight: 900; -fx-fill: red");
        area.requestFollowCaret();
    }

    public static void neutralEventText(InlineCssTextArea area, String text) {
        area.append(text + "\n", "-fx-font-weight: 900; -fx-fill: white;");
        area.requestFollowCaret();
    }

    public static void attackEventText(InlineCssTextArea area, String text) {
        area.append(text + "\n", "-fx-fill: red;");
        area.requestFollowCaret();
    }

}
