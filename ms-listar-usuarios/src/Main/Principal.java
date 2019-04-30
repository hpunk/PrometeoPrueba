package Main;

import io.javalin.Javalin;
import user.UserController;

public class Principal {

	public static void main(String[] args) {
		Javalin app = Javalin.create()
				  .enableCorsForOrigin("127.0.0.1:4000")
				  .port(7000)
				  .start();
		app.get("/hello", ctx -> ctx.html("Hello, Javalin!"));
		app.get("/users", UserController.fetchAllUsernames);
		app.get("/users/:id", UserController.fetchById);
	}

}
