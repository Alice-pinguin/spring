package ua.goit.homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.goit.homework.entity.Product;
import ua.goit.homework.repository.ProductRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService extends BaseService<Product, UUID> {

    protected final ProductRepository repository;

    public ProductRepository getRepository() {
        return repository;
    }
}
