package com.example.s1122207_s1094387_iiatimd_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

    public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {
        private History[] timeline;

        //Wijs gegevens aan bij de adapter
        public HistoryAdapter(timelineItem[] timeline){
            this.timeline = timeline;
        }

        public static class HistoryViewHolder extends RecyclerView.ViewHolder{
            public TextView textView;

            //Replace textView with a whole card
            public HistoryViewHolder(View v){
                super(v);
                textView = v.findViewById(R.id.dateTextView);
            }
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
            holder.textView.setText(timeline[position].getName()); //tekst op positie = positie in pillen[]
        }

        @Override
        public int getItemCount() { //Moet weten hoe groot array is
            return timeline.length;
        }

}

