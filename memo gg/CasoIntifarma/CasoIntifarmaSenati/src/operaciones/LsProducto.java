package operaciones;
import java.util.ArrayList;

import entidad.Producto;

public class LsProducto {
	
	private ArrayList<Producto> p = new ArrayList<Producto>();
	
	public LsProducto() {
		
	}
	
	public int tamanio() {
		return p.size();
	}
	
	public void adicionar(Producto pro) {
		p.add(pro);
	}
	
	public Producto obtenerProductoXindice(int indice) {
		return p.get(indice);
	}
	
	public Producto buscarProductoXcodigo(String codigo) {
		for(int i = 0; 1 < tamanio(); i++) {
			if(obtenerProductoXindice(i).getCodigo().equalsIgnoreCase(codigo)) {
				return obtenerProductoXindice(i);
			}
			
		}
		return null;
	}

}
