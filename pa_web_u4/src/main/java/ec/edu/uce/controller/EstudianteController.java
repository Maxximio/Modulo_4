package ec.edu.uce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ec.edu.uce.repository.modelo.Estudiante;
import ec.edu.uce.service.IEstudianteService;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {
	
	@Autowired
	private IEstudianteService estuService;

	//@RequestMapping("/buscar/{idEstudiante}")
	@GetMapping("/buscar/{idEstudiante}")
	//@RequestMapping(path = "/buscar/{idEstudiante}",method = RequestMethod.GET)
	public String obtenerUsuario(@PathVariable("idEstudiante")Integer idEstudiante, Model modelo) {
		
		Estudiante estu=this.estuService.buscarService(idEstudiante);
		
//		Estudiante estu=new Estudiante();
//		estu.setId(idEstudiante);
//		estu.setNombre("Carlos");
//		estu.setApellido("Montalvo");
		
		modelo.addAttribute("estudi",estu);
		return "estudiente";
		
	}
	
	@GetMapping("/buscar/todos")
	public String buscarTodos(Model modelo) {
		List<Estudiante> listaEstudiantes=this.estuService.buscarTodosService();
		
		modelo.addAttribute("estudiantes", listaEstudiantes);
		
		return "lista";
		
	}
	
	@GetMapping("/estudianteNuevo")
	public String obtenerPaginaIngresoDatos(Estudiante estudiante) {
		return "estudianteNuevo";
		
	}
	
	@PostMapping("/insertar")
	public String insertarEstudiante(Estudiante estudiante,BindingResult result,Model modelo,
			RedirectAttributes redirectAtr) {
		
		this.estuService.InsertarService(estudiante);
		//redirectAtr.addFlashAttribute("mensaje","Estudiante Guardado");
		return "redirect:buscar/todos";
		
	}
	
	@GetMapping("/actualiza/{idEstudiante}")
	public String obtenerPaginaActualizar(@PathVariable("idEstudiante")Integer idEstudiante,Estudiante estudiante,Model modelo) {
		Estudiante estu=this.estuService.buscarService(idEstudiante);
		
		modelo.addAttribute("estudiante",estu); 
		return "actualizarEstudiante";
	}
	
	@PutMapping("/actualizar/{idEstudiante}")
	public String actualizarEstudiante(@PathVariable ("idEstudiante")Integer idEstudiante,Estudiante estudiante,Model modelo) {
		estudiante.setId(idEstudiante);
		this.estuService.actualizarService(estudiante);
		return "index";
	}
	
	@DeleteMapping("borrar/{idEstudiante}")
	public String eliminarEstudiante(@PathVariable("idEstudiante")Integer idEstudiante,Model modelo) {
		this.estuService.BorrarService(idEstudiante);
		List<Estudiante> listaEstudiantes=this.estuService.buscarTodosService();
		
		modelo.addAttribute("estudiantes", listaEstudiantes);
		
		return "lista";
	}
	
}
