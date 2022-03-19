package ec.edu.uce.paralelo.hilos.paralelos;

import java.util.concurrent.TimeUnit;

public class GestorAtencionParalelo extends Thread{
	
	private CajeroParalelo cajero;
	
	private long tiempoInicial;
	
	public GestorAtencionParalelo(CajeroParalelo cajero, long tiempoInicial) {
		super();
		this.cajero = cajero;
		this.tiempoInicial = tiempoInicial;
	}

	@Override
	public void run() {
		this.procesar(this.cajero, this.tiempoInicial);
	}
	
	public void procesar(CajeroParalelo cajeroParalelo,long tiempoInicial) {
		System.out.println("Inicia atender Cajero"+cajeroParalelo.getNombre());
		for (Integer tiempo: cajeroParalelo.getClientes()) {
			this.atenderCliente(tiempo);			
		}
		System.out.println("Finaliza atender cajero: "+cajeroParalelo.getNombre());
		long tiempoTranscurrido =(System.currentTimeMillis()-tiempoInicial)/1000;
		System.out.println(tiempoTranscurrido+" seg de atencion por: "+cajeroParalelo.getNombre());
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
