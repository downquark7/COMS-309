package backend.schedules;

import backend.classes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleController
{
    @Autowired
    SectionRepository sectionRepository;

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

        return new ScheduleOutputHelper(schedule);
    }
}
