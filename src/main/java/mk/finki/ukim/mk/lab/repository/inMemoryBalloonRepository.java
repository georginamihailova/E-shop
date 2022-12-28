package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.BalloonType;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static mk.finki.ukim.mk.lab.bootstrap.DataHolder.*;

@Repository
public class inMemoryBalloonRepository {

    public List<Balloon> findAllBalloons(){
        return balloons;
    }
    public List<Balloon> findAllByNameOrDescription(String text){
        return balloons.stream().filter(r->r.getName().contains(text) || r.getDescription().contains(text)).collect(Collectors.toList());
    }
    public void deleteById(Long id){
        balloons.removeIf(r->r.getId().equals(id));
    }
    public Optional<Balloon> save(String name, String desc, Manufacturer manufacturer, BalloonType balloonType){
        balloons.removeIf(r->r.getName().equals(name) || r.getDescription().equals(desc));
        Balloon balloon = new Balloon(name, desc, manufacturer);
        balloons.add(balloon);
        return Optional.of(balloon);
    }
    public Optional<Balloon> findById(Long id){
        return balloons.stream().filter(r->r.getId().equals(id)).findFirst();
    }

}
