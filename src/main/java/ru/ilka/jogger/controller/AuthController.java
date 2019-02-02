package ru.ilka.jogger.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ilka.jogger.entity.User;
import ru.ilka.jogger.service.UserService;
import ru.ilka.jogger.util.UrlSchema;

import javax.validation.Valid;

@RestController
@RequestMapping(value = UrlSchema.AUTH)
public class AuthController {
    private static Logger logger = LogManager.getLogger(AuthController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        logger.debug("registration " + user);
        return userService.register(user);
    }
}
