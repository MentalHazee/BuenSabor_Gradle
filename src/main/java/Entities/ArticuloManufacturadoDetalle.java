package Entities;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(exclude = "insumo")
public class ArticuloManufacturadoDetalle extends Base{
	private int cantidad;
	@ToString.Exclude
	private ArticuloInsumo insumo;

}
