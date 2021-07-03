package com.example.s1122207_s1094387_iiatimd_app;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.text.DecimalFormat;
import java.util.ArrayList;

@Entity
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

    public ArrayList<Medicine> getMedicines() {
        return medicines;
    }

    public void addMedicine(Medicine medicine){
        medicines.add(medicine);
    }

}
