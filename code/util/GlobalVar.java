package util;

import game_scenes.MainMenuScene;
import game_scenes.PauseMenuScene;
import game_scenes.adventure_scene.AdventureScene;
import javafx.stage.Stage;

public abstract class GlobalVar {
    public static Difficulty difficulty = Difficulty.MEDIUM;
    public static int windowWidth = 960;
    public static int windowHeight = 560;
    public static Stage mainStage;
    public static AdventureScene adventureScene;
    public static MainMenuScene mainMenuScene;
    public static PauseMenuScene pauseMenuScene;

    public static final String REGEX_BORDER_COLOR = "-fx-border-color: #.{1,6};";
    public static final String REGEX_BACKGROUND_COLOR = "-fx-background-color: #.{1,6};";
    public static final String STYLE_BACKGROUND_COLOR_DEFAULT = "-fx-background-color: #2A2526;";

    public static final int MIN_AGE =  20;
    public static final int MAX_AGE = 80;
    public static final String[] ALLOWED_FEMALE_HUMAN_REAL_NAME = new String[]{
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
    public static final String[] ALLOWED_MALE_HUMAN_REAL_NAME = new String[]{
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
    public static final String[] ALLOWED_BASIC_FEMALE_NAME_ADJECTIVES = new String[]{
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
    public static final String[] ALLOWED_BASIC_MALE_NAME_ADJECTIVES = new String[]{
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
