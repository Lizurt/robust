package amo.area.ObjectGenerators;

import amo.Size;
import amo.area.Area;
import amo.area.LootType;
import amo.obj.Obj;
import amo.obj.items.clothing.*;
import amo.obj.items.tools.*;
import amo.obj.items.weapons.melee.*;
import amo.obj.lootable.*;
import util.Random;
import java.util.ArrayList;

public abstract class LootGenerator {

    public static ArrayList<Obj> getGeneratedLoot(Area area) throws Exception {
        if (area.getLootType() == LootType.NONE) {
            return new ArrayList<>();
        }

        ArrayList<Obj> generatedLoot = generateGeneralLoot(area);
        switch (area.getLootType()) {
            case ENGINEERING:
                break;
            case SECURITY:
                break;
            case MEDICAL:
                break;
        }
        return generatedLoot;
    }

    private static int generateLootAmountPoints(Area area) throws Exception {
        switch (area.getSize()) {
            case HUGE:
                return Random.random(32);
            case BULKY:
                return Random.random(16);
            case NORMAL:
                return Random.random(8);
            case SMALL:
                return Random.random(4);
            case TINY:
                return Random.random(2);
            default:
                throw new Exception("Unknown area size: " + area.getSize());
        }
    }

    /*
        [0] - amount of tiny items;     "price" is 1
        [1] - amount of small items;    "price" is 2
        [2] - amount of normal items;   "price" is 3
        [3] - amount of bulky items;    "price" is 4
        [4] - amount of huge items;     "price" is 5
     */
    private static int[] generateLootAmount(int lootAmountPoints) {
        int[] generatedLootAmount = new int[5];
        while (lootAmountPoints > 0) {
            switch (Random.pick(Size.values())) {
                case TINY:
                    lootAmountPoints--;
                    generatedLootAmount[0]++;
                    break;
                case SMALL:
                    if (lootAmountPoints < 2) {
                        lootAmountPoints--;
                        generatedLootAmount[0]++;
                        break;
                    }
                    lootAmountPoints -= 2;
                    generatedLootAmount[1]++;
                    break;
                case NORMAL:
                    if (lootAmountPoints < 3) {
                        break;
                    }
                    lootAmountPoints -= 3;
                    generatedLootAmount[2]++;
                    break;
                case BULKY:
                    if (lootAmountPoints < 4) {
                        break;
                    }
                    lootAmountPoints -= 4;
                    generatedLootAmount[3]++;
                    break;
                case HUGE:
                    if (lootAmountPoints < 5) {
                        break;
                    }
                    lootAmountPoints -= 5;
                    generatedLootAmount[4]++;
                    break;
            }
        }
        return generatedLootAmount;
    }

    private static ArrayList<Obj> generateGeneralLoot(Area area) throws Exception {
        int[] generatedLootAmount = generateLootAmount(generateLootAmountPoints(area));
        ArrayList<Obj> generatedLoot = new ArrayList<>();

        for (; generatedLootAmount[0] > 0; generatedLootAmount[0]--) {
            switch (Random.random(0)) {
                case 0:
                    generatedLoot.add(new Lighter(area));
                    break;
            }
        }

        for (; generatedLootAmount[1] > 0; generatedLootAmount[1]--) {
            switch (Random.random(0)) {
                case 0:
                    generatedLoot.add(new Screwdriver(area));
                    break;
            }
        }

        for (; generatedLootAmount[2] > 0; generatedLootAmount[2]--) {
            switch (Random.random(0)) {
                case 0:
                    generatedLoot.add(new Welder(area));
                    break;
            }
        }

        for (; generatedLootAmount[3] > 0; generatedLootAmount[3]--) {
            switch (Random.random(0)) {
                case 0:
                    break;
            }
        }

        for (; generatedLootAmount[4] > 0; generatedLootAmount[4]--) {
            switch (Random.random(0)) {
                case 0:
                    generatedLoot.add(new GenericCloset(area));
                    break;
            }
        }

        return generatedLoot;
    }

}
