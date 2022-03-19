package ec.edu.uce.paralelo.hilos;

import java.util.concurrent.TimeUnit;

public class GestorAtencion {

	public void procesar(Cajero cajero,long tiempoInicial) {
		System.out.println("Inicia atender Cajero"+cajero.getNombre());
		for (Integer tiempo: cajero.getClientes()) {
			this.atenderCliente(tiempo);			
		}
		System.out.println("Finaliza atender cajero: "+cajero.getNombre());
		long tiempoTranscurrido =(System.currentTimeMillis()-tiempoInicial)/100;
		System.out.println(tiempoTranscurrido+" seg de atencion por: "+cajero.getNombre());
	}
			
		private void atenderCliente(Integer tiempo) {
			System.out.println("Atendiendo a cliente: "+tiempo);
			System.out.println("Hilo "+ Thread.currentThread().getName());
			try {
				TimeUnit.SECONDS.sleep(tiempo);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	
}
