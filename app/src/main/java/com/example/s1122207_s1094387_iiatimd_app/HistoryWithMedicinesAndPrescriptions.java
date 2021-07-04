package com.example.s1122207_s1094387_iiatimd_app;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

    public class HistoryWithMedicinesAndPrescriptions {
        @Embedded public History history;
        @Relation(
                parentColumn = "prescriptionRefId",
                entityColumn = "prescriptionId",
                entity = Prescription.class
        )
        public List<MedicineAndPrescription> medicineAndPrescriptions;
}
