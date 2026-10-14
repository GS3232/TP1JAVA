package ar.org.centro8.java.curso.tp1java.entidades.clientes;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// Representa a un cliente que es uno.
// Hereda el número de cliente de la clase Cliente.
@Getter
@Setter
@ToString(callSuper = true)
public class ClienteIndividual extends Cliente {

    // Datos propios del cliente individual.
    private String nombre;
    private String apellido;
    private String dni;

    // Constructor para crear un cliente individual
    // con todos sus datos iniciales.
    public ClienteIndividual(
            int numero,
            String nombre,
            String apellido,
            String dni) {

        // Llama al constructor de Cliente
        // para guardar el número de cliente.
        super(numero);

        // Guarda los datos propios del cliente.
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }
}