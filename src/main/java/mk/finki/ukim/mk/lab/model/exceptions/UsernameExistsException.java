package mk.finki.ukim.mk.lab.model.exceptions;

public class UsernameExistsException extends RuntimeException{
    public UsernameExistsException() {
        System.out.println("Username already exists!");
    }
}
