package Entities;

import Enums.TipoPromocion;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(exclude = {"imagenes", "articulos"})
public class Promocion extends Base {
	private String denominacion;
	@Temporal(TemporalType.DATE)
	private LocalDate FechaDesde;
	@Temporal(TemporalType.DATE)
	private LocalDate FechaHasta;
	@Temporal(TemporalType.TIME)
	private LocalTime HoraDesde;
	@Temporal(TemporalType.TIME)
	private LocalTime HoraHasta;
	private String descripcionDescuento;
	private Double precioPromocional;
	private TipoPromocion tipoPromocion;
	@Builder.Default
	private Set<Imagen> imagenes = new HashSet<>();
	@Builder.Default
	private Set<Articulo> articulos = new HashSet<>();

	// Metodos

	public void agregarImagen(Imagen imagen) {
		imagenes.add(imagen);
	}

	public void removerImagen(Imagen imagen) {
		imagenes.remove(imagen);
	}

	public void agregarArticulo(Articulo articulo) {
		articulos.add(articulo);
	}

	public void removerArticulo(Articulo articulo) {
		articulos.remove(articulo);
	}

}
