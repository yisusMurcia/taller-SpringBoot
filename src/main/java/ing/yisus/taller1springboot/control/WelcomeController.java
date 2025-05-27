package ing.yisus.taller1springboot.control;

import ing.yisus.taller1springboot.dto.ProductDto;
import ing.yisus.taller1springboot.services.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class WelcomeController {
    private final ProductServiceImpl productService;

    @GetMapping("bienvenida")
    public String bienvenida(Model model, @RequestParam("username") String username) {
        ProductDto[] products = productService.getAllProducts();
        model.addAttribute("username", username);
        model.addAttribute("products", products);
        return "bienvenida";
    }
}
