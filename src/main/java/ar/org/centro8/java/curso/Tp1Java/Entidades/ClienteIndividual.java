package ar.org.centro8.java.curso.Tp1Java.Entidades;

import lombok.Getter;

// Representa a un cliente que es una persona.
// Hereda el número de cliente de la clase Cliente.
@Getter
public class ClienteIndividual extends Cliente {

    // Datos propios del cliente individual.
    private String nombre;
    private String apellido;
    private String dni;

    // Constructor: se usa cuando creo un cliente individual
    // para cargar sus datos iniciales.
    public ClienteIndividual(
            int numero,
            String nombre,
            String apellido,
            String dni) {

        // Llama al constructor de la clase padre
        // para inicializar el número de cliente.
        super(numero);

        // Guardo en el objeto los datos que recibí.
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    // Lombok genera automáticamente los getters
    // de nombre, apellido y dni.
}