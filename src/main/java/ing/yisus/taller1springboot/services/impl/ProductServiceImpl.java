package ing.yisus.taller1springboot.services.impl;

import ing.yisus.taller1springboot.dto.ProductDto;
import ing.yisus.taller1springboot.services.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {
    private final RestTemplate restTemplate;

    @Override
    public ProductDto getProductById(long productId) {
        ProductDto product = restTemplate.getForObject("/products/{productId}", ProductDto.class, productId);
        return product;
    }

    @Override
    public ProductDto[] getAllProducts() {
        ProductDto[] products = restTemplate.getForObject("https://fakestoreapi.com/products", ProductDto[].class);
        return products;
    }
    public ProductDto[] getProducts(){
        return restTemplate.getForObject("https://fakestoreapi.com/products", ProductDto[].class);
    }
}
