import javafx.scene.Scene;

public class GlobalVar {
    public static int windowWidth = 960;
    public static int windowHeight = 540;
    public static Scene adventureScene = null;
    public static Scene mainMenuScene = null;
    public static Scene pauseMenuScene = null;

    GlobalVar() throws Exception {
        throw new Exception("An attempt to create a class of global variables.");
    }

}
