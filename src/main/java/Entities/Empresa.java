package Entities;

import lombok.*;
import jakarta.persistence.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true, exclude = "sucursales")
public class Empresa extends Base {
	private String nombre;
	private String razonSocial;
	private int cuil;
	@Builder.Default
	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private Set<Sucursal> sucursales = new HashSet<>();

	// Métodos

	public void agregarSucursal(Sucursal sucursal) {
		sucursales.add(sucursal);
	}

	public void removerSucursal(Sucursal sucursal) {
		sucursales.remove(sucursal);
	}


}
