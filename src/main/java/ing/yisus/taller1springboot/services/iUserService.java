package ing.yisus.taller1springboot.services;

import ing.yisus.taller1springboot.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface iUserService {
    Optional<UserDTO> getUser(String username, String password);
    List<UserDTO>[] getAllUsers();
}
