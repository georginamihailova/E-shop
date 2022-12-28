package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.BalloonType;

import java.util.List;
import java.util.Optional;

public interface BalloonService {
    List<Balloon> listAll();
    Balloon searchByNameOrDescription(String text,String description);
    void deleteById(Long id);
    Optional<Balloon> save(String name, String desc, Long manufacturer);
    Optional<Balloon> findById(Long id);
    Balloon create(String name,String description);
}
