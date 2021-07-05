package com.example.s1122207_s1094387_iiatimd_app;

import androidx.room.PrimaryKey;

import java.util.ArrayList;

public class TimelineItem {
    
    @PrimaryKey
    //Every timelineItem has a date
    private String date;
    //Every timelineItem has at least 1 medicineCard
    private ArrayList<MedicinesCard> medicinesCard = new ArrayList<MedicinesCard>();


    public TimelineItem(String date, MedicinesCard medicine) {
        this.date = date;
        medicinesCard.add(medicine);
    }

    public String getDate() {
        return date;
    }

    public ArrayList<MedicinesCard> getMedicines() {
        return medicinesCard;
    }
}
