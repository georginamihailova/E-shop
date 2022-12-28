package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static mk.finki.ukim.mk.lab.bootstrap.DataHolder.manufacturers;

@Repository
public class inMemoryManufacturerRepository {
    public List<Manufacturer> findAll(){
        return manufacturers;
    }

    public Optional<Manufacturer> findByName(String name){
        return manufacturers.stream().filter(r->r.getName().equals(name)).findFirst();
    }
    public Optional<Manufacturer> findById(Long id){
        return manufacturers.stream().filter(r->r.getId().equals(id)).findFirst();
    }
}

