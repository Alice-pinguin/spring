package ua.goit.homework.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table (name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class Product implements BaseEntity<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Name can't be empty")
    @Size(min = 3, max = 100, message = "Name must be in range of 3-100 symbols")
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "price", nullable = false, length = 20)
    private BigDecimal price;

    @ManyToOne()
    @JoinColumn(name = "manufacturer_id", nullable = false)
    private Manufacturer manufacturer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (id != null ? !id.equals (product.id) : product.id != null) return false;
        if (name != null ? !name.equals (product.name) : product.name != null) return false;
        if (price != null ? !price.equals (product.price) : product.price != null) return false;
        return manufacturer != null ? manufacturer.equals (product.manufacturer) : product.manufacturer == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode () : 0;
        result = 31 * result + (name != null ? name.hashCode () : 0);
        result = 31 * result + (price != null ? price.hashCode () : 0);
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode () : 0);
        return result;
    }
}
