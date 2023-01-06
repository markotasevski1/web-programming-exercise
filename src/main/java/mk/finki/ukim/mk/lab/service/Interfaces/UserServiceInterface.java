package mk.finki.ukim.mk.lab.service.Interfaces;


import mk.finki.ukim.mk.lab.model.Role;
import mk.finki.ukim.mk.lab.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserServiceInterface extends UserDetailsService {

    User register(String username, String password, String repeatPassword, String name, String surname, Role role);
}
