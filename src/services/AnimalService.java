package services;

import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import dao.AnimalDAO;
import dao.IAnimalDAO;
import dao.Prueba;
import domain.Animal;
import domain.Categoria;
import domain.Descripcion;

public class AnimalService implements IAnimalService {
	
	private IAnimalDAO AnimalDAO = new AnimalDAO();
	
	@Override // Listado
	public ArrayList<Animal> listarAnimalesByCategoria(String categoria) {
		ArrayList<Animal> busqueda = new ArrayList<Animal>();
		try {
			switch (Categoria.valueOf(categoria)) {
				case RESERVADO:
					busqueda.addAll(AnimalDAO.listarAnimalesByCategoria(Categoria.valueOf(categoria)));
					break;
				case DISPONIBLE:
					System.out.println("---  AnimalServidce: categroai DISPONIBLE");
					busqueda.addAll(AnimalDAO.listarAnimalesByCategoria(Categoria.valueOf(categoria)));
				case INVISIBLE:
					busqueda.addAll(AnimalDAO.listarAnimalesByCategoria(Categoria.valueOf(categoria)));
				case URGENTE:
					busqueda.addAll(AnimalDAO.listarAnimalesByCategoria(Categoria.valueOf(categoria)));
					break;
				default:
					busqueda.addAll(AnimalDAO.listarAnimalesByCategoria(Categoria.valueOf(categoria)));
					break;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return busqueda;
//		return Prueba.getColeccion();
	}
	

	@Override //Detalle
	public Animal listarAnimalByID(int id) {
		ArrayList<Animal> busqueda = new ArrayList<Animal>();
		try {
			busqueda = AnimalDAO.listarAnimalByID(id);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return busqueda.get(0);
			
	}
	
	@Override // Buscador
	public ArrayList<Animal> listarAnimalesByPalabra(String palabra) {
		ArrayList<Animal> busqueda = new ArrayList<Animal>();
		try {
			busqueda = AnimalDAO.listarAnimalesByPalabra(palabra);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return busqueda;
			
	}

	public boolean anadirAnimal(String[] entrada) throws ClassNotFoundException, SQLException {
		Animal nuevo = new Animal(entrada[0], new Descripcion(entrada[1], entrada[2]), Time.valueOf(entrada[3]), Categoria.valueOf(entrada[4]));
		return AnimalDAO.anadirAnimal(nuevo);
	}
	public boolean editarAnimal(String[] entrada) throws ClassNotFoundException, SQLException {
		Animal nuevo = new Animal(entrada[0], new Descripcion(entrada[1], entrada[2]), Time.valueOf(entrada[3]), Categoria.valueOf(entrada[4]));
		return AnimalDAO.editarAnimal(nuevo);
	}
	public boolean eliminarAnimal(String[] entrada) throws ClassNotFoundException, SQLException {
		Animal nuevo = new Animal(entrada[0], new Descripcion(entrada[1], entrada[2]), Time.valueOf(entrada[3]), Categoria.valueOf(entrada[4]));
		return AnimalDAO.eliminarAnimal(nuevo);
	}

}