package ing.yisus.taller1springboot.control;

import ing.yisus.taller1springboot.dto.ProductDto;
import ing.yisus.taller1springboot.dto.UserDto;
import ing.yisus.taller1springboot.services.impl.ProductServiceImpl;
import ing.yisus.taller1springboot.services.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final ProductServiceImpl productService;

    @GetMapping("/login")
    public String index(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String logIn(@RequestParam String username, @RequestParam String password, Model model, RedirectAttributes redirectAttributes){

        UserDto[] users = UserServiceImpl.getUsers();
        long userRequired = UserServiceImpl.filterUsers(users,password,username);
        if(userRequired != 0 ){
            redirectAttributes.addAttribute("username",username);
            redirectAttributes.addAttribute("userId", userRequired);
            return "redirect:/bienvenida";

        }else {
            model.addAttribute("error","Usuario o contraseña incorrectos");
            return "login";
        }
    }
}
