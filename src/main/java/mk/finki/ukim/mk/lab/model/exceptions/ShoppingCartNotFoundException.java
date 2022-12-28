package mk.finki.ukim.mk.lab.model.exceptions;

public class ShoppingCartNotFoundException extends RuntimeException{
    public ShoppingCartNotFoundException(Long id) {
        super(String.format("Shopping cart with id %d not found",id));
    }
}
