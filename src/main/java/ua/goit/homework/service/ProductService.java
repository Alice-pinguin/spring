package ua.goit.homework.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ua.goit.homework.entity.Product;

@Service
public class ProductService extends BaseService<Product, Long> {

    public ProductService(CrudRepository<Product, Long> repository) {
        super(repository);
    }

}

