package Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.util.Objects;

@Data
@MappedSuperclass // Indica que esta clase no es una entidad por sí misma
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

public class Base {
	@Id // Marca 'id' como la clave primaria.
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

}
