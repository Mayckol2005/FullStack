package com.example.bibliotecaduoc.repository;

import com.example.bibliotecaduoc.model.Libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class LibroRepository {

    // Arreglo que guardara todos los libros
    private List<Libro> listaLibros = new ArrayList<>();

    // Agregar Libros
    public LibroRepository(){
        listaLibros.add(new Libro(1, "982982398239823", "Fuego y Sangre", "Penguin Random House Grupo Editorial", 2018, "George R R Martin"));
        listaLibros.add(new Libro(2, "9783161484100", "1984", "Secker & Warburg", 1949, "George Orwell"));
        listaLibros.add(new Libro(3, "9780439554930", "Harry Potter y la piedra filosofal", "Bloomsbury", 1997, "J.K. Rowling"));
        listaLibros.add(new Libro(4, "9780061120084", "Matar a un ruiseñor", "Harper Perennial", 1960, "Harper Lee"));
        listaLibros.add(new Libro(5, "9780307474278", "La chica del tren", "Riverhead Books", 2015, "Paula Hawkins"));
        listaLibros.add(new Libro(6, "9788498387087", "El nombre del viento", "Plaza & Janés", 2007, "Patrick Rothfuss"));
        listaLibros.add(new Libro(7, "9788420431838", "La sombra del viento", "Planeta", 2001, "Carlos Ruiz Zafón"));
        listaLibros.add(new Libro(8, "9788423353985", "Patria", "Tusquets Editores", 2016, "Fernando Aramburu"));
        listaLibros.add(new Libro(9, "9786070709332", "Cien años de soledad", "Sudamericana", 1967, "Gabriel García Márquez"));
        listaLibros.add(new Libro(10, "9788466341188", "El alquimista", "HarperCollins", 1988, "Paulo Coelho"));
    }

    // Metodo para obtener la cantidad total de libros
    public int totalLibros(){
        return listaLibros.size();
    }

    // Buscar un libro por su isbn y va a retornar la primera coincidencia
    public Optional<Libro> buscarPorIsbn(String isbn){
        return listaLibros.stream().filter(libro -> libro.getIsbn().equals(isbn)).findFirst();
    }

    // Metodo que cuenta los libros de un año especifico
    public List<Libro> contarPorAnio(int anio){
        return listaLibros.stream().filter(libro -> libro.getAnioPublicacion() == anio.count());
    }

    // Buscar todos los libro de un autor especifico
    public List<Libro> buscarPorAutor(String autor){
        return listaLibros.stream().filter(libro -> libro.getAutor().equalsIgnoreCase(autor).collect(Collectors.toList()));
    }

    // Encontrar el libro con menor año de publicacion y obtiene el minimo por año
    public Optional<Libro> libroMasAntiguo(){
        return listaLibros.stream().min(Comparator.comparingInt(Libro::getAnioPublicacion));
    }

    // Encontrar el libro con el año mas reciente
    public Optional<Libro> libroMasNuevo(){
        return listaLibros.stream().max(Comparator.comparingInt(Libro::getAnioPublicacion));
    }

    // Devolver la lista completa ordenada por año ascendente
    public List<Libro> libroMasReciente(){
        return listaLibros.stream().sorted(Comparator.comparingInt(Libro::getAnioPublicacion)).collect(Collectors.toList());
    }

    // Metodo que retorna todos los libros
    public List<Libro> obtenerLibros(){
        return listaLibros;
    }

    // Buscar libro por su id
    public Libro buscarPorId(int id){
        for (Libro libro: listaLibros){
            if (libro.getId() == id){
                return libro;
            }
        }
        return null;
    }

//    // Buscar un libro por su isbn
//    public Libro buscarPorIsbn(String isbn){
//        for (Libro libro: listaLibros){
//            if (libro.getIsbn().equals(isbn)){
//                return libro;
//            }
//        }
//        return null;
//    }

    public Libro guardar(Libro lib){
        listaLibros.add(lib);
        return lib;
    }

    public Libro actualizar(Libro lib){
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaLibros.size(); i++){
            if (listaLibros.get(i).getId() == lib.getId()){
                id = libgetId();
                idPosicion = i;
            }
        }

        Libro libro1 = new Libro();
        libro1.setId(id);
        libro1.setTitulo(lib.getTitulo());
        libro1.setAutor(lib.getAutor());
        libro1.setAnioPublicacion(lib.getAnioPublicacion());
        libro1.setEditorial(lib.getEditorial());
        libro1.setIsbn(lib.getIsbn());

        listaLibros.set(idPosicion, Libro1);
        return libro1;
    }

    public void eliminar(int id){
        Libro libro = buscarPorId(id);
        if (libro != null) {
            listaLibros.remove(libro);
        }
    }
}
