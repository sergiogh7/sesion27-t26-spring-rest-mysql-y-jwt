package app.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Asigna entidad
@Entity
@Table(name="asignado_a")
public class AsignadoA {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "cientifico")
	Cientifico cientifico;
	
	@ManyToOne
	@JoinColumn(name = "proyecto")
	Proyecto proyecto;
	
//	Constructores
	public AsignadoA(){
		
	}

	public AsignadoA(int id, Cientifico cientifico, Proyecto proyecto) {
		this.id = id;
		this.cientifico = cientifico;
		this.proyecto = proyecto;
		
	}
	
//	Metodos
	@Override
	public String toString() {
		return "AsignadoA: "+ 
				"\nid: " + id + 
				"\nCientifico: " + cientifico + 
				"\nProyecto: " + proyecto;
	
	}

//	Getters setters
	public int getId() {
		return id;
		
	}
	
	public void setId(int id) {
		this.id = id;
		
	}
	
	public Cientifico getCientifico() {
		return cientifico;
		
	}
	
	public void setCientifico(Cientifico cientifico) {
		this.cientifico = cientifico;
		
	}
	
	public Proyecto getProyecto() {
		return proyecto;
		
	}
	
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
		
	}

}