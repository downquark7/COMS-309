package com.example.classdifficultyfrontend;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ScheduleViewHolder extends RecyclerView.ViewHolder{

    private final TextView hourOfDay;
    private final TextView nameOfClass;
    public ScheduleViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
