package ua.goit.homework.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.goit.homework.entity.Producer;
import ua.goit.homework.repository.ProducerRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProducerService extends BaseService<Producer, UUID> {

    protected final ProducerRepository repository;

    public ProducerRepository getRepository() {
        return repository;
    }
}
