package cl.usm.certamen1hdd.Services;

import cl.usm.certamen1hdd.Entities.Libro;
import cl.usm.certamen1hdd.Repositories.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibrosServiceImpl implements LibrosService{
    @Autowired
    LibrosRepository librosRepository;

    @Override
    public Libro crearLibro(Libro libro) {
        try{
            return this.librosRepository.save(libro);
        }catch (Exception exception){
            return null;
        }
    }

    @Override
    public List<Libro> getAll() {
        return this.librosRepository.findAll();
    }

    @Override
    public List<Libro> findByAutor(String autor) {
        return this.librosRepository.findByAutor(autor);
    }

    @Override
    public List<Libro> filter(String search) {
        List<Libro> libros = this.getAll();
        List<Libro> filtrados = libros.stream()
                .filter(u->u.getTitulo().toLowerCase()
                        .contains(search.toLowerCase()) || u.getAutor()

                        .toLowerCase().contains(search.toLowerCase()))
                .collect(Collectors.toList());
        return filtrados;
    }
}
