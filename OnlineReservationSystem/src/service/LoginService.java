package service;

public class LoginService {

    private final String validId = "admin";
    private final String validPassword = "1234";

    public boolean login(String id, String password) {

        return validId.equals(id)
                && validPassword.equals(password);
    }
}