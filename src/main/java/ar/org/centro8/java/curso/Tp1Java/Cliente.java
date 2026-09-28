package ar.org.centro8.java.curso.Tp1Java;

public abstract class Cliente {

    private int numero;

    public Cliente(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
}