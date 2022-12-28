package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.model.enumType.Role;

import java.util.Optional;

public interface UserService
{
   Optional<User> findById(Long id);
   Optional<User> findByUsernameAndPassword(String username,String password);
   Optional<User> findByUsername(String username);
   User register(String username, String password, String repeatPassword, String name, String surname, Role roleUser);

}
