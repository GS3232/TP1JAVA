package ar.org.centro8.java.curso.Tp1Java;

public class CajaAhorro extends Cuenta {

    private double tasaInteres;

    public CajaAhorro(
            int numCuenta,
            Cliente cliente,
            double tasaInteres) {

        super(numCuenta, cliente);
        this.tasaInteres = tasaInteres;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public void cobrarInteres() {
        double interes = getSaldo() * tasaInteres;
        modificarSaldo(interes);
    }

    @Override
    public String toString() {
        return "CajaAhorro{" +
                "tasaInteres=" + tasaInteres +
                ", saldo=" + getSaldo() +
                '}';
    }
}