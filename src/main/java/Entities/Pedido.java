package Entities;

import Enums.Estado;
import Enums.FormaPago;
import Enums.TipoEnvio;
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
@EqualsAndHashCode(exclude = {"detallePedido", "domicilio", "sucursal", "factura"})
public class Pedido extends Base {
	@Temporal(TemporalType.TIME)
	private LocalTime horaEstimadaFinalizacion;
	private Double total;
	private Double totalCosto;
	private Estado estado;
	private TipoEnvio tipoEnvio;
	private FormaPago formaPago;
	@Temporal(TemporalType.DATE)
	private LocalDate fechaPedido;
	@Builder.Default
	private Set<DetallePedido> detallePedido = new HashSet<>();
	@ToString.Exclude
	private Domicilio domicilio;
	@ToString.Exclude
	private Sucursal sucursal;
	@ToString.Exclude
	private Factura factura;

	// Metodo

	public void agregarDetallePedido(DetallePedido detalle) {
		detallePedido.add(detalle);
	}

	public void removerDetallePedido(DetallePedido detalle) {
		detallePedido.remove(detalle);
	}

}
