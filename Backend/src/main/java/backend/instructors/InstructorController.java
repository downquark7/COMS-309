package backend.instructors;

import backend.classes.ClassData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/***
 * 
 */
@RestController
public class InstructorController
{
    @Autowired
    InstructorRepository instructorRepository;

    /***
     * get classes by specific instructor
     * @param instructor as string
     * @return list of classes taught by instructor
     */
    @GetMapping("/instructorClasses/{instructor}")
    public List<ClassData> instructorClasses(@PathVariable String instructor)
    {
        Instructor i = instructorRepository.findByInstrName(instructor);
        return i.getClasses();
    }

    /***
     * @return list of all instructors and the classes they teach nested within
     */
    @GetMapping("/allInstructors")
    public List<Instructor> allInstructors() {
        return instructorRepository.findAll();
    }
}
