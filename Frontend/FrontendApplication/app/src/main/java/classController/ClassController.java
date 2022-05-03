package classController;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class ClassController {
    public static ClassData getAClass(String dept, String number) throws IOException {
        URL url = new URL(Config.baseURL + "/class/" + dept + "/" + number);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(url, ClassData.class);
    }

    public static List<ClassData> getByDepartmentShort(String deptShort) throws IOException {
        URL url = new URL(Config.baseURL + "/classes/" + DepartmentCodes.shortToLong(deptShort));
        ObjectMapper mapper = new ObjectMapper();
        return Arrays.asList(mapper.readValue(url, ClassData[].class));
    }

    public static List<ClassData> getByDepartment(String dept) throws IOException {
        URL url = new URL(Config.baseURL + "/classes/" + dept);
        ObjectMapper mapper = new ObjectMapper();
        return Arrays.asList(mapper.readValue(url, ClassData[].class));
    }

    public static List<ClassData> getAllClasses() throws IOException {
        URL url = new URL(Config.baseURL + "/classes");
        ObjectMapper mapper = new ObjectMapper();
        return Arrays.asList(mapper.readValue(url, ClassData[].class));
    }
//    public static List<SectionTime> getScheduleByUserId(String userId) throws IOException {
//        URL url = new URL(Config.baseURL + "/schedule/byUserId/" + userId);
//        ObjectMapper mapper = new ObjectMapper();
//        return Arrays.asList(mapper.readValue(url, SectionTime[].class));
//    }
}
