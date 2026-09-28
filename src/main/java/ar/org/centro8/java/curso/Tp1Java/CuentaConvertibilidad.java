package ar.org.centro8.java.curso.Tp1Java;

public class CuentaConvertibilidad extends CuentaCorriente {

    private double saldoDolares;

    public CuentaConvertibilidad(
            int numCuenta,
            ClienteEmpresa cliente,
            double montoDescubierto) {

        super(numCuenta, cliente, montoDescubierto);
        this.saldoDolares = 0.0;
    }

    public double getSaldoDolares() {
        return saldoDolares;
    }

    public void setSaldoDolares(double saldoDolares) {
        this.saldoDolares = saldoDolares;
    }

    public void depositarDolares(double monto) {

        if (monto <= 0) {
            throw new IllegalArgumentException(
                    "El monto a depositar debe ser mayor que cero.");
        }

        saldoDolares += monto;
    }

    public void debitarDolares(double monto) {

        if (monto <= 0) {
            throw new IllegalArgumentException(
                    "El monto a debitar debe ser mayor que cero.");
        }

        if (monto > saldoDolares) {
            throw new IllegalArgumentException(
                    "No hay dólares suficientes.");
        }

        saldoDolares -= monto;
    }

    public void convertirPesosADolares(
            double montoPesos,
            double tasaConversion) {

        if (montoPesos <= 0) {
            throw new IllegalArgumentException(
                    "El monto debe ser mayor que cero.");
        }

        if (tasaConversion <= 0) {
            throw new IllegalArgumentException(
                    "La tasa de conversión debe ser mayor que cero.");
        }

        if (montoPesos > getSaldo()) {
            throw new IllegalArgumentException(
                    "No hay pesos suficientes.");
        }

        double dolares = montoPesos / tasaConversion;

        modificarSaldo(-montoPesos);
        saldoDolares += dolares;
    }

    public void convertirDolaresAPesos(
            double montoDolares,
            double tasaConversion) {

        if (montoDolares <= 0) {
            throw new IllegalArgumentException(
                    "El monto debe ser mayor que cero.");
        }

        if (tasaConversion <= 0) {
            throw new IllegalArgumentException(
                    "La tasa de conversión debe ser mayor que cero.");
        }

        if (montoDolares > saldoDolares) {
            throw new IllegalArgumentException(
                    "No hay dólares suficientes.");
        }

        double pesos = montoDolares * tasaConversion;

        saldoDolares -= montoDolares;
        modificarSaldo(pesos);
    }

    @Override
    public String toString() {
        return "CuentaConvertibilidad{" +
                "saldoDolares=" + saldoDolares +
                ", saldoPesos=" + getSaldo() +
                '}';
    }
}