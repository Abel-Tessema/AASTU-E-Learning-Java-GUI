package controllers;

import models.User;
import services.UserService;

public class AuthController {
    private UserService userService = new UserService();

    public boolean logIn(String email, String password) {
        User user = userService.logIn(email, password);
        // ToDo: Write the user information to the loggedInUser.bin file
        return email.equals("user") && password.equals("1234");
    }

    public boolean logOut() {
        // ToDo: Empty the loggedInUser.bin file
        return true;
    }
}
