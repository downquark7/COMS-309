package backend.schedules;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class ScheduleData
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @ElementCollection
//    private ArrayList<String> list = new ArrayList<>();
}
