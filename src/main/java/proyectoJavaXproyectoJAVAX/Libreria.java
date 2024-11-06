package proyectoJavaXproyectoJAVAX;

import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class Libreria {
	private ArrayList<Libro> listaLibros;
	private String nombre;
	private String lugar;
	
	public Libreria() {
		
	}
	
	public Libreria(ArrayList<Libro> listaLibros, String nombre, String lugar) {
		super();
		this.listaLibros = listaLibros;
		this.nombre = nombre;
		this.lugar = lugar;
	}
	@XmlElement (name = "Libro")
	@XmlElementWrapper (name = "Listalibros")
	public ArrayList<Libro> getListaLibros() {
		return listaLibros;
	}
	public void setListaLibros(ArrayList<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

}
