package Entities;

import Enums.FormaPago;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(exclude = "pedido")
public class Factura extends Base {
	@Temporal(TemporalType.DATE)
	private LocalDate fechaFacturacion;
	private int mpPaymentId;
	private int mpMerchantOrderId;
	private String mpPreferenceId;
	private String mpPaymentType;
	private FormaPago formaPago;
	private double totalVenta;
	@ToString.Exclude
	private Pedido pedido;
}
