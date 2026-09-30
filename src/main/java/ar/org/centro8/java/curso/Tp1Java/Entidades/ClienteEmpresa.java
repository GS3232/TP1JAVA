package ar.org.centro8.java.curso.Tp1Java.Entidades;

import lombok.Getter;

// Representa a un cliente que es una empresa.
// Hereda el número de cliente de la clase Cliente.
@Getter
public class ClienteEmpresa extends Cliente {

    // Datos propios del cliente empresa.
    private String nombreFantasia;
    private String cuit;

    // Constructor: se usa para crear una empresa
    // con sus datos iniciales.
    public ClienteEmpresa(
            int numero,
            String nombreFantasia,
            String cuit) {

        // Llama al constructor de Cliente
        // para inicializar el número de cliente.
        super(numero);

        // Guardo los datos recibidos en los atributos del objeto.
        this.nombreFantasia = nombreFantasia;
        this.cuit = cuit;
    }

    // Lombok genera automáticamente los getters
    // de nombreFantasia y cuit.
}