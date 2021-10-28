package ua.goit.homework.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.goit.homework.entity.Producer;
import java.util.UUID;

@Repository
public interface ProducerRepository extends CrudRepository<Producer, UUID> {
}
