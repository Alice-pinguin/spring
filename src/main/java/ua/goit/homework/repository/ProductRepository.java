package ua.goit.homework.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.goit.homework.entity.Product;
import java.util.UUID;

@Repository
public interface ProductRepository extends CrudRepository<Product, UUID> {
}
