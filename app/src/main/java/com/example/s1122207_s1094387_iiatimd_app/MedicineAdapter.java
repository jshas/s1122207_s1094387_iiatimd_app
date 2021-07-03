package com.example.s1122207_s1094387_iiatimd_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.List;

public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.viewHolder> {
    private final List<Medicine> medicines;
    public MedicineAdapter(List<Medicine> medicines){
        this.medicines = medicines;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.medicine_card, parent, false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.nameTextView.setText(medicines.get(position).getName());
        String amountText;
        // Dose: with formatted float and string
        DecimalFormat formatter = new DecimalFormat("0.00");
        double formattedAmount = Double.parseDouble(formatter.format(medicines.get(position).getAmount()));
        amountText = holder.itemView.getContext().getString(R.string.medicine_amount, String.valueOf(formattedAmount), medicines.get(position).getUnit() );
        holder.doseTextView.setText(amountText);
    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);

    }

    @Override
    public int getItemCount() {
        return medicines.size();
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
