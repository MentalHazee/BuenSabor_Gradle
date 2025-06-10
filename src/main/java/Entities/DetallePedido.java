package Entities;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(exclude = "articulo")
public class DetallePedido extends Base {
	private int cantidad;
	private double subTotal;
	@ToString.Exclude
	private Articulo articulo;

}
