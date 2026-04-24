package cl.usm.certamen1hdd.Repositories;

import cl.usm.certamen1hdd.Entities.Libro;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LibrosRepository extends MongoRepository<Libro,String> {
    List<Libro> findByAutor(String autor);
}
