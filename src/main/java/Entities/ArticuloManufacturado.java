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
@EqualsAndHashCode(exclude = "detalles")
public class ArticuloManufacturado extends Articulo {
	private String descripcion;
	private int tiempoEstimadoMinutos;
	private String preparacion;
	@Builder.Default
	private Set<ArticuloManufacturadoDetalle> detalles = new HashSet<>();

	// Metodos

	public void agregarDetalle(ArticuloManufacturadoDetalle detalle) {
		detalles.add(detalle);
	}

	public void removerDetalle(ArticuloManufacturadoDetalle detalle) {
		detalles.remove(detalle);
	}

}
