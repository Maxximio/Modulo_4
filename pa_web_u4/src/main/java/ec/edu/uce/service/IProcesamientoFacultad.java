package ec.edu.uce.service;

import java.util.concurrent.CompletableFuture;

public interface IProcesamientoFacultad {

	Integer calcularDeuda(String cedula, Integer valor);

	CompletableFuture<Integer> calcularDeudaFuture(String cedula, Integer valor);
	
}
