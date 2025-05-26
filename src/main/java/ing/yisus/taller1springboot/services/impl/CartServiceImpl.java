package ing.yisus.taller1springboot.services.impl;

import ing.yisus.taller1springboot.dto.CartDto;
import ing.yisus.taller1springboot.services.ICartService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements ICartService {
    private final RestTemplate restTemplate;
    @Override
    public CartDto getCartById(long id) {
        CartDto cart = restTemplate.getForObject("/carts/{id}", CartDto.class, id);
        return cart;
    }

    @Override
    public List<CartDto> getAllCarts() {
        CartDto[] carts = restTemplate.getForObject("/carts", CartDto[].class);
        if (carts != null) {
            return List.of(carts);
        } else {
            return List.of();
        }
    }
}
