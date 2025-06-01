package ing.yisus.taller1springboot.control;

import ing.yisus.taller1springboot.dto.ProductDto;
import ing.yisus.taller1springboot.services.impl.ProductServiceImpl;
import org.springframework.ui.Model;

public class ProductsController {
    public String productos(Model model){
        ProductDto[] products = ProductServiceImpl.getProducts();
        model.addAttribute("products", products);
        return "productos";
    }
}
