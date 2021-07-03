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
    private long historyId;
    @ColumnInfo(index = true)
    private long medicineId;
    private double takenDoses;
    private double totalDoses;
    @ColumnInfo(defaultValue = "CURRENT_TIMESTAMP")
    private String createdAt; // SQLite stores timestamp Stamps instead of datetime objects

    public History(long historyId, long medicineId, String createdAt) {
        this.historyId = historyId;
        this.medicineId = medicineId;
        this.createdAt = createdAt;
    }

    public long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(long historyId) {
        this.historyId = historyId;
    }


    public long getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(long medicineId) {
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


