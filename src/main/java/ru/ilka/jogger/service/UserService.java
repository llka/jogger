package ru.ilka.jogger.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.ilka.jogger.entity.Role;
import ru.ilka.jogger.entity.User;
import ru.ilka.jogger.entity.Workout;
import ru.ilka.jogger.exception.RestException;
import ru.ilka.jogger.exception.RestExceptionNotFound;
import ru.ilka.jogger.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@Service
public class UserService {
    private static Logger logger = LogManager.getLogger(UserService.class);
    private static final int ACTIVE = 1;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(RestExceptionNotFound::new);
    }

    public User update(@Valid User user, Long id) {
        if (!userRepository.findById(id).isPresent()) {
            throw new RestException("No such user!", HttpStatus.BAD_REQUEST);
        }
        return userRepository.save(user);
    }

    public User getCurrentUser() {
        return userRepository.findByLoginIgnoreCase(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User register(@Valid User user) {
        if (userRepository.findByLoginIgnoreCase(user.getLogin()) == null) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setRole(Role.USER);
            user.setActive(ACTIVE);
            user = userRepository.save(user);
            return user;
        } else {
            throw new RestException("User with such login already exists!", HttpStatus.PARTIAL_CONTENT);
        }
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public User addWorkout(Workout workout, Long id) {
        User user = getById(id);
        user.addWorkout(workout);
        userRepository.save(user);
        return user;
    }
}
