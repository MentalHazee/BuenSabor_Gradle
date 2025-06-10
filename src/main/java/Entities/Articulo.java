package Entities;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(exclude = {"unidad", "imagenes"})
public abstract class Articulo extends Base {
	protected String denominacion;
	protected Double precioVenta;
	@ToString.Exclude
	private UnidadMedida unidad;
	@Builder.Default
	private Set<Imagen> imagenes = new HashSet<>();

}
