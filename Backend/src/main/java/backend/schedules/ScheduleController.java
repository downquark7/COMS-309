package backend.schedules;

import backend.classes.*;
import backend.users.User;
import backend.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/***
 * Rest Controller focused on getting and creating schedules
 */
@RestController
public class ScheduleController
{
    @Autowired
    SectionRepository sectionRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ScheduleRepository scheduleRepository;

    @PostMapping("/schedule")
    public ScheduleOutputHelper addSchedule(@RequestBody ScheduleInputHelper body)
    {
        Schedule schedule = new Schedule();
        schedule.setName(body.name);
        User userFromDb = userRepository.findByUsername(body.user.getUsername());

        if (userFromDb != null)
            schedule.setUser(userFromDb);
        else
            schedule.setUser(body.user);

        for (int id : body.sections)
        {
            Section s = sectionRepository.getById(id);
            schedule.addSection(s);
        }

        if (userFromDb != null)
        {
            scheduleRepository.save(schedule);
            userFromDb.addSchedule(schedule);
            userRepository.save(userFromDb);
        }

        return new ScheduleOutputHelper(schedule);
    }

    @GetMapping("/schedules/byUserId/{userid}")
    public List<ScheduleOutputHelper> getSchedules(@PathVariable int userid) {
        List<ScheduleOutputHelper> scheduleList = new ArrayList<>();
        for(Schedule s : userRepository.getById(userid).getSchedules())
        {
            scheduleList.add(new ScheduleOutputHelper(s));
        }
        return scheduleList;
    }

    @GetMapping("/schedule/byId/{id}")
    public ScheduleOutputHelper getSchedule(@PathVariable int id) {
        return new ScheduleOutputHelper(scheduleRepository.getById(id));
    }
}
