package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Exceptions.InvalidUsernameOrPasswordException;
import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.repository.JpaRepository.UserRepository;
import mk.finki.ukim.mk.lab.service.Interfaces.UserServiceInterface;
import mk.finki.ukim.mk.lab.model.Role;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname, Role userRole) {
        if (username==null || username.isEmpty()  || password==null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if (!password.equals(repeatPassword))
            throw new InvalidUsernameOrPasswordException();
        if(this.userRepository.findByUsername(username).isPresent())
            throw new InvalidUsernameOrPasswordException();
        User user = new User(username,passwordEncoder.encode(password),name,surname,userRole);
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException(username));
    }
}
