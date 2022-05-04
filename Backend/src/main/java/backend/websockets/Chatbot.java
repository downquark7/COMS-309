package backend.websockets;

import backend.classes.ClassData;
import backend.classes.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Access;

public class Chatbot
{
    protected static ClassRepository classRepository;

    public static String message(String message)
    {
        message = message.replaceFirst("bot ", "");
        if (message.contains("find"))
        {
            message = message.replaceFirst("find ", "");
            if (message.contains("class"))
            {
                message = message.replaceFirst("class ", "");
                return findClass(message);
            }
        }
        return "Sorry, I'm not sure what you mean";
    }

    private static String findClass(String message)
    {
        String split[] = message.split(":");
        ClassData classData = classRepository.findByDepartmentTitleAndClassNumber(split[0], split[1]);
        if(classData == null)
            return "Class not found";
        return classData.toString();
    }
}
