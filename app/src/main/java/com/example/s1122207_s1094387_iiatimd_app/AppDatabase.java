package com.example.s1122207_s1094387_iiatimd_app;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(
        entities = {
                User.class,
                Medicine.class,
                History.class,
                Prescription.class,
        }
            ,
        views = {HistoryDetail.class},
        version = 7)
@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract MedicineDao medicineDao();
    public abstract PrescriptionDao prescriptionDao();
    public abstract HistoryDao historyDao();

    private static AppDatabase instance;

    static synchronized AppDatabase getInstance(Context context){
        if(instance == null){
            instance = create(context);
        }
        return instance;
    }

    private static AppDatabase create(final Context context) {
        //FIXME: Replace .allowMainThreadQueries() with seperate Task Classes in project
        return Room.databaseBuilder(context, AppDatabase.class, "PillReminderData").allowMainThreadQueries().fallbackToDestructiveMigration().build();
    }
}
