package ar.org.centro8.java.curso.tp1java.entidades.clientes;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// Representa a un cliente que es una empresa.
// Hereda el número de cliente de la clase Cliente.
@Getter
@Setter
@ToString(callSuper = true)
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
        // para guardar el número de cliente.
        super(numero);

        // Guarda los datos propios de la empresa.
        this.nombreFantasia = nombreFantasia;
        this.cuit = cuit;
    }
}
