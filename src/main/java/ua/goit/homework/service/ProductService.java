package ua.goit.homework.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ua.goit.homework.entity.Product;
import java.util.UUID;

@Service
public class ProductService extends BaseService<Product, UUID> {

    public ProductService(CrudRepository<Product, UUID> repository) {
        super(repository);
    }

}

