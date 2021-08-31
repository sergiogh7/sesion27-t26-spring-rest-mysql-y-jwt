package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.IAsignadoaDAO;
import app.dto.AsignadoA;

@Service
public class AsignadoaService implements IAsignadoaService {

	@Autowired
	IAsignadoaDAO iAsignadoaDAO;
	
	@Override
	public List<AsignadoA> listarAsignadoA() {
		return iAsignadoaDAO.findAll();
		
	}

	@Override
	public AsignadoA guardarAsignadoA(AsignadoA asignadoA) {
		return iAsignadoaDAO.save(asignadoA);
		
	}

	@Override
	public AsignadoA asignadoAXID(int id) {
		return iAsignadoaDAO.findById(id).get();
		
	}

	@Override
	public AsignadoA actualizarAsignadoA(AsignadoA asignadoA) {
		return iAsignadoaDAO.save(asignadoA);
		
	}

	@Override
	public void eliminarAsignadoA(int id) {
		iAsignadoaDAO.deleteById(id);
		
	}
}