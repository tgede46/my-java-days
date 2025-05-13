package ma.enset.myapp;
import static spark.Spark.*;
import com.google.gson.Gson;
import java.util.*;

public class RestServer {
    public static void main (String[] args){
        Gson gson= new Gson();
        get("/hello",(req,resp)->{
            Map<String,Object> data=new HashMap<>();
            data.put("name", "Alfred");
            data.put("sala", "6500");
            resp.type("applcation/json");
            return data;
        },gson::toJson);
    }
}

