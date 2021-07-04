package com.example.s1122207_s1094387_iiatimd_app;

import androidx.room.DatabaseView;

import java.util.Date;

@DatabaseView(
        "SELECT h.historyId as history_id, " +
                "m.name as medicine_name, " +
                "p.singleDose as single_dose_amount, " +
                "h.takenDoses as taken_doses, " +
                "p.frequency as total_doses, " +
                "h.completed as completed " +
        "FROM history as h "+
        "JOIN prescription as p ON h.prescriptionRefId = p.prescriptionId " +
        "JOIN medicine as m ON  p.medicineRefId = m.medicineId;")
public class HistoryDetail {
    public long historyId;
    public String name;
    public double takenDoses;
    public double totalDoses;
    public Date createdAt;
    public boolean completed;
}

