package com.example.s1122207_s1094387_iiatimd_app;

import androidx.room.PrimaryKey;

import java.util.ArrayList;


/* TODO:Medicinecard moet MedicineAndPrescription worden
 *
 * TODO: CARDVIEW
 *  1) Add/Remove button
 *  2) Add 'Total Amount' selector. (How much is taken daily? e.g. 30mg)
 *  3) Add interval
 *  4) Optionally: Dose is calculated by: (total amount / interval) (e.g. dose = 30mg/4 = 7.5mg)
 *
 */

public class MedicinesCard {

    @PrimaryKey
    private String name;
    //Array list with medicine this card holds
    private ArrayList<Medicine> medicines = new ArrayList<Medicine>();
    //Name or ID from user for destinct cards
    private int dailyAmount;


    public MedicinesCard(String name, Medicine medicine) {
        this.name = name;
        medicines.add(medicine);
        this.dailyAmount = dailyAmount;
    }

    public Medicine[] getMedicines() {
        Medicine[] medicineArray = medicines.toArray(new Medicine[0]);
        return medicineArray;
    }

    public void addMedicine(Medicine medicine){
        medicines.add(medicine);
    }

}
