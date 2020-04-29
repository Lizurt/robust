package amo.area.ObjectGenerators;

import amo.area.Area;
import amo.area.types.civilian.*;
import amo.area.types.common.Corridor;
import amo.area.types.common.MaintenanceTunnel;
import amo.area.types.engineering.Engineering;
import amo.area.types.engineering.EngineeringChiefEngineerOffice;
import amo.area.types.engineering.EngineeringLobby;
import amo.area.types.engineering.EngineeringStorage;
import amo.area.types.medbay.Medbay;
import amo.area.types.medbay.MedbayCMO;
import amo.area.types.medbay.MedbayChemistry;
import amo.area.types.medbay.MedbaySurgery;
import amo.area.types.security.SecurityBriefing;
import amo.area.types.security.SecurityHOSOffice;
import amo.area.types.security.SecurityLobby;
import amo.area.types.security.SecurityStorage;
import util.Random;

import java.util.ArrayList;
import java.util.List;

public abstract class AreaGenerator {

    public static List<Area> getGeneratedAreas(int amount) {
        List<Area> generatedAreas = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            switch (Random.random(23)) {
                // ENGINEERING
                case 0:
                    generatedAreas.add(new EngineeringLobby());
                    break;
                case 1:
                    generatedAreas.add(new Engineering());
                    break;
                case 2:
                    generatedAreas.add(new EngineeringChiefEngineerOffice());
                    break;
                case 3:
                    generatedAreas.add(new EngineeringStorage());
                    break;
                // COMMON
                case 4:
                    generatedAreas.add(new Corridor());
                    break;
                case 5:
                    generatedAreas.add(new MaintenanceTunnel());
                    break;
                // CIVILIAN
                case 6:
                    generatedAreas.add(new Bar());
                    break;
                case 7:
                    generatedAreas.add(new Canteen());
                    break;
                case 8:
                    generatedAreas.add(new Chapel());
                    break;
                case 9:
                    generatedAreas.add(new Dormitory());
                    break;
                case 10:
                    generatedAreas.add(new Kitchen());
                    break;
                case 11:
                    generatedAreas.add(new Latrine());
                    break;
                case 12:
                    generatedAreas.add(new Laundry());
                    break;
                case 13:
                    generatedAreas.add(new Library());
                    break;
                case 14:
                    generatedAreas.add(new PrivateOffice());
                    break;
                case 15:
                    generatedAreas.add(new ShowerRoom());
                    break;
                // SECURITY
                case 16:
                    generatedAreas.add(new SecurityLobby());
                    break;
                case 17:
                    generatedAreas.add(new SecurityBriefing());
                    break;
                case 18:
                    generatedAreas.add(new SecurityHOSOffice());
                    break;
                case 19:
                    generatedAreas.add(new SecurityStorage());
                    break;
                // MEDBAY
                case 20:
                    generatedAreas.add(new Medbay());
                    break;
                case 21:
                    generatedAreas.add(new MedbayChemistry());
                    break;
                case 22:
                    generatedAreas.add(new MedbayCMO());
                    break;
                case 23:
                    generatedAreas.add(new MedbaySurgery());
                    break;

            }
        }
        return generatedAreas;
    }
}
