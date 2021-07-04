package com.example.s1122207_s1094387_iiatimd_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;

public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.viewHolder> {
    private final Medicine[] medicines;

    public MedicineAdapter(Medicine[] medicines){
        this.medicines = medicines;
    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.medicine_card, parent, false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.nameTextView.setText(medicines[position].getName());
        String amountText;
        // Dose: with formatted float and string
        DecimalFormat formatter = new DecimalFormat("0.00");
        double formattedAmount = Double.parseDouble(formatter.format(medicines[position].getAmount()));
        amountText = holder.itemView.getContext().getString(R.string.medicine_amount, String.valueOf(formattedAmount), medicines[position].getUnit() );
        holder.doseTextView.setText(amountText);
    }

    @Override
    public int getItemCount() {
        return medicines.length;
    }

    public static class viewHolder extends RecyclerView.ViewHolder{
        public TextView nameTextView, doseTextView;
        public viewHolder(View v){
            super(v);
            nameTextView = v.findViewById(R.id.medicineTextView);
            doseTextView = v.findViewById(R.id.medicineTextView2);
        }
    }

}
