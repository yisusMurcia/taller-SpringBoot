package ing.yisus.taller1springboot.control;

import ing.yisus.taller1springboot.dto.CartDto;
import ing.yisus.taller1springboot.dto.ProductDto;
import ing.yisus.taller1springboot.dto.ProductInfo;
import ing.yisus.taller1springboot.model.Cart;
import ing.yisus.taller1springboot.model.Product;
import ing.yisus.taller1springboot.services.impl.CartServiceImpl;
import ing.yisus.taller1springboot.services.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class WelcomeController {
    private final CartServiceImpl cartService;
    private final ProductServiceImpl productService;

    @GetMapping("bienvenida")
    public String bienvenida(Model model, @RequestParam("username") String username, @RequestParam("userId") int userId) {
        List<CartDto> carts = cartService.getCartByUserId(userId);

        //Get products from the products info from the cart
        List<List<Product>> listOfCarts = new ArrayList<>();
        for(CartDto cart : carts) {
            List<Product> products = new ArrayList<>();
            for (ProductInfo productInfo : cart.getProducts()) {
                ProductDto productDto = productService.getProductById(productInfo.getProductId());
                if(productDto != null) {
                    Product product = Product.builder().title(productDto.getTitle())
                            .description(productDto.getDescription())
                            .price(String.valueOf(productDto.getPrice()))
                            .image(productDto.getImage())
                            .id(productDto.getId())
                            .quantity(productInfo.getQuantity())
                            .build();
                    products.add(product);
                }
            }
            listOfCarts.add(products);
        }
        model.addAttribute("username", username);
        model.addAttribute("carts", listOfCarts);
        return "bienvenida";
    }
}
