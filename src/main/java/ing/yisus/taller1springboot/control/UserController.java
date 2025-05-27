package ing.yisus.taller1springboot.control;

import ing.yisus.taller1springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/login")
    public String index(Model model) {
        return "login";
    }
}
