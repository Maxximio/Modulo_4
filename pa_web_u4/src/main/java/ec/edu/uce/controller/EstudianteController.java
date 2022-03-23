package ec.edu.uce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ec.edu.uce.repository.modelo.Estudiante;
import ec.edu.uce.service.IEstudianteService;

@Controller
@RequestMapping("/etudiantes")
public class EstudianteController {
	
	@Autowired
	private IEstudianteService estuService;

	//@RequestMapping("/buscar/{idEstudiante}")
	//@RequestMapping(path = "/buscar/{idEstudiante}",method = RequestMethod.GET)
	@GetMapping("/buscar/{idEstudiante}")
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
	public String obtenerPaginaIngresoDatos() {
		return "estudianteNuevo";
		
	}
	
	@PostMapping("/insertar")
	public String insertarEstudiante(Estudiante estu,BindingResult result,Model model) {
		
		this.estuService.InsertarService(estu);
		
		return "lista";
		
	}
	
}
