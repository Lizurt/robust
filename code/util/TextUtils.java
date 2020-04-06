package util;

import org.fxmisc.richtext.InlineCssTextArea;

public abstract class TextUtils {

    public static void neutralEventText(InlineCssTextArea area, String text) {
        area.append(text + "\n", "-fx-font-weight: 900; -fx-fill: white;");
        area.requestFollowCaret();
    }

}
