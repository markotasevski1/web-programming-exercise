package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Exceptions.ManufacturerNotFound;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.repository.JpaRepository.BalloonRepositoryJpa;
import mk.finki.ukim.mk.lab.repository.JpaRepository.ManufacturerRepositoryJpa;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalloonService implements mk.finki.ukim.mk.lab.service.Interfaces.BalloonService {
    private final BalloonRepositoryJpa balloonRepository;
    private final ManufacturerRepositoryJpa manufacturerRepository;

    public BalloonService(BalloonRepositoryJpa balloonRepository, ManufacturerRepositoryJpa manufacturerRepository) {
        this.balloonRepository = balloonRepository;
        this.manufacturerRepository = manufacturerRepository;
    }


    @Override
    public List<Balloon> listAll() {
        return balloonRepository.findAll();
    }

    @Override
    public Optional<Balloon> searchByNameOrDescription(String text) {
        return balloonRepository.findAllByName(text);
    }

    @Override
    public void addBalloon(Balloon a) {
        balloonRepository.save(a);
    }
    public void deleteBalloon(long id)
    {
        balloonRepository.deleteById(id);
    }


    public Optional<Balloon> getById(Long id)
    {
        return this.balloonRepository.findById(id);
    }
    public Optional<Balloon> addBalloon(String balloonName, String descirption, long manufacturerId) {
        Manufacturer foundById=this.manufacturerRepository.findById(manufacturerId).orElseThrow(()->new ManufacturerNotFound(manufacturerId));
        Balloon newBalloon=new Balloon(balloonName,descirption,foundById);
        return Optional.of( balloonRepository.save(newBalloon));

    }
    public Balloon edit(Long id, String balloonName, String descirption, long manufacturerId)
    {
        Manufacturer foundById=this.manufacturerRepository.findById(manufacturerId).orElseThrow(()->new ManufacturerNotFound(manufacturerId));
        Balloon balon = this.balloonRepository.findById(id).orElseThrow(()->new RuntimeException("nema"));
        balon.setName(balloonName);
        balon.setDescription(descirption);
        balon.setManufacturer(foundById);
        return balloonRepository.save(balon);
    }
}
