package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.DataHolder.DataIsHere;
import mk.finki.ukim.mk.lab.model.Balloon;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BalloonRepository {
    private List<Balloon> balloonList;


    public List<Balloon> findAllBalloons()
    {
       return DataIsHere.balloonList;
    }
    public List<Balloon> findAllByNameOrDescription(String text)
    {
        return DataIsHere.balloonList.stream().filter(r->r.getDescription().contains(text) || r.getName().contains(text)).collect(Collectors.toList());
    }
}
