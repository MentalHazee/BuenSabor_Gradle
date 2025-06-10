package Entities;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(exclude = "localidad")
public class Domicilio extends Base {
	private String calle;
	private int numero;
	private int cp;
	@ToString.Exclude
	private Localidad localidad;

}
