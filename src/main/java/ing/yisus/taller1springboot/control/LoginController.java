package ing.yisus.taller1springboot.control;

import ing.yisus.taller1springboot.dto.UserDto;
import ing.yisus.taller1springboot.services.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller


public class LoginController {

    @RequestMapping("/login")
    public String logIn(@RequestParam String username, @RequestParam String password, Model model){

        UserDto[] users = UserServiceImpl.getUsers();
        long userRequired = UserServiceImpl.filterUsers(users,password,username);
        if(userRequired != 0 ){
            model.addAttribute("username",username);
            return "bienvenida";
        }else {
            model.addAttribute("error","Usuario o contraseña incorrectos");
            return "login";
        }
    }
}
