package ua.goit.homework.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table (name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product implements BaseEntity<UUID>{

    @Id
    @Column(name = "id")
    private UUID id;

    @NotBlank(message = "Name can't be empty")
    @Size(min = 3, max = 100, message = "Name must be in range of 3-100 symbols")
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "price", nullable = false, length = 20)
    private BigDecimal price;

    @ManyToOne()
    @JoinColumn(name = "manufacturer_id", nullable = false)
    private Manufacturer manufacturer;


}
