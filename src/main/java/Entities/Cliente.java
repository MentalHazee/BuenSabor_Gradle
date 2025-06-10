package Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(exclude = {"pedidos", "domicilios", "imagen", "usuario"})
public class Cliente extends Base {

	//Atributos
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;

	@Temporal(TemporalType.DATE)
	private LocalDate fechaNacimiento;
	@Builder.Default
	private Set<Pedido> pedidos = new HashSet<>();
	@Builder.Default
	private Set<Domicilio> domicilios = new HashSet<>();
	@ToString.Exclude
	private Imagen imagen;
	@ToString.Exclude
	private Usuario usuario;

	// Metodos

	public void agregarDomicilio(Domicilio domicilio) {
		domicilios.add(domicilio);
	}

	public void removerDomicilio(Domicilio domicilio) {
		domicilios.remove(domicilio);
	}

	public void agregarPedido(Pedido pedido) {
		pedidos.add(pedido);
	}

	public void removerPedido(Pedido pedido) {
		pedidos.remove(pedido);
	}


}
