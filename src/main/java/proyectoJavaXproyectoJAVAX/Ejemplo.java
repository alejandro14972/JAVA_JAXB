package proyectoJavaXproyectoJAVAX;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;



public class Ejemplo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		crearFichero();
		leerFichero();
	}

	private static void crearFichero() {
		Libro libro = new Libro("datos", "jandro", "Teide", "1234");
		Libro libro2 = new Libro("PHP", "Victor", "Anaya", "1254");
		ArrayList<Libro> listaLibros = new ArrayList<Libro>();
		listaLibros.add(libro);
		listaLibros.add(libro2);

		Libreria milibreria = new Libreria(listaLibros, "Mi libreria", "Oviedo");
		try {
			JAXBContext context = JAXBContext.newInstance(Libreria.class);
			Marshaller m = context.createMarshaller();
			m.marshal(milibreria, System.out);
			m.marshal(milibreria, new File("ficheroXMLlIBROS.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static void leerFichero() {
		ArrayList<Libro> listaLibros = new ArrayList<Libro>();
		
		try {
			JAXBContext context = JAXBContext.newInstance(Libreria.class);
			Unmarshaller um = context.createUnmarshaller();
			
			try {
				Libreria libreria = (Libreria)um.unmarshal(new FileReader(new File("ficheroXMLlIBROS.xml")));
				listaLibros = libreria.getListaLibros();
				
				for (int i = 0; i < listaLibros.size(); i++) {
					Libro l = listaLibros.get(i);
					System.out.println(l.toString());
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
