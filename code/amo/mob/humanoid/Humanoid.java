package amo.mob.humanoid;

import amo.area.Area;
import amo.mob.Mob;
import amo.mob.Species;
import util.GlobalVar;

import static util.Random.*;
import static amo.Gender.*;
import static amo.mob.Species.*;


public class Humanoid extends Mob {

    private int age = 35;
    private Species species = HUMAN;

    public Humanoid(Area newLocation) {
        super(newLocation);
        setGender(pick(MALE, FEMALE));
        setAge(random(GlobalVar.minAge, GlobalVar.maxAge));
        setSpecies(pick(HUMAN, SKRELL, UNATHI, TAJARA, IPC));
    }

    @Override
    public String generateRandomRealName() {
        return pick(getGender() == FEMALE ? GlobalVar.allowedFemaleHumanRealName : GlobalVar.allowedMaleHumanRealName);
    }

    @Override
    public String generateRandomName() {
        String generatedName = "";
        if (getGender() == FEMALE) {
            switch (getSpecies()) {
                case HUMAN:
                    if (getAge() >= 60) {
                        generatedName = "Старушка";
                    } else if (getAge() >= 30) {
                        generatedName = "Женщина";
                    } else {
                        generatedName = "Девушка";
                    }
                    break;
                case IPC:
                    generatedName = "Робот";
                    break;
                case SKRELL:
                    generatedName = "Скреллка";
                    break;
                case TAJARA:
                    generatedName = "Таяра";
                    break;
                case UNATHI:
                    generatedName = "Унатхша";
                    break;
            }
        } else {
            switch (getSpecies()) {
                case HUMAN:
                    if (getAge() >= 60) {
                        generatedName = "Старик";
                    } else if (getAge() >= 30) {
                        generatedName = "Мужчина";
                    } else {
                        generatedName = "Парень";
                    }
                    break;
                case IPC:
                    generatedName = "Робот";
                    break;
                case SKRELL:
                    generatedName = "Скрелл";
                    break;
                case TAJARA:
                    generatedName = "Таяра";
                    break;
                case UNATHI:
                    generatedName = "Унатх";
                    break;
            }
        }
        return generateNameAdjective() + generatedName;
    }

    @Override
    public String generateNameAdjective() {
        if (getGender() == FEMALE) {

        } else {

        }
        return pick(getGender() == FEMALE ? GlobalVar.allowedBasicFemaleNameAdjectives : GlobalVar.allowedBasicMaleNameAdjectives);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    @Override
    public void entered(Area area) {

    }

    @Override
    public void exited(Area area) {

    }

}
