package ing.yisus.taller1springboot.control;


import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BienvenidaController {

    @GetMapping("/bienvenida")
    public String bienvenida(@RequestParam String username, Model modelo) {

        modelo.addAttribute("username",username);
        return "bienvenida";
    }
}
