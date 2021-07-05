package com.example.s1122207_s1094387_iiatimd_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {
    private TimelineItem[] history;


    public static class HistoryViewHolder extends RecyclerView.ViewHolder{
        public TextView dateTextView;
        public TimelineItem timelineItem;

            public HistoryViewHolder(View v){
                super(v);
                dateTextView = v.findViewById(R.id.dateTextView);
            }
        }
     public HistoryAdapter(TimelineItem[] history){
        this.history = history;
     }

     @NonNull
     @Override
     public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.medicines_card, parent, false);
        HistoryViewHolder historyViewHolder = new HistoryViewHolder(v);
        return historyViewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        holder.dateTextView.setText(history[position].getDate());
        //TODO: Puts medicineCard in View
    }
    @Override
    public int getItemCount() { //Moet weten hoe groot array is
            return history.length;
        }

}

