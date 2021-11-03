package ua.goit.homework.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import ua.goit.homework.entity.Manufacturer;
import java.util.UUID;

@Service
public class ManufacturerService extends BaseService<Manufacturer, Long> {

    public ManufacturerService(CrudRepository<Manufacturer, Long> repository) {
        super(repository);
    }
}
