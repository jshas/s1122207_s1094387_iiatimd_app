package com.example.s1122207_s1094387_iiatimd_app;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MedicineDao {
    @Query("SELECT * FROM medicine")
    List<Medicine> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllMedicines(Medicine... medicine);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMedicine(Medicine medicine);

    @Delete
    void delete(Medicine medicine);
}
