package com.example.s1122207_s1094387_iiatimd_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.MedicineViewHolder> {
    private final Medicine[] medicines;

    public MedicineAdapter(Medicine[] medicines){
        this.medicines = medicines;
    }
    @NonNull
    @Override
    public MedicineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.medicine_card, parent, false);
        return new MedicineViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicineViewHolder holder, int position) {
        holder.textView.setText(medicines[position].getName());
    }

    @Override
    public int getItemCount() {
        return medicines.length;
    }

    public static class MedicineViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public MedicineViewHolder(View v){
            super(v);
            textView = v.findViewById(R.id.medicineTextView);
        }
    }

}
