package ing.yisus.taller1springboot.services.impl;

import ing.yisus.taller1springboot.dto.CartDto;
import ing.yisus.taller1springboot.services.ICartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Locale.filter;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements ICartService {
    private final RestTemplate restTemplate;
    @Override
    public List<CartDto> getCartByUserId(long userId) {
        List<CartDto> carts= getAllCarts();
        return carts.stream().filter(cart -> cart.getUserId() == userId).toList();
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
