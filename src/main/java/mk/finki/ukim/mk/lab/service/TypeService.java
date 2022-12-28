package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.BalloonType;

import java.util.List;
import java.util.Optional;

public interface TypeService {
    List<BalloonType> findAll();
    Optional<BalloonType> findByName(String name);
}
