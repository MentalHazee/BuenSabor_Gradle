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
@EqualsAndHashCode(exclude = "domicilios")
public class Localidad extends Base {
	private String nombre;
	@Builder.Default
	private Set<Domicilio> domicilios = new HashSet<>();

	// Metodos

	public void agregarDomicilio(Domicilio domicilio) {
		domicilios.add(domicilio);
	}

	public void removerDomicilio(Domicilio domicilio) {
		domicilios.remove(domicilio);
	}

	public void verDomicilios(){
		for (Domicilio domicilio : domicilios){
			System.out.println(domicilio);
		}
	}

}
