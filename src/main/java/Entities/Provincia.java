package Entities;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(exclude = "localidades")
public class Provincia extends Base {
	private String nombre;
	@Builder.Default
	private Set<Localidad> localidades = new HashSet<>();

	// Metodos

	public void agregarLocalidad(Localidad localidad) {
		localidades.add(localidad);
	}

	public void removerLocalidad(Localidad localidad) {
		localidades.remove(localidad);
	}

}
