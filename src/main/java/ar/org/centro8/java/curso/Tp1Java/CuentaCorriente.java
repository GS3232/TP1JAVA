package ar.org.centro8.java.curso.Tp1Java;

public class CuentaCorriente extends Cuenta {

    private double montoDescubierto;

    public CuentaCorriente(
            int numCuenta,
            Cliente cliente,
            double montoDescubierto) {

        super(numCuenta, cliente);
        this.montoDescubierto = montoDescubierto;
    }

    public double getMontoDescubierto() {
        return montoDescubierto;
    }

    public void setMontoDescubierto(double montoDescubierto) {
        this.montoDescubierto = montoDescubierto;
    }

    @Override
    public void debitarEfectivo(double monto) {

        if (monto <= 0) {
            throw new IllegalArgumentException(
                    "El monto a debitar debe ser mayor que cero.");
        }

        if (monto > getSaldo() + montoDescubierto) {
            throw new IllegalArgumentException(
                    "El monto supera el saldo y el descubierto autorizado.");
        }

        modificarSaldo(-monto);
    }

    public void depositarCheque(Cheque cheque) {

        if (cheque == null) {
            throw new IllegalArgumentException(
                    "El cheque no puede ser nulo.");
        }

        if (cheque.getMonto() <= 0) {
            throw new IllegalArgumentException(
                    "El monto del cheque debe ser mayor que cero.");
        }

        modificarSaldo(cheque.getMonto());
    }

    @Override
    public String toString() {
        return "CuentaCorriente{" +
                "montoDescubierto=" + montoDescubierto +
                ", saldo=" + getSaldo() +
                '}';
    }
}