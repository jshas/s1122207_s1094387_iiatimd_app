package com.example.s1122207_s1094387_iiatimd_app;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.List;


public class MedicineAndPrescriptionAdapter extends RecyclerView.Adapter<MedicineAndPrescriptionAdapter.viewHolder> {

    // Class variables
    private final List<MedicineAndPrescription> medicineAndPrescriptions ;

    // Constructor
    public MedicineAndPrescriptionAdapter(List<MedicineAndPrescription> medicineAndPrescriptions) {
        Log.d("List", medicineAndPrescriptions.toString());
        this.medicineAndPrescriptions = medicineAndPrescriptions;

    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.medicine_card, parent, false);
        return new viewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MedicineAndPrescriptionAdapter.viewHolder holder, int position) {
        holder.nameTextView.setText(medicineAndPrescriptions.get(position).medicine.getName());
        String amountText;
        // Dose: with formatted float and string
        DecimalFormat formatter = new DecimalFormat("0.00");
        double formattedAmount = Double.parseDouble(
                formatter.format(
                        medicineAndPrescriptions
                                .get(position)
                                .prescription
                                .getSingleDose()));
        amountText = holder.itemView.getContext().getString(
                R.string.medicine_amount,
                String.valueOf(formattedAmount),
                medicineAndPrescriptions.get(position).medicine.getUnit() );
        holder.doseTextView.setText(amountText);
    }

    @Override
    public int getItemCount() {
        return medicineAndPrescriptions.size();
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




