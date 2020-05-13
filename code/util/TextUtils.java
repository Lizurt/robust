package util;

import org.fxmisc.richtext.InlineCssTextArea;

public abstract class TextUtils {

    ////////////////////////////////
    //       FIXED TEXT AREA      //
    ////////////////////////////////

    public static void redBoldText(String text) {
        redBoldText(GlobalVar.adventureScene.getTextAreaOutput(), text);
    }

    public static void redText(String text) {
        redText(GlobalVar.adventureScene.getTextAreaOutput(), text);
    }

    public static void whiteBoldText(String text) {
        whiteBoldText(GlobalVar.adventureScene.getTextAreaOutput(), text);
    }

    public static void whiteText(String text) {
        whiteText(GlobalVar.adventureScene.getTextAreaOutput(), text);
    }

    public static void greenText(String text) {
        greenText(GlobalVar.adventureScene.getTextAreaOutput(), text);
    }

    public static void greenBoldText(String text) {
        greenBoldText(GlobalVar.adventureScene.getTextAreaOutput(), text);
    }

    public static void blueText(String text) {
        blueText(GlobalVar.adventureScene.getTextAreaOutput(), text);
    }

    public static void blueBoldText(String text) {
        blueBoldText(GlobalVar.adventureScene.getTextAreaOutput(), text);
    }

    ////////////////////////////////
    //     UNIVERSAL TEXT AREA    //
    ////////////////////////////////

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
        area.append(text + "\n", "-fx-fill: cyan;");
        area.requestFollowCaret();
    }

    public static void blueBoldText(InlineCssTextArea area, String text) {
        area.append(text + "\n", "-fx-font-weight: 900; -fx-fill: cyan;");
        area.requestFollowCaret();
    }
}
