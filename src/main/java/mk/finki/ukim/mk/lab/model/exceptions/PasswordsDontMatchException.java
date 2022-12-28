package mk.finki.ukim.mk.lab.model.exceptions;

public class PasswordsDontMatchException extends RuntimeException{
    public PasswordsDontMatchException() {
        System.out.println("Passwords dont match!");
    }
}
