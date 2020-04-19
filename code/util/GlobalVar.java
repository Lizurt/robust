package util;

import game_scene.AdventureScene;
import game_scene.MainMenuScene;
import game_scene.PauseMenuScene;
import javafx.stage.Stage;

public abstract class GlobalVar {
    public static Difficulty difficulty = Difficulty.MEDIUM;
    public static int windowWidth = 960;
    public static int windowHeight = 560;
    public static Stage mainStage;
    public static AdventureScene adventureScene;
    public static MainMenuScene mainMenuScene;
    public static PauseMenuScene pauseMenuScene;
    public final static int minAge =  20;
    public final static int maxAge = 80;
    public final static String[] allowedFemaleHumanRealName = new String[]{
            "Dorsey Dorothy",
            "Simon Olivia",
            "Mathews Francine",
            "Marsh Anissa",
            "Rich Donna",
            "McDowell Abigail",
            "Greene Kellie",
            "Newman Magdalen",
            "Armbruster Silvia",
            "Rosenberg Manuela",
            "Becke Franka",
            "Maier Christa",
            "Knopp Christin",
            "Winter Karola",
            "Albert Alexandra",
            "Fuhrmann Ulrike",
            "Lajoie Marie-Jeanne",
            "Champagne Michelle",
            "Labrie Anne",
            "Bonnet Eliane",
            "Simoneau Marie-Laure",
            "Mercier Lucienne",
            "Turgeon Paulette",
            "Perrot Ariane",
            "Donati Carlotta",
            "Colucci Laura",
            "Novelli Laura",
            "Capelli Antonia",
            "Villani Simona",
            "Cara Lidia",
            "Palmisano Veronica",
            "Pesce Donata"
    };
    public final static String[] allowedMaleHumanRealName = new String[]{
            "Wells Steven",
            "Allison Clinton",
            "Wheeler Allen",
            "Thompson Bartholomew",
            "Ellis Hilary",
            "Summers Daniel",
            "Jackson Paul",
            "Clarke Reginald",
            "Heintze Andreas",
            "Bachmeier Hans",
            "Baumhauer Kornelius",
            "Kuntz Leander",
            "Auttenberg Adolf",
            "Michel Hinrich",
            "Kerner Max",
            "Straub Lukas",
            "Dumouchel Patrick",
            "Croteau Cyprien",
            "Turgeon Antoine",
            "Thomas Vincent",
            "Leroy Emmanuel",
            "Bouffard Armand",
            "Paris Martial",
            "Fortin Maxime",
            "Lolli Ippolito",
            "Bianchi Ottaviano",
            "Lentini Baldo",
            "Belloni Oliviero",
            "Paolini Emanuele",
            "Villa Stefano",
            "Randazzo Giacomo",
            "Murgia Amerigo"
    };
    public final static String[] allowedBasicFemaleNameAdjectives = new String[]{
            "",
            "",
            "",
            "Подозрительная ",
            "Стройная ",
            "Странная ",
            "Незнакомая ",
            "Некрасивая ",
            "Какая-то ",
            "Красивая ",
            "Обычная ",
            "Типичная "
    };
    public final static String[] allowedBasicMaleNameAdjectives = new String[]{
            "",
            "",
            "",
            "Подозрительный ",
            "Высокий ",
            "Странный ",
            "Незнакомый ",
            "Низкий ",
            "Какой-то ",
            "Обычный ",
            "Гордливый ",
            "Типичный "
    };
}
