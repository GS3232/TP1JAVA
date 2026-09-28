package ar.org.centro8.java.curso.Tp1Java;

public class Cuenta {

    private int numCuenta;
    private Cliente cliente;
    private double saldo;

    public Cuenta(int numCuenta, Cliente cliente) {
        this.numCuenta = numCuenta;
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositarEfectivo(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException(
                    "El monto a depositar debe ser mayor que cero.");
        }

        saldo += monto;
    }

    public void debitarEfectivo(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException(
                    "El monto a debitar debe ser mayor que cero.");
        }

        if (monto > saldo) {
            throw new IllegalArgumentException(
                    "No hay saldo suficiente.");
        }

        saldo -= monto;
    }

    protected void modificarSaldo(double variacion) {
        saldo += variacion;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "numCuenta=" + numCuenta +
                ", cliente=" + cliente +
                ", saldo=" + saldo +
                '}';
    }
}