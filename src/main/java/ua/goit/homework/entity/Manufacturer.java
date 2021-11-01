package ua.goit.homework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "manufacturer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Manufacturer implements BaseEntity<UUID> {

    @Id
    @Column(name = "id")
    private UUID id;

    @NotBlank
    @Size(min=2, max=100, message = "Name must be in range of 2-100 symbols")
    @Column(name = "name", nullable = false, unique = true, length = 100)
    private String name;

    @OneToMany(mappedBy="manufacturer", fetch = FetchType.LAZY, cascade= CascadeType.ALL)
    private Set<Product> products;
}
