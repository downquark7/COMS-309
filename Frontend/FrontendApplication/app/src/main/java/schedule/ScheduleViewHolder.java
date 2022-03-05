package schedule;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.classdifficultyfrontend.R;

public class ScheduleViewHolder extends RecyclerView.ViewHolder{

    private final TextView hourOfDay;
   // private final TextView nameOfClass;
    public ScheduleViewHolder(@NonNull View itemView) {
        super(itemView);
        hourOfDay = itemView.findViewById(R.id.item_number);
    }
}
