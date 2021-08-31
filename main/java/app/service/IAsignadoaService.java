  package app.service;

import java.util.List;

import app.dto.AsignadoA;

public interface IAsignadoaService {
	public List<AsignadoA> listarAsignadoA();
	
	public AsignadoA guardarAsignadoA(AsignadoA asignadoA);
	
	public AsignadoA asignadoAXID(int id);
	
	public AsignadoA actualizarAsignadoA(AsignadoA asignadoA);
	
	public void eliminarAsignadoA(int id);
	
}