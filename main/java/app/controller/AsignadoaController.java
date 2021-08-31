package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dto.AsignadoA;
import app.service.AsignadoaService;

@RestController
@RequestMapping("/api")
public class AsignadoaController {

	@Autowired
	AsignadoaService asignadoaService;
	
	@GetMapping("/asignadoA")
	public List<AsignadoA> listarAsignadoA(){
		return asignadoaService.listarAsignadoA();
		
	}
	
	@PostMapping("/asignadoA")
	public AsignadoA salvarAsignadoA(@RequestBody AsignadoA asignadoA) {
		return asignadoaService.guardarAsignadoA(asignadoA);
		
	}
	
	@GetMapping("/asignadoA/{id}")
	public AsignadoA asignadoAXID(@PathVariable(name="id") int id) {
		AsignadoA asignadoA_xid = new AsignadoA();
		
		asignadoA_xid = asignadoaService.asignadoAXID(id);
		
		return asignadoA_xid;
		
	}
	
	@PutMapping("/asignadoA/{id}")
	public AsignadoA actualizarAsignadoA(@PathVariable(name="id") int id, @RequestBody AsignadoA asignadoA) {
		AsignadoA asignadoaSeleccionado = new AsignadoA();
		
		AsignadoA asignadoaActualizado = new AsignadoA();
		
		asignadoaSeleccionado = asignadoaService.asignadoAXID(id);
		
		asignadoaSeleccionado.setCientifico(asignadoA.getCientifico());
		
		asignadoaSeleccionado.setProyecto(asignadoA.getProyecto());
		
		asignadoaActualizado = asignadoaService.actualizarAsignadoA(asignadoaSeleccionado);
		
		return asignadoaActualizado;
		
	}
	
	@DeleteMapping("/asignadoA/{id}")
	public void eliminarAsignadoA(@PathVariable(name="id") int id) {
		asignadoaService.eliminarAsignadoA(id);
		
	}
}