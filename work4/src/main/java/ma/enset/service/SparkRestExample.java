package ma.enset.service;

import static spark.Spark.*;

import com.google.gson.Gson;
import ma.enset.service.reponse.StandardResponse;
import ma.enset.service.reponse.StatusResponse;

public class SparkRestExample {

    // Initialisation du service utilisateur
    static UserService userService = new UserService();

    public static void main(String[] args) {
        // Configuration de base
        port(4567); // port par défaut

        // Routes REST

        // ➕ Ajouter un utilisateur
        post("/users", (request, response) -> {
            response.type("application/json");
            User user = new Gson().fromJson(request.body(), User.class);
            userService.addUser(user);
            return new Gson().toJson(new StandardResponse(StatusResponse.SUCCESS, "User added"));
        });

        // 📃 Obtenir tous les utilisateurs
        get("/users", (request, response) -> {
            response.type("application/json");
            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS,
                            new Gson().toJsonTree(userService.getUsers()))
            );
        });

        // 🔍 Obtenir un utilisateur par ID
        get("/users/:id", (request, response) -> {
            response.type("application/json");
            User user = userService.getUser(request.params(":id"));
            if (user != null) {
                return new Gson().toJson(
                        new StandardResponse(StatusResponse.SUCCESS,
                                new Gson().toJsonTree(user))
                );
            } else {
                return new Gson().toJson(
                        new StandardResponse(StatusResponse.ERROR, "User not found")
                );
            }
        });

        // ✏️ Modifier un utilisateur
        put("/users/:id", (request, response) -> {
            response.type("application/json");
            User toEdit = new Gson().fromJson(request.body(), User.class);
            User editedUser = userService.editUser(toEdit);
            if (editedUser != null) {
                return new Gson().toJson(
                        new StandardResponse(StatusResponse.SUCCESS,
                                new Gson().toJsonTree(editedUser))
                );
            } else {
                return new Gson().toJson(
                        new StandardResponse(StatusResponse.ERROR, "User not found or could not be edited")
                );
            }
        });

        // ❌ Supprimer un utilisateur
        delete("/users/:id", (request, response) -> {
            response.type("application/json");
            userService.deleteUser(request.params(":id"));
            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS, "User deleted")
            );
        });

        // ✅ Vérifier si un utilisateur existe (OPTIONS)
        options("/users/:id", (request, response) -> {
            response.type("application/json");
            boolean exists = userService.userExist(request.params(":id"));
            return new Gson().toJson(
                    new StandardResponse(StatusResponse.SUCCESS,
                            exists ? "User exists" : "User does not exist")
            );
        });
    }
}
