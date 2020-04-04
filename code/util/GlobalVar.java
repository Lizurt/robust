package util;

import javafx.scene.Scene;

public class GlobalVar {
    public static int windowWidth = 960;
    public static int windowHeight = 540;

    GlobalVar() throws Exception {
        throw new Exception("An attempt to create a class of global variables.");
    }

}
