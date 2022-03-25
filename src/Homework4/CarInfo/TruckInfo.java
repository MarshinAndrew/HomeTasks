package Homework4.CarInfo;

import Homework4.Enums.TruckEnums.TruckTonnage;

public class TruckInfo extends CarInfo{

    private final TruckTonnage tonnage;

    public TruckInfo(TruckTonnage tonnage) {
        this.tonnage = tonnage;
    }

    public TruckTonnage getTonnage() {
        return tonnage;
    }
}
