package ing.yisus.taller1springboot.services.impl;

import ing.yisus.taller1springboot.dto.UserDTO;
import ing.yisus.taller1springboot.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements IUserService {
    private static final RestTemplate restTemplate = new RestTemplate();

    @Override
    public Optional<UserDTO> getUser(long userId) {
        UserDTO user = restTemplate.getForObject("/users/{userId}", UserDTO.class, userId);
        return Optional.ofNullable(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        UserDTO[] users = restTemplate.getForObject("/users", UserDTO[].class);
        return List.of(users);
    }
    public static UserDTO[] getUsers (){
        UserDTO[] allUsers =  restTemplate.getForObject("https://fakestoreapi.com/users",UserDTO[].class);
        return allUsers;
    }
    public static long filterUsers(UserDTO[] filtrador,String password,String username){
        for(UserDTO usuario : filtrador){

            if(usuario.getUsername().equals(username) && usuario.getPassword().equals(password)){
                return usuario.getId();
            }

        }

        return 0;
    }
}
