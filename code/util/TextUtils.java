package util;

import org.fxmisc.richtext.InlineCssTextArea;

public class TextUtils {

    public static void neutralEventText(InlineCssTextArea area, String text) {
        area.append(text + "\n", "-fx-font-weight: bold; -fx-fill: white;");
    }

}
