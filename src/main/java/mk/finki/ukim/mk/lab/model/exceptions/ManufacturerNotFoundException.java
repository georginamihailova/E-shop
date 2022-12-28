package mk.finki.ukim.mk.lab.model.exceptions;

public class ManufacturerNotFoundException extends RuntimeException{
    public ManufacturerNotFoundException(Long manufacturerId) {
        super(String.format("Manufacturer with id %d not found",manufacturerId));
    }
}
