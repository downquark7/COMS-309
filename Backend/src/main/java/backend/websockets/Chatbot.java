package backend.websockets;

import backend.classes.ClassRepository;
import backend.instructors.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Chatbot
{
    @Autowired
    ClassRepository classRepository;

    public String message(String message)
    {
        message = message.replaceFirst("bot ", "");
        if (message.contains("find"))
        {
            message = message.replaceFirst("find ", "");
            if (message.contains("class"))
            {
                return findClass(message);
            }
        }
        return "Sorry, I'm not sure what you mean";
    }

    private String findClass(String message)
    {
        String split[] = message.split(":");
        return classRepository.findByDepartmentTitleAndClassNumber(split[0], split[1]).toString();
    }
}
