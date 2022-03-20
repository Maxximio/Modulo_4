package ec.edu.uce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.service.IProcesamientoFacultad;

@SpringBootApplication
public class PaWebU4Application implements CommandLineRunner{

	private static final Logger log=LoggerFactory.getLogger(PaWebU4Application.class);
	
	@Autowired
	private IProcesamientoFacultad proFaService;
	
	public static void main(String[] args) {
		SpringApplication.run(PaWebU4Application.class, args);
	}
	
	@Override
	public void run(String... args)throws Exception{
		
		long inicio=System.currentTimeMillis();
		
		Integer valor1=this.proFaService.calcularDeuda("1234", 4);
		Integer valor2=this.proFaService.calcularDeuda("4321", 4);
		Integer valor3=this.proFaService.calcularDeuda("2345", 4);
		Integer valor4=this.proFaService.calcularDeuda("5432", 4);
		
		log.info("Total: "+(valor1+valor2+valor3+valor4));
		long tFinal=System.currentTimeMillis();
		long tiempoT=(inicio-tFinal)/1000;
		log.info(tiempoT+" seg");
	}
	

}
