package aom.mob.humanoid.player;

import aom.Gender;
import aom.mob.humanoid.Humanoid;

public class Player extends Humanoid {

    public Player(String newName) {
        setRealName(newName);
    }

    public StringBuilder generateIntroductoryStory() {
        StringBuilder coolStory = new StringBuilder();
        coolStory.append("Вы, ");
        coolStory.append(getAge()).append(" летн").append(getGender() == Gender.FEMALE ? "яя " : "ий ");
        coolStory.append(getRealName());
        coolStory.append(", - ");
        coolStory.append("обычный ").append("технический ассистент"); // TODO
        coolStory.append(", работающий в месте под названием \"");
        coolStory.append("Научно-исследовательская станция \"Исход\"\""); // TODO
        coolStory.append(". Эта смена была и остается необычной для вас. Вами было пережито много проишествий всего за несколько часов. ");
        coolStory.append("Сидя в одиночестве на мягком кресле в инженерном отделе, "); // TODO
        coolStory.append("вы слышите еще одно объявление о новой проблеме. Холодный, женский, синтезированный голос доносит до ваших ушей, что");
        coolStory.append("на станции обнаружена неизвестная форма жизни"); // TODO
        coolStory.append(". В объявлении также говорится, что ");
        coolStory.append("вам стоит оставаться в своем отсеке, а в случае обнаружения неизвестных существ доложить об этом службе безопасности"); // TODO
        coolStory.append(". Осознавая, что вы давно не видели никаких сотрудников службы безопасности, как и, в прочем, членов экипажа, вы решаете проигнорировать рекомендации руководства. Несмотря на их слова на протяжении всей смены о том, что в скором времени ситуация взята в руки, вы больше не можете терпеть и ждать помощи. ");
        coolStory.append("Переполняющие вас чувства страха и одиночества заставляют"); // TODO
        coolStory.append(" вас начать искать спасение самому - вы хотите сбежать, не дожидаясь помощи!\n\nВаша задача - выжить, а самый надежный, на ваш взгляд, способ - сбежать отсюда. Ожидание помощи даже более рискованно, чем спасение самому. Попытайтесь найти способ сбежать. Удачи!");
        return coolStory;
    }

}
