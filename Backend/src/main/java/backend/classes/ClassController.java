package backend.classes;

import backend.instructors.Instructor;
import backend.instructors.InstructorRepository;
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

    @Autowired
    InstructorRepository instructorRepository;

    private Instructor getInstructor(String instrName)
    {
        Instructor i = instructorRepository.findByInstrName(instrName);
        if (i == null)
        {
            i = new Instructor(instrName);
            instructorRepository.save(i);
        }
        return i;
    }

    @PostMapping("/class")
    public ClassData updateClass(@RequestBody ClassData classData)
    {
        for (Section s : classData.getSections())
        {
            sectionTimesRepository.saveAll(s.getSectionTimes());
            sectionRepository.save(s);
            for (SectionTime st : s.getSectionTimes())
                classData.addInstructor(getInstructor(st.getInstrName()));
        }
        classRepository.save(classData);
        for (Section s : classData.getSections())
        {
            for (SectionTime st : s.getSectionTimes())
            {
                st.setSection(s);
                sectionTimesRepository.save(st);
                getInstructor(st.getInstrName()).addClass(classData);
            }
            s.setClassData(classData);
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
                sectionTimesRepository.saveAll(s.getSectionTimes());
                sectionRepository.save(s);
                for (SectionTime st : s.getSectionTimes())
                    classData.addInstructor(getInstructor(st.getInstrName()));
            }
            classRepository.save(classData);
            for (Section s : classData.getSections())
            {
                for (SectionTime st : s.getSectionTimes())
                {
                    st.setSection(s);
                    sectionTimesRepository.save(st);
                    getInstructor(st.getInstrName()).addClass(classData);
                }
                s.setClassData(classData);
                sectionRepository.save(s);
            }
            classRepository.save(classData);
        }
    }
}
