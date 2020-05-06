package amo.area.ObjectGenerators;

import amo.Size;
import amo.area.Area;
import amo.area.LootType;
import amo.obj.Obj;
import amo.obj.items.clothing.*;
import amo.obj.items.consumable.food.Wine;
import amo.obj.items.consumable.medicine.Medkit;
import amo.obj.items.consumable.medicine.MedkitUsed;
import amo.obj.items.tools.*;
import amo.obj.items.weapons.melee.*;
import amo.obj.lootable.*;
import util.Random;
import java.util.ArrayList;

public abstract class LootGenerator {

    private static final int TINY_SIZED_ITEM    = 0;
    private static final int SMALL_SIZED_ITEM   = 1;
    private static final int NORMAL_SIZED_ITEM  = 2;
    private static final int BULKY_SIZED_ITEM   = 3;
    private static final int HUGE_SIZED_ITEM    = 4;

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
        [TINY_SIZED_ITEM]   - amount of tiny items;     "price" is 1
        [SMALL_SIZED_ITEM]  - amount of small items;    "price" is 2
        [NORMAL_SIZED_ITEM] - amount of normal items;   "price" is 3
        [BULKY_SIZED_ITEM]  - amount of bulky items;    "price" is 4
        [HUGE_SIZED_ITEM]   - amount of huge items;     "price" is 5
     */
    private static int[] generateLootAmount(int lootAmountPoints) {
        int[] generatedLootAmount = new int[5];
        while (lootAmountPoints > 0) {
            switch (Random.pick(Size.values())) {
                case TINY:
                    lootAmountPoints--;
                    generatedLootAmount[TINY_SIZED_ITEM]++;
                    break;
                case SMALL:
                    if (lootAmountPoints < 2) {
                        lootAmountPoints--;
                        generatedLootAmount[TINY_SIZED_ITEM]++;
                        break;
                    }
                    lootAmountPoints -= 2;
                    generatedLootAmount[SMALL_SIZED_ITEM]++;
                    break;
                case NORMAL:
                    if (lootAmountPoints < 3) {
                        break;
                    }
                    lootAmountPoints -= 3;
                    generatedLootAmount[NORMAL_SIZED_ITEM]++;
                    break;
                case BULKY:
                    if (lootAmountPoints < 4) {
                        break;
                    }
                    lootAmountPoints -= 4;
                    generatedLootAmount[BULKY_SIZED_ITEM]++;
                    break;
                case HUGE:
                    if (lootAmountPoints < 5) {
                        break;
                    }
                    lootAmountPoints -= 5;
                    generatedLootAmount[HUGE_SIZED_ITEM]++;
                    break;
            }
        }
        return generatedLootAmount;
    }

    private static ArrayList<Obj> generateGeneralLoot(Area area) throws Exception {
        int[] generatedLootAmount = generateLootAmount(generateLootAmountPoints(area));
        ArrayList<Obj> generatedLoot = new ArrayList<>();

        for (; generatedLootAmount[TINY_SIZED_ITEM] > 0; generatedLootAmount[TINY_SIZED_ITEM]--) {
            switch (Random.random(0)) {
                case 0:
                    generatedLoot.add(new Lighter(area));
                    break;
            }
        }

        for (; generatedLootAmount[SMALL_SIZED_ITEM] > 0; generatedLootAmount[SMALL_SIZED_ITEM]--) {
            switch (Random.random(4)) {
                case 0:
                    generatedLoot.add(new Screwdriver(area));
                    break;
                case 1:
                    generatedLoot.add(new Wrench(area));
                    break;
                case 2:
                    generatedLoot.add(new Multitool(area));
                    break;
                case 3:
                    generatedLoot.add(new Medkit(area));
                    break;
                case 4:
                    generatedLoot.add(new MedkitUsed(area));
                    break;
            }
        }

        for (; generatedLootAmount[NORMAL_SIZED_ITEM] > 0; generatedLootAmount[NORMAL_SIZED_ITEM]--) {
            switch (Random.random(4)) {
                case 0:
                    generatedLoot.add(new Welder(area));
                    break;
                case 1:
                    generatedLoot.add(new MetalRod(area));
                    break;
                case 2:
                    generatedLoot.add(new BreathMask(area));
                    break;
                case 3:
                    generatedLoot.add(new Wires(area));
                    break;
                case 4:
                    generatedLoot.add(new Wine(area));
                    break;
            }
        }

        for (; generatedLootAmount[BULKY_SIZED_ITEM] > 0; generatedLootAmount[BULKY_SIZED_ITEM]--) {
            switch (Random.random(1)) {
                case 0:
                    generatedLoot.add(new FireAxe(area));
                    break;
                case 1:
                    generatedLoot.add(new BasicSpacesuit(area));
                    break;
            }
        }

        for (; generatedLootAmount[HUGE_SIZED_ITEM] > 0; generatedLootAmount[HUGE_SIZED_ITEM]--) {
            switch (Random.random(0)) {
                case 0:
                    generatedLoot.add(new GenericCloset(area));
                    break;
            }
        }

        return generatedLoot;
    }

}
