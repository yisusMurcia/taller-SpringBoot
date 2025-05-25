package ing.yisus.taller1springboot.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller


public class LoginController {
    @RequestMapping("/login")
    public String logIn(){
        return "login";
    }
}
