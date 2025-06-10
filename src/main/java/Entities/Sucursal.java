package Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sucursal")
@SuperBuilder
@EqualsAndHashCode(exclude = {"promociones", "domicilio", "categorias", "pedidos"})
public class Sucursal extends Base {
	private String nombre;
	@Temporal(TemporalType.TIME)
	private LocalTime horarioApertura;
	@Temporal(TemporalType.TIME)
	private LocalTime horarioCierre;
	@ToString.Exclude
	private Domicilio domicilio;
	@Builder.Default
	private Set<Promocion> promociones = new HashSet<>();
	@Builder.Default
	private Set<Categoria> categorias = new HashSet<>();
	@Builder.Default
	private Set<Pedido> pedidos = new HashSet<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;

	// Metodos


	public void agregarPromocion(Promocion promocion) {
		promociones.add(promocion);
	}

	public void removerPromocion(Promocion promocion) {
		promociones.remove(promocion);
	}

	public void agregarPedido(Pedido pedido) {
		pedidos.add(pedido);
	}

	public void removerPedido(Pedido pedido) {
		pedidos.remove(pedido);
	}

	public void agregarCategoria(Categoria categoria) {
		categorias.add(categoria);
	}

	public void removerCategoria(Categoria categoria) {
		categorias.remove(categoria);
	}

}
