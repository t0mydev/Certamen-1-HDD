package cl.usm.certamen1hdd.Services;

import cl.usm.certamen1hdd.Entities.Libro;

import java.util.List;

public interface LibrosService {
    Libro crearLibro(Libro libro);
    List<Libro> getAll();
    List<Libro> findByAutor(String autor);
    List<Libro> filter(String search);
}
