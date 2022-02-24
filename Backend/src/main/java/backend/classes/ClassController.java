package backend.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClassController
{
    @Autowired
    ClassRepository classRepository;

    @Autowired
    SectionRepository sectionRepository;

    @Autowired
    SectionTimesRepository sectionTimesRepository;

    @GetMapping("/classes")
    public List<ClassData> getAllClasses()
    {
        return classRepository.findAll();
    }

    @GetMapping("/classes/{department}")
    public List<ClassData> getAllClasses(@PathVariable String department)
    {
        return classRepository.findAllByDepartmentTitle(department);
    }

    @GetMapping("/class/{department}/{number}")
    public ClassData getClass(@PathVariable String department, @PathVariable String number)
    {
        return classRepository.findByDepartmentTitleAndClassNumber(department, number);
    }

    @DeleteMapping("/class/{department}/{number}")
    public ClassData deleteClass(@PathVariable String department, @PathVariable String number)
    {
        ClassData classData = classRepository.findByDepartmentTitleAndClassNumber(department, number);
        classRepository.delete(classData);
        return classData;
    }

    @PutMapping("/class/{department}/{number}")
    public ClassData updateClass(@PathVariable String department, @PathVariable String number, @RequestBody ClassData classData)
    {
        classData.setDepartmentTitle(department);
        classData.setClassNumber(number);
        classRepository.save(classData);
        return classData;
    }

    @PostMapping("/class")
    public ClassData updateClass(@RequestBody ClassData classData)
    {
        for (Section s : classData.getSections())
        {
            for (SectionTimes st : s.getSectionTimes())
            {
                sectionTimesRepository.save(st);
            }
            sectionRepository.save(s);
        }

        classRepository.save(classData);
        return classData;
    }

    @PostMapping("/classes")
    public void updateClasses(@RequestBody List<ClassData> classes)
    {
        for (ClassData classData : classes)
        {
            for (Section s : classData.getSections())
            {
                for (SectionTimes st : s.getSectionTimes())
                {
                    sectionTimesRepository.save(st);
                }
                sectionRepository.save(s);
            }
            classRepository.save(classData);
        }
    }
}
