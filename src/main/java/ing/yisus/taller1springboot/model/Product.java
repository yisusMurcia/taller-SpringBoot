package ing.yisus.taller1springboot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private String title;
    private String description;
    private String image;
    private String category;
    private String price;
    private long id;
    private long quantity;
}
