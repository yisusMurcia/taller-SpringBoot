package ing.yisus.taller1springboot.services.impl;

import ing.yisus.taller1springboot.dto.UserDTO;
import ing.yisus.taller1springboot.services.iUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements iUserService {
    private final RestTemplate restTemplate;

    @Override
    public Optional<UserDTO> getUser(String username, String password) {//Check if username and password are in the API
        return Optional.of(new UserDTO());//Just for testing
    }

    @Override
    public List<UserDTO>[] getAllUsers() {
        UserDTO[] users = restTemplate.getForObject("/users", UserDTO[].class);
        return (List<UserDTO>[]) users;
    }
}
