package ing.yisus.taller1springboot.services;

import ing.yisus.taller1springboot.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    Optional<UserDTO> getUser(long userId);
    List<UserDTO> getAllUsers();
}
