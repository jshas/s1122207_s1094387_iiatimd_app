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

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAllMedicines(Medicine... medicine);

    @Insert
    void insertMedicine(Medicine medicine);

    @Delete
    void delete(Medicine medicine);
}
