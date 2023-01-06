package mk.finki.ukim.mk.lab.service.Interfaces;

import mk.finki.ukim.mk.lab.model.Balloon;

import java.util.List;
import java.util.Optional;

public interface BalloonService {
    List<Balloon> listAll();
    Optional<Balloon> searchByNameOrDescription(String text);
    void addBalloon(Balloon a);

}
