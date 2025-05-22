package ing.yisus.taller1springboot.control;


import org.springframework.ui.Model;
import ing.yisus.taller1springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class BienvenidaController {
    @GetMapping("/bienvenida")
    public String bienvenida(Model modelo) {
        User user = new User();
        modelo.addAttribute("user", user);
        //modelo.addText("user");
        return "bienvenida";
    }
}
