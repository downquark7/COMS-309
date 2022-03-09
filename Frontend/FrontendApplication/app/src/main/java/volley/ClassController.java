package volley;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static volley.VolleyConfig.baseURL;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

public class ClassController {
    public static ClassData getAClass() throws IOException {
        URL url = new URL(baseURL + "/class/MUSIC/102");
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.canSerialize(ClassData.class));
        return mapper.readValue(url, ClassData.class);
    }
}
