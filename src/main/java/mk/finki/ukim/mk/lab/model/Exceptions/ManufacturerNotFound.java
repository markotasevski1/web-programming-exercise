package mk.finki.ukim.mk.lab.model.Exceptions;

import mk.finki.ukim.mk.lab.model.Manufacturer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ManufacturerNotFound extends RuntimeException{
    public ManufacturerNotFound(Long line)
    {
        super(String.format("%d",line));
    }
}
