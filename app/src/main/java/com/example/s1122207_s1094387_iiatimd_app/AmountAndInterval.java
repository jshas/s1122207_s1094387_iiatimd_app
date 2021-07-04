package com.example.s1122207_s1094387_iiatimd_app;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

@Entity
public class AmountAndInterval {
    @PrimaryKey
    private int id;
    @Embedded
    private MedicineAndUsers medicineAndUsers;
    //TODO: Check if this should be a @Relation or @Entity
    private float totalDailyAmount;
    private int interval;

    public MedicineAndUsers getMedicineAndUsers() {
        return medicineAndUsers;
    }

    public void setMedicineAndUsers(MedicineAndUsers medicineAndUsers) {
        this.medicineAndUsers = medicineAndUsers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotalDailyAmount() {
        return totalDailyAmount;
    }

    public void setTotalDailyAmount(float totalDailyAmount) {
        this.totalDailyAmount = totalDailyAmount;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }


}
