package ing.yisus.taller1springboot.services.impl;

import ing.yisus.taller1springboot.dto.ProductDto;
import ing.yisus.taller1springboot.model.Product;
import ing.yisus.taller1springboot.services.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {
    private final RestTemplate restTemplate;
    //Save the product list in an array
    private ArrayList<Product> products;
    @Override
    public ProductDto getProductById(long productId) {
        ProductDto product = restTemplate.getForObject("/products/{productId}", ProductDto.class, productId);
        return null;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        ProductDto[] products = restTemplate.getForObject("/products", ProductDto[].class);
        return List.of(products);
    }
}
