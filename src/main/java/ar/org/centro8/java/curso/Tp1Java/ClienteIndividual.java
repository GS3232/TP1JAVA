package ar.org.centro8.java.curso.Tp1Java;

public class ClienteIndividual extends Cliente {

    private String nombre;
    private String apellido;
    private String dni;

    public ClienteIndividual(
            int numero,
            String nombre,
            String apellido,
            String dni) {

        super(numero);
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }
}