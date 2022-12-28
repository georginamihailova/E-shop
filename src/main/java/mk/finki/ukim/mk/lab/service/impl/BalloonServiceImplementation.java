package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.BalloonType;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.model.exceptions.BalloonNotFoundException;
import mk.finki.ukim.mk.lab.model.exceptions.ManufacturerNotFoundException;
import mk.finki.ukim.mk.lab.repository.jpa.BalloonRepository;
import mk.finki.ukim.mk.lab.repository.jpa.ManufacturerRepository;
import mk.finki.ukim.mk.lab.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalloonServiceImplementation implements BalloonService
{
    private final BalloonRepository balloonRepository;
    private final ManufacturerRepository manufacturerRepository;

    public BalloonServiceImplementation(BalloonRepository balloonRepository, ManufacturerRepository manufacturerRepository) {
        this.balloonRepository = balloonRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Balloon> listAll() {
        return balloonRepository.findAll();
    }

    @Override
    public Balloon searchByNameOrDescription(String text,String description) {
        return this.balloonRepository.findByNameOrDescription(text,description).orElseThrow(() -> new BalloonNotFoundException(text,description));
    }

    @Override
    public void deleteById(Long id) {
        balloonRepository.deleteById(id);
    }

    @Override
    public Optional<Balloon> save(String name, String desc, Long manufacturerId) {
        Manufacturer manufacturer = this.manufacturerRepository.findById(manufacturerId).orElseThrow(() ->new ManufacturerNotFoundException(manufacturerId));
        return Optional.of(this.balloonRepository.save(new Balloon(name,desc,manufacturer)));
    }

    @Override
    public Optional<Balloon> findById(Long id) {
        return balloonRepository.findById(id);
    }


    @Override
    public Balloon create(String name, String description) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException();
        }
        Balloon b = new Balloon(name,description);
        balloonRepository.save(b);
        return b;
    }


}
