package ing.yisus.taller1springboot.control;

import ing.yisus.taller1springboot.dto.ProductDto;
import ing.yisus.taller1springboot.dto.UserDto;
import ing.yisus.taller1springboot.services.impl.ProductServiceImpl;
import ing.yisus.taller1springboot.services.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final ProductServiceImpl productService;

    @PostMapping("/login")
    public String logIn(@RequestParam String username, @RequestParam String password, Model model){

        UserDto[] users = UserServiceImpl.getUsers();
        long userRequired = UserServiceImpl.filterUsers(users,password,username);
        if(userRequired != 0 ){

            ProductDto[] products = productService.getAllProducts();
            model.addAttribute("username",username);
            model.addAttribute("products",products);
            return "bienvenida";

        }else {
            model.addAttribute("error","Usuario o contraseña incorrectos");
            return "login";
        }
    }
}
