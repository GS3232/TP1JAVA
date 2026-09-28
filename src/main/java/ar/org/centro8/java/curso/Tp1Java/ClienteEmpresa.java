package ar.org.centro8.java.curso.Tp1Java;

public class ClienteEmpresa extends Cliente {

    private String nombreFantasia;
    private String cuit;

    public ClienteEmpresa(
            int numero,
            String nombreFantasia,
            String cuit) {

        super(numero);
        this.nombreFantasia = nombreFantasia;
        this.cuit = cuit;
    }

    public String getNombreFantasia() {
        return nombreFantasia;
    }

    public String getCuit() {
        return cuit;
    }
}