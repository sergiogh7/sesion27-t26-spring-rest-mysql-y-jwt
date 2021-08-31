package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.ICientificoDAO;
import app.dto.Cientifico;

@Service
public class CientificoService implements ICientificoService {

	@Autowired
	ICientificoDAO iCientificoDAO;
	
	@Override
	public List<Cientifico> listarCientificos() {
		return iCientificoDAO.findAll();
		
	}

	@Override
	public Cientifico guardarCientifico(Cientifico cientifico) {
		return iCientificoDAO.save(cientifico);
		
	}

	@Override
	public Cientifico cientificoXID(int id) {	 
		return iCientificoDAO.findById(id).get();
		
	}

	@Override
	public Cientifico actualizarCientifico(Cientifico cientifico) { 
		return iCientificoDAO.save(cientifico);
		
	}

	@Override
	public void eliminarCientifico(int id) {
		iCientificoDAO.deleteById(id);
		
	}
}