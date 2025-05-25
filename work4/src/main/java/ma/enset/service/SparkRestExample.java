package ma.enset.service;

import static spark.Spark.options;
import static spark.Spark.*;
import com.google.gson.Gson;

public class SparkRestExample {
    public static void main(String[] args) {
        post("/users", (request, response) -> {
            response.type("application/json");
            User user = new Gson().fromJson(request.body(), User.class);
            userService.addUser(user);

            return new Gson()
                    .toJson(new StandardResponse(StatusResponse.SUCCESS));
        });
        get("/users", (request, response) -> {
            //...
        });
        get("/users/:id", (request, response) -> {
            //...
        });
        put("/users/:id", (request, response) -> {
            //...
        });
        delete("/users/:id", (request, response) -> {
            //...
        });
        options("/users/:id", (request, response) -> {
            //...
        });
    }
}