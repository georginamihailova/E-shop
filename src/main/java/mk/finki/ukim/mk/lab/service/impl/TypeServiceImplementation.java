package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.BalloonType;
import mk.finki.ukim.mk.lab.repository.jpa.TypeRepository;
import mk.finki.ukim.mk.lab.service.TypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeServiceImplementation implements TypeService {
    private final TypeRepository typeRepository;

    public TypeServiceImplementation(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public List<BalloonType> findAll() {
        return typeRepository.findAll();
    }

    @Override
    public Optional<BalloonType> findByName(String name) {
        return this.typeRepository.findByTypeName(name);
    }
}
