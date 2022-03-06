package backend.schedules;

import backend.classes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ScheduleController
{
//    @Autowired //add this later for login verification maybe idk
//    UserRepository userRepository;

    @Autowired
    ClassRepository classRepository;

    @Autowired
    SectionRepository sectionRepository;

    @Autowired
    SectionTimesRepository sectionTimesRepository;

    @PostMapping("/schedule")
    public ScheduleOutputHelper addSchedule(@RequestBody ScheduleInputHelper body)
    {
        Schedule schedule = new Schedule();
        schedule.setName(body.name);
        schedule.setUser(body.user);
        for (int id : body.sections)
        {
            Section s = sectionRepository.getById(id);
            schedule.addSection(s);
        }
        ScheduleOutputHelper output = new ScheduleOutputHelper();
        output.user = schedule.getUser();
        output.name = schedule.getName();
        output.sections = schedule.getList();
        output.classes = new ArrayList<ClassData>();
        for(Section s : schedule.getList())
        {
            output.classes.add(s.getClassData());
        }
        return output;
    }
}
