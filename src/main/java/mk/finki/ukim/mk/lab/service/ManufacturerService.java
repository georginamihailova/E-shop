package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {
    List<Manufacturer> findAll();
    Optional<Manufacturer> findByName(String name);
    Optional<Manufacturer> findById(Long id);
    Optional<Manufacturer> save(String name, String country,String address);


}
