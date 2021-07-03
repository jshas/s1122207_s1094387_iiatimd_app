package com.example.s1122207_s1094387_iiatimd_app;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
    foreignKeys = {
        @ForeignKey(entity = Medicine.class, parentColumns = "medicineId", childColumns =  "medicineId")
    }
)
public class History {
    @PrimaryKey
    private int historyId;
    @ColumnInfo(index = true)
    private int medicineId ;
    @ColumnInfo(defaultValue = "CURRENT_TIMESTAMP")
    private String createdAt; // SQLite stores timestamp Stamps instead of datetime objects

    public History(int historyId, int medicineId, String createdAt) {
        this.historyId = historyId;
        this.medicineId = medicineId;
        this.createdAt = createdAt;
    }

    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }


    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    @NonNull
    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(@NonNull String createdAt) {
        this.createdAt = createdAt;
    }
}


