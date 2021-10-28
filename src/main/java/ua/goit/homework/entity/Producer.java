package ua.goit.homework.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "producer")
public class Producer implements BaseEntity<UUID> {

    @Id
    @Column(name = "id")
    private UUID id;

    @NotBlank
    @Size(min=2, max=100, message = "Name must be in range of 2-100 symbols")
    @Column(name = "name", nullable = false, unique = true, length = 100)
    private String name;

    @OneToMany(mappedBy="producer", fetch = FetchType.LAZY, cascade= CascadeType.ALL)
    private Set<Product> products;
}
