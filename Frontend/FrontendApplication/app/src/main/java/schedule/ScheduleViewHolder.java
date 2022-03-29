package schedule;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.classdifficultyfrontend.R;

public class ScheduleViewHolder extends RecyclerView.ViewHolder{

    public final TextView hourOfDay;
    private final ScheduleAdapter.OnItemListener onItemListener;
   // private final TextView nameOfClass;
    public ScheduleViewHolder(@NonNull View itemView, ScheduleAdapter.OnItemListener onItemListener) {
        super(itemView);
        hourOfDay = itemView.findViewById(R.id.cellHourText);
       // this.onItemListener = onItemListener1;
        this.onItemListener = onItemListener;
        itemView.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view){
        onItemListener.onItemClick(getAdapterPosition(), (String) hourOfDay.getText());
    }

}
