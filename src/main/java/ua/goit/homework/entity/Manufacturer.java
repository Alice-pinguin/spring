package ua.goit.homework.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "manufacturer")
@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Manufacturer implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Size(min=2, max=100, message = "Name must be in range of 2-100 symbols")
    @Column(name = "name", nullable = false, unique = true, length = 100)
    private String name;

    @OneToMany(mappedBy="manufacturer", fetch = FetchType.LAZY, cascade= CascadeType.ALL)
    private Set<Product> products;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manufacturer)) return false;

        Manufacturer that = (Manufacturer) o;

        if (id != null ? !id.equals (that.id) : that.id != null) return false;
        if (name != null ? !name.equals (that.name) : that.name != null) return false;
        return products != null ? products.equals (that.products) : that.products == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode () : 0;
        result = 31 * result + (name != null ? name.hashCode () : 0);
        result = 31 * result + (products != null ? products.hashCode () : 0);
        return result;
    }
}
