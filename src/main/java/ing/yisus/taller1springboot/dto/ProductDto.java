package ing.yisus.taller1springboot.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private long id;
    private String title;
    private BigDecimal price;
    private String description;
    private String category;
    private String image;
}
