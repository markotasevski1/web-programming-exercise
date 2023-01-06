package mk.finki.ukim.mk.lab.repository.JpaRepository;

import mk.finki.ukim.mk.lab.model.Balloon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BalloonRepositoryJpa extends JpaRepository<Balloon,Long> {

    Optional<Balloon> findAllByName(String text);
}
