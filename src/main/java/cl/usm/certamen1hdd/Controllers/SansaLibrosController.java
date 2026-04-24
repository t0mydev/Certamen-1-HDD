package cl.usm.certamen1hdd.Controllers;

import cl.usm.certamen1hdd.Entities.Libro;
import cl.usm.certamen1hdd.Services.LibrosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SansaLibrosController {
    @Autowired
    private LibrosService librosService;

    @GetMapping("/libros")
    public ResponseEntity<List<Libro>> getAll(@RequestParam(required = false) String search ){
        try{
            if(search != null && !search.isEmpty()){
                List<Libro> filtrados = this.librosService.filter(search);
                return ResponseEntity.ok(filtrados);
            }
            List<Libro> libros = this.librosService.getAll();
            return ResponseEntity.ok(libros);
        }catch(Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }
    @PostMapping("crearLibro")
    public ResponseEntity<?> createLibro(@RequestBody @Valid Libro libro){
        Libro resultado=this.librosService.crearLibro(libro);
        if (resultado != null){
            return ResponseEntity.ok(resultado);
        } return ResponseEntity.internalServerError().build();
    }
    @GetMapping("/libros/{autor}")
    public ResponseEntity<List<Libro>> findByAutor(@PathVariable String autor){
        try{
            List<Libro> libros = this.librosService.findByAutor(autor);
            if (libros.isEmpty()){
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(libros);
        }catch(Exception exception){
            exception.printStackTrace(); //me ta fallando xd
            return ResponseEntity.internalServerError().build();
        }
    }
}
