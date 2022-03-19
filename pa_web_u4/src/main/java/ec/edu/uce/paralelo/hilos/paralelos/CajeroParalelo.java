package ec.edu.uce.paralelo.hilos.paralelos;

import java.util.List;

public class CajeroParalelo {

	private String nombre;
	private List<Integer> clientes;
	
	//set y get
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Integer> getClientes() {
		return clientes;
	}
	public void setClientes(List<Integer> clientes) {
		this.clientes = clientes;
	}
	
	
	public CajeroParalelo(String nombre, List<Integer> clientes) {
		super();
		this.nombre = nombre;
		this.clientes = clientes;
	}
	
	
	
}
