package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.repository.JpaRepository.ManufacturerRepositoryJpa;
import mk.finki.ukim.mk.lab.repository.ManufacturerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService implements mk.finki.ukim.mk.lab.service.Interfaces.ManufacturerService {
    private final ManufacturerRepositoryJpa manufacturerRepository;

    public ManufacturerService(ManufacturerRepositoryJpa manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacturer> findAll() {
        return manufacturerRepository.findAll();
    }
}
