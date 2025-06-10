package Entities;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Usuario extends Base {
	private String auth0Id;
	private String username;
	@ToString.Exclude
	private Cliente cliente;

}
