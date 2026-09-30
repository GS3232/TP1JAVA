package ar.org.centro8.java.curso.Tp1Java.Entidades;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// Representa una cuenta corriente.
// Hereda las características básicas de Cuenta.
@Getter
@Setter
@ToString(callSuper = true)
public class CuentaCorriente extends Cuenta {

    // Monto máximo que el cliente puede utilizar
    // cuando no tiene saldo suficiente.
    private double montoDescubierto;

    // Constructor: se usa para crear una cuenta corriente
    // con su número, cliente y monto de descubierto.
    public CuentaCorriente(
            int numCuenta,
            Cliente cliente,
            double montoDescubierto) {

        // Llama al constructor de Cuenta
        // para inicializar los datos heredados.
        super(numCuenta, cliente);

        // Guardo el monto de descubierto autorizado.
        this.montoDescubierto = montoDescubierto;
    }

    // Modifico la forma de retirar dinero porque
    // una cuenta corriente permite usar el descubierto.
    @Override
    public void debitarEfectivo(double monto) {

        // El monto a retirar tiene que ser positivo.
        if (monto <= 0) {
            throw new IllegalArgumentException(
                    "El monto a debitar debe ser mayor que cero.");
        }

        // Verifico que el retiro no supere
        // el saldo más el descubierto autorizado.
        if (monto > getSaldo() + montoDescubierto) {
            throw new IllegalArgumentException(
                    "El monto supera el saldo y el descubierto autorizado.");
        }

        // Resto el monto retirado al saldo.
        modificarSaldo(-monto);
    }

    // Permite depositar un cheque en la cuenta corriente.
    public void depositarCheque(Cheque cheque) {

        // Primero verifico que el cheque exista.
        if (cheque == null) {
            throw new IllegalArgumentException(
                    "El cheque no puede ser nulo.");
        }

        // Verifico que el monto del cheque sea válido.
        if (cheque.getMonto() <= 0) {
            throw new IllegalArgumentException(
                    "El monto del cheque debe ser mayor que cero.");
        }

        // Sumo el monto del cheque al saldo.
        modificarSaldo(cheque.getMonto());
    }

    // Lombok genera los getters, setters y el toString.
}