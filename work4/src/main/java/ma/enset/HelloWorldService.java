package ma.enset;
import static spark.Spark.*;
import com.google.gson.Gson;

public class HelloWorldService {
    public static void main(String[] args) {

        get("/hello", (req, res)->"Hello, world");

        get("/hello/:name", (req,res)->{
            return "Hello, "+ req.params(":name");
        });
    }
}
