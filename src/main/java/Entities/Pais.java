package Entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
@EqualsAndHashCode(exclude = "provincias")
public class Pais extends Base {
	private String nombre;
	//@OneToMany(mappedBy = "pais", cascade = CascadeType.ALL, orphanRemoval = true)
	@Builder.Default
	private Set<Provincia> provincias = new HashSet<>();;

	// Metodo

	public void agregarProvincia(Provincia provincia) {
		provincias.add(provincia);
	}

	public void removerProvincia(Provincia provincia) {
		provincias.remove(provincia);
	}

}
