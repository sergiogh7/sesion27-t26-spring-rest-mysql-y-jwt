package app.service;

import java.util.List;

import app.dto.Proyecto;

public interface IProyectoService {
	public List<Proyecto> listarProyectos();
	
	public Proyecto guardarProyecto(Proyecto proyecto);
	
	public Proyecto proyectoXID(int id);
	
	public Proyecto actualizarProyecto(Proyecto proyecto);
	
	public void eliminarProyecto(int id);
	
}