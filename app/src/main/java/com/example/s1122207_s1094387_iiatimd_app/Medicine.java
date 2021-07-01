package com.example.s1122207_s1094387_iiatimd_app;

public class Medicine {
    private int uuid;
    private String name;
    private float amount;
    private String unit;

    public Medicine(int uuid, String name, float amount, String unit) {
        this.uuid = uuid;
        this.name = name;
        this.amount = amount;
        this.unit = unit;
    }
    //Sommige getters en setters kunnen verwijderd worden
    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
