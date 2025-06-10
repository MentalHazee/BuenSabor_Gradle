package Entities;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(exclude = "detalles")
public class ArticuloInsumo extends Articulo {
	private Double precioCompra;
	private int stockActual;
	private int stockMaximo;
	private boolean esParaElaborar;
	@Builder.Default
	private Set<ArticuloManufacturadoDetalle> detalles = new HashSet<>();

	public void agregarDetalle(ArticuloManufacturadoDetalle detalle) {
		detalles.add(detalle);
	}

	public void removerDetalle(ArticuloManufacturadoDetalle detalle) {
		detalles.remove(detalle);
	}
}
