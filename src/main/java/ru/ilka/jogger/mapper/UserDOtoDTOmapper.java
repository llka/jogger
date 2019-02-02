package ru.ilka.jogger.mapper;

import ru.ilka.jogger.dto.UserDTO;
import ru.ilka.jogger.entity.User;

public class UserDOtoDTOmapper {
    public static UserDTO mapUser(User user) {
        if (user != null) {
            UserDTO dto = new UserDTO();
            dto.setId(user.getId());
            dto.setLogin(user.getLogin());
            return dto;
        } else {
            return null;
        }
    }
}
