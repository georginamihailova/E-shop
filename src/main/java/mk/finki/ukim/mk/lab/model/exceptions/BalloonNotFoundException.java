package mk.finki.ukim.mk.lab.model.exceptions;

public class BalloonNotFoundException extends RuntimeException{
    public BalloonNotFoundException(String text,String description) {
        super(String.format("Balloon with name %s and description %s does not exists"));
    }
}
