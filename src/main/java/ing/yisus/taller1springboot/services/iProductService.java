package ing.yisus.taller1springboot.services;

import ing.yisus.taller1springboot.model.Product;
import org.springframework.web.client.RestTemplate;

public interface iProductService {
    public Product getProductById(int id);
}
