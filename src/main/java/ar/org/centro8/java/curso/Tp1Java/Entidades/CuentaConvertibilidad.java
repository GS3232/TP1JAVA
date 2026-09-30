package ar.org.centro8.java.curso.Tp1Java.Entidades;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// Representa una cuenta que puede trabajar con pesos y dólares.
// Hereda todo lo que puede hacer una CuentaCorriente.
@Getter
@Setter
@ToString(callSuper = true)
public class CuentaConvertibilidad extends CuentaCorriente {

    // Saldo que la cuenta tiene disponible en dólares.
    private double saldoDolares;

    // Constructor: se usa para crear una cuenta de convertibilidad.
    public CuentaConvertibilidad(
            int numCuenta,
            ClienteEmpresa cliente,
            double montoDescubierto) {

        // Llama al constructor de CuentaCorriente
        // para inicializar los datos heredados.
        super(numCuenta, cliente, montoDescubierto);

        // La cuenta comienza sin dólares.
        this.saldoDolares = 0.0;
    }

    // Permite depositar dólares en la cuenta.
    public void depositarDolares(double monto) {

        // El monto tiene que ser positivo.
        if (monto <= 0) {
            throw new IllegalArgumentException(
                    "El monto a depositar debe ser mayor que cero.");
        }

        // Sumo los dólares al saldo en dólares.
        saldoDolares += monto;
    }

    // Permite retirar dólares de la cuenta.
    public void debitarDolares(double monto) {

        // El monto tiene que ser positivo.
        if (monto <= 0) {
            throw new IllegalArgumentException(
                    "El monto a debitar debe ser mayor que cero.");
        }

        // Para dólares no se permite utilizar descubierto.
        if (monto > saldoDolares) {
            throw new IllegalArgumentException(
                    "No hay dólares suficientes.");
        }

        // Resto los dólares retirados.
        saldoDolares -= monto;
    }

    // Convierte pesos a dólares.
    public void convertirPesosADolares(
            double montoPesos,
            double tasaConversion) {

        // El monto tiene que ser positivo.
        if (montoPesos <= 0) {
            throw new IllegalArgumentException(
                    "El monto debe ser mayor que cero.");
        }

        // La tasa de conversión debe ser válida.
        if (tasaConversion <= 0) {
            throw new IllegalArgumentException(
                    "La tasa de conversión debe ser mayor que cero.");
        }

        // Verifico que haya suficientes pesos.
        if (montoPesos > getSaldo()) {
            throw new IllegalArgumentException(
                    "No hay pesos suficientes.");
        }

        // Calculo cuántos dólares corresponden
        // según la tasa de conversión.
        double dolares = montoPesos / tasaConversion;

        // Resto los pesos utilizados.
        modificarSaldo(-montoPesos);

        // Agrego los dólares obtenidos.
        saldoDolares += dolares;
    }

    // Convierte dólares a pesos.
    public void convertirDolaresAPesos(
            double montoDolares,
            double tasaConversion) {

        // El monto tiene que ser positivo.
        if (montoDolares <= 0) {
            throw new IllegalArgumentException(
                    "El monto debe ser mayor que cero.");
        }

        // La tasa de conversión debe ser válida.
        if (tasaConversion <= 0) {
            throw new IllegalArgumentException(
                    "La tasa de conversión debe ser mayor que cero.");
        }

        // Verifico que haya suficientes dólares.
        if (montoDolares > saldoDolares) {
            throw new IllegalArgumentException(
                    "No hay dólares suficientes.");
        }

        // Calculo cuántos pesos corresponden
        // según la tasa de conversión.
        double pesos = montoDolares * tasaConversion;

        // Resto los dólares utilizados.
        saldoDolares -= montoDolares;

        // Agrego los pesos obtenidos.
        modificarSaldo(pesos);
    }

    // Lombok genera los getters, setters y el toString.
}