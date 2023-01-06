package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.DataHolder.DataIsHere;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ManufacturerRepository  {
    public List<Manufacturer> findAll()
    {
        return DataIsHere.manufacturers;
    }
    public Optional<Manufacturer> findById(Long id)
    {
        return DataIsHere.manufacturers.stream().filter(r->r.getId().equals(id)).findFirst();
    }
}
