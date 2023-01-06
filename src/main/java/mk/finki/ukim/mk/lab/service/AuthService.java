package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Exceptions.InvalidArgumentsException;
import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.repository.JpaRepository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;


    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User login(String username, String password) {
        if (username==null || username.isEmpty() || password==null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return userRepository.findByUsernameAndPassword(username,
                password).orElseThrow(InvalidArgumentsException::new);
    }

}
