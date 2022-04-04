package schedule;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.classdifficultyfrontend.R;

import java.util.ArrayList;

public class ScheduleAdapter extends RecyclerView.Adapter< ScheduleViewHolder> {
    private final ArrayList<String> hoursOfDay;
    private final OnItemListener onItemListener;

    public ScheduleAdapter(ArrayList<String> hoursOfDay, OnItemListener onItemListener) {
        this.hoursOfDay = hoursOfDay;
        this.onItemListener = onItemListener;
    }

    @NonNull
    @Override
    public ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.hour_cell, parent, false);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = (int) (parent.getHeight() * 0.166);
        return new ScheduleViewHolder(view, onItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleViewHolder holder, int position) {
        holder.hourOfDay.setText(hoursOfDay.get(position));
    }

    @Override
    public int getItemCount() {
        return hoursOfDay.size();
    }

    public interface OnItemListener{
        void onItemClick(int position, String dayText);
    }

}

//interface OnItemListener{
//    void onItemClick(int position, String dayText);
//}