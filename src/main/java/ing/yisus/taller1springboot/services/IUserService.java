package ing.yisus.taller1springboot.services;

import ing.yisus.taller1springboot.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    Optional<UserDto> getUser(long userId);
    List<UserDto> getAllUsers();
}
