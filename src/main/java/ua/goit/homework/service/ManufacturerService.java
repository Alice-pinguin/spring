package ua.goit.homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.goit.homework.entity.Manufacturer;
import ua.goit.homework.repository.ManufacturerRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ManufacturerService extends BaseService<Manufacturer, UUID> {

    protected final ManufacturerRepository repository;

    public ManufacturerRepository getRepository() {
        return repository;
    }
}
