package com.example.s1122207_s1094387_iiatimd_app;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(primaryKeys = {"userId", "medicineId"})
public class MedicineAndUsers {
    private int userId;
    private int medicineId;

    public MedicineAndUsers(int userId, int medicineId) {
        this.userId = userId;
        this.medicineId = medicineId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }


}
