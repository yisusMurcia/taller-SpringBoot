package ing.yisus.taller1springboot.services;

import ing.yisus.taller1springboot.dto.ProductDto;

import java.util.List;

public interface IProductService {
    public ProductDto getProductById(long id);
    public List<ProductDto> getAllProducts();
}
