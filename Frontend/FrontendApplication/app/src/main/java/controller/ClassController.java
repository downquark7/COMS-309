package controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class ClassController {
    public static ClassData getAClass(String dept, String number) throws IOException {
        URL url = new URL(Config.baseURL + "/class/"+dept+"/"+number);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(url, ClassData.class);
    }
}
