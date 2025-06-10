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
@Getter
@Setter
@EqualsAndHashCode(exclude = {"subCategorias", "articulos"})
public class Categoria extends Base {
	private String denominacion;
	@Builder.Default
	private Set<Categoria> subCategorias = new HashSet<>();
	@Builder.Default
	private Set<Articulo> articulos = new HashSet<>();

	// Metodos

	public void agregarSubCategoria(Categoria sub) {
		subCategorias.add(sub);
	}

	public void removerSubCategoria(Categoria sub) {
		subCategorias.remove(sub);
	}

	public void agregarArticulo(Articulo articulo) {
		articulos.add(articulo);
	}

	public void removerArticulo(Articulo articulo) {
		articulos.remove(articulo);
	}

}
