package ua.goit.homework.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table (name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "producer_id", nullable = false)
    private Manufacturer producer;





}
