package ing.yisus.taller1springboot.services;

import ing.yisus.taller1springboot.dto.CartDto;

import java.util.List;

public interface ICartService {
    public CartDto getCartById(long id);
    public List<CartDto> getAllCarts();
}
