package com.example.s1122207_s1094387_iiatimd_app;

import androidx.room.Embedded;
import androidx.room.Relation;

public class MedicineAndPrescription {
        @Embedded
        Prescription prescription;
        @Relation(
                parentColumn = "medicineRefId",
                entityColumn = "medicineId"
        )
        public Medicine medicine;
}
