package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.BalloonType;
import org.springframework.stereotype.Repository;

import java.util.List;

import static mk.finki.ukim.mk.lab.bootstrap.DataHolder.balloonTypes;

@Repository
public class inMemoryTypeRepository {
    public List<BalloonType> findAll(){
        return balloonTypes;
    }
}
