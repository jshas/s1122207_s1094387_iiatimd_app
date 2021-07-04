package com.example.s1122207_s1094387_iiatimd_app;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;


@Entity(
)
public class History {
    @PrimaryKey
    public long historyId;
    public long prescriptionRefId;
    public double takenDoses;
    public double totalDoses;
    public Date createdAt;
    public boolean completed;

    public History(long historyId, long prescriptionRefId, double takenDoses, double totalDoses, Date createdAt, boolean completed) {
        this.historyId = historyId;
        this.prescriptionRefId = prescriptionRefId;
        this.takenDoses = takenDoses;
        this.totalDoses = totalDoses;
        this.createdAt = createdAt;
        this.completed = completed;
    }
}


