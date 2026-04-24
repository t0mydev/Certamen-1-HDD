package cl.usm.certamen1hdd.Entities;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection ="libros")
public class Libro implements Serializable {
    @NotBlank(message = "El titulo es obligatorio")
    private String titulo;
    @NotBlank(message = "El autor es obligatorio")
    private String autor;
    @NotBlank(message = "ISBN es obligatorio")
    @Size(min = 13,max = 13, message = "ISBN debe ser de 13 caracteres")
    @Id
    private String ISBN;
    @Min(value= 10,message = "El libro debe tener 10 o más paginas")
    private Integer paginas;
    @NotBlank(message = "La categoria es obligatoria")
    private String categoria;

}
