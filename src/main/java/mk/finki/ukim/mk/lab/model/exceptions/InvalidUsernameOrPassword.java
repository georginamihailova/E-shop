package mk.finki.ukim.mk.lab.model.exceptions;

public class InvalidUsernameOrPassword extends RuntimeException{
    public InvalidUsernameOrPassword() {
        System.out.println("Invalid Username or Password!");
    }
}
