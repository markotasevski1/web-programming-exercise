package mk.finki.ukim.mk.lab.DataHolder;

import mk.finki.ukim.mk.lab.model.Balloon;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataIsHere {
    public static List<Balloon> balloonList=new ArrayList<>();
    @PostConstruct
    public void init()
    {
        balloonList.add(new Balloon("a","b"));
        balloonList.add(new Balloon("a","b"));
        balloonList.add(new Balloon("a","b"));
        balloonList.add(new Balloon("a","b"));
        balloonList.add(new Balloon("a","b"));
        balloonList.add(new Balloon("a","b"));
        balloonList.add(new Balloon("a","b"));
        balloonList.add(new Balloon("a","b"));
        balloonList.add(new Balloon("a","b"));
        balloonList.add(new Balloon("a","b"));
    }
}
