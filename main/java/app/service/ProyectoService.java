  
package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.IProyectoDAO;
import app.dto.Proyecto;

@Service
public class ProyectoService implements IProyectoService {

	@Autowired
	IProyectoDAO iProyectoDAO;
	@Override
	public List<Proyecto> listarProyectos() {
		return iProyectoDAO.findAll();
		
	}

	@Override
	public Proyecto guardarProyecto(Proyecto proyecto) {
		return iProyectoDAO.save(proyecto);
		
	}

	@Override
	public Proyecto proyectoXID(int id) {
		return iProyectoDAO.findById(id).get();
		
	}

	@Override
	public Proyecto actualizarProyecto(Proyecto proyecto) {
		return iProyectoDAO.save(proyecto);
		
	}

	@Override
	public void eliminarProyecto(int id) {
		iProyectoDAO.deleteById(id);
		
	}
}