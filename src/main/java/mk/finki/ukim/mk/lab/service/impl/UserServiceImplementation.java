package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.model.enumType.Role;
import mk.finki.ukim.mk.lab.model.exceptions.InvalidUsernameOrPassword;
import mk.finki.ukim.mk.lab.model.exceptions.PasswordsDontMatchException;
import mk.finki.ukim.mk.lab.model.exceptions.UsernameExistsException;
import mk.finki.ukim.mk.lab.repository.jpa.UserRepository;
import mk.finki.ukim.mk.lab.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImplementation(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> findByUsernameAndPassword(String username, String password) {
       return userRepository.findByUsernameAndPassword(username,password);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname, Role roleUser) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidUsernameOrPassword();
        }
        if (!password.equals(repeatPassword)) {
            throw new PasswordsDontMatchException();
        }
        if (!this.userRepository.findByUsername(username).isEmpty() || this.userRepository.findByUsername(username).isPresent()) {
            throw new UsernameExistsException();
        }
        User user = new User(username, name, surname,passwordEncoder.encode(password),roleUser);
        userRepository.save(user);
        return user;
    }


}
