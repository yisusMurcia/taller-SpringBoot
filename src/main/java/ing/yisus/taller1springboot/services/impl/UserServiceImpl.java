package ing.yisus.taller1springboot.services.impl;

import ing.yisus.taller1springboot.dto.UserDto;
import ing.yisus.taller1springboot.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements IUserService {
    private static final RestTemplate restTemplate = new RestTemplate();

    @Override
    public Optional<UserDto> getUser(long userId) {
        UserDto user = restTemplate.getForObject("/users/{userId}", UserDto.class, userId);
        return Optional.ofNullable(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        UserDto[] users = restTemplate.getForObject("/users", UserDto[].class);
        return List.of(users);
    }
    public static UserDto[] getUsers (){
        UserDto[] allUsers =  restTemplate.getForObject("https://fakestoreapi.com/users", UserDto[].class);
        return allUsers;
    }
    public static long filterUsers(UserDto[] filtrador, String password, String username){
        for(UserDto usuario : filtrador){

            if(usuario.getUsername().equals(username) && usuario.getPassword().equals(password)){
                return usuario.getId();
            }

        }

        return 0;
    }
}
