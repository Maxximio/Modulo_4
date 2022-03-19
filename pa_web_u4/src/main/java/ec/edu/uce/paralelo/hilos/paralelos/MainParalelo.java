package ec.edu.uce.paralelo.hilos.paralelos;

import java.util.Arrays;

public class MainParalelo {

	public static void main(String[] args) {
long tiempoInicial=System.currentTimeMillis();
		
		CajeroParalelo cajero1=new CajeroParalelo("Edison",Arrays.asList(2,2,3,4,5));
		CajeroParalelo cajero2=new CajeroParalelo("Carlos",Arrays.asList(1,2,2,3));
		CajeroParalelo cajero3=new CajeroParalelo("Paulo",Arrays.asList(2,3,2,3,4));
		
		GestorAtencionParalelo gestor1=new GestorAtencionParalelo(cajero1,tiempoInicial);
		GestorAtencionParalelo gestor2=new GestorAtencionParalelo(cajero2,tiempoInicial);
		GestorAtencionParalelo gestor3=new GestorAtencionParalelo(cajero3,tiempoInicial);
		
		gestor1.start();//procesar ya se incluye
		gestor2.start();
		gestor3.start();
		
		long tiempoFinal=System.currentTimeMillis();
		
		long tiempoTranscurrido =(tiempoFinal-tiempoInicial)/100;
		System.out.println(tiempoTranscurrido+" seg");
	}

}
