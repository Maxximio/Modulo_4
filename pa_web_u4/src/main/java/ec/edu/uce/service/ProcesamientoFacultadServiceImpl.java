package ec.edu.uce.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ProcesamientoFacultadServiceImpl implements IProcesamientoFacultad{

	private static final Logger log=LoggerFactory.getLogger(ProcesamientoFacultadServiceImpl.class);
	
	@Override
	@Async
	public Integer calcularDeuda(String cedula,Integer valor) {
		log.info("Procesando :  ..."+cedula);
		
		try {
			TimeUnit.SECONDS.sleep(10);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		log.info("Finalizo:  ..."+cedula);
		return valor;
	}

	@Override
	@Async
	public CompletableFuture<Integer> calcularDeudaFuture(String cedula,Integer valor) {
		log.info("Procesando :  ..."+cedula);
		
		try {
			TimeUnit.SECONDS.sleep(10);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		log.info("Finalizo:  ..."+cedula);
		return CompletableFuture.completedFuture(valor);
	}
	
}
