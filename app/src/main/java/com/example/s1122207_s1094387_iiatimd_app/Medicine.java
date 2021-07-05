package com.example.s1122207_s1094387_iiatimd_app;

import android.util.Log;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;

@Entity
public class Medicine {
    @PrimaryKey
    @SerializedName("id")
    private long medicineId;
    @ColumnInfo
    @SerializedName("name")
    private String name;
    @ColumnInfo
    @SerializedName("amount")
    private double amount;
    @ColumnInfo
    @SerializedName("unit_name")
    private String unit;

    public Medicine(long medicineId, String name, double amount, String unit) {
        this.medicineId = medicineId;
        this.name = name;
        this.amount = amount;
        this.unit = unit;
    }
    //Sommige getters en setters kunnen verwijderd worden
    public long getMedicineId() {
            return medicineId;
        }

    public void setMedicineId(long medicineId) {
        this.medicineId = medicineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getUnit() { return unit; }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public static Medicine[] fromJson(JSONArray jsonArray) throws JsonParseException {
        Gson gson = new Gson();

        Medicine[] medicines = gson.fromJson(jsonArray.toString(), Medicine[].class);

        for (Medicine medicine : medicines) {
            Log.d("TestJSONformatter", (String) medicine.getName());
        }
        return medicines;
    }

}
