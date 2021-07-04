package com.example.s1122207_s1094387_iiatimd_app;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface PrescriptionDao {
  @Query("SELECT * FROM Prescription;")
  List<Prescription> getAll();

  @Transaction
  @Query("SELECT * FROM prescription")
  List<MedicineAndPrescription> getMedicinesWithPrescription();

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insertAll(Prescription... prescriptions);

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insert(Prescription prescription);

  @Delete
  void delete(Prescription prescription);

}
