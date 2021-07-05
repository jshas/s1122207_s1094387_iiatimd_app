package com.example.s1122207_s1094387_iiatimd_app;

import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppDatabaseSeeder {

    public static synchronized void insertAllUsersTask(AppDatabase db) {
        User[] users = new User[3];
        users[0] = new User(1, "Sjon", "sjonnie@testkip.nl");
        users[1] = new User(2, "Hadou", "hadou@testkip.nl");
        users[2] = new User(3, "Ken", "ken@testkip.nl");
        db.userDao().insertAll(users);
    }

    public static synchronized void insertAllMedicinesTask(AppDatabase db) {
        Medicine[] medicines = new Medicine[7];
        medicines[0] = new Medicine(1, "Ibuprofen", 200d, "mg");
        medicines[1] = new Medicine(2, "Ritalin", 10d, "mg");
        medicines[2] = new Medicine(3, "Adderall", 2.5d, "mg");
        medicines[3] = new Medicine(4, "Advil", 1000d, "mg");
        medicines[4] = new Medicine(5, "Cough Syrup", 200d, "ml");
        medicines[5] = new Medicine(6, "Vitamin D", 5d, "mg");
        medicines[6] = new Medicine(7, "Melatonin", 1d, "mg");
        db.medicineDao().insertAllMedicines(medicines);
    }

    public static synchronized void insertAllPrescriptions(AppDatabase db) {
        Prescription[] prescriptions = new Prescription[7];
        prescriptions[0] = new Prescription(1, 1, 30, 4, 180);
        prescriptions[1] = new Prescription(2, 2, 10, 4, 120);
        prescriptions[2] = new Prescription(3, 3, 5, 3, 240);
        prescriptions[3] = new Prescription(4, 4, 1000, 4, 120);
        prescriptions[4] = new Prescription(5, 5, 20, 2, 600);
        prescriptions[5] = new Prescription(6, 6, 5, 1, 0);
        prescriptions[6] = new Prescription(7, 7, 2, 1, 0);
        db.prescriptionDao().insertAll(prescriptions);
    }

    public static synchronized void insertAllHistory(AppDatabase db) {
        History[] histories = new History[4];
        long currentTimeMillis = System.currentTimeMillis();
        Date currentDate = DateConverter.toDate(currentTimeMillis);
        histories[0] = new History(0, 1, 3, 4, currentDate, false);
        histories[1] = new History(1, 3, 2, 4, currentDate, false);
        histories[2] = new History(2, 2, 2, 4, currentDate, false);
        histories[3] = new History(3, 4, 4, 4, currentDate, false);
        db.historyDao().insertAllHistory(histories);
    }
}
