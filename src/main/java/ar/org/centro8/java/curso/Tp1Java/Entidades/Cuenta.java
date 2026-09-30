package ar.org.centro8.java.curso.Tp1Java.Entidades;

import lombok.Getter;
import lombok.Setter;

// Es la clase base de las cuentas.
// Las cuentas específicas como CajaAhorro y CuentaCorriente heredan de ella.
@Getter
@Setter
public class Cuenta {

    // Número que identifica la cuenta.
    private int numCuenta;

    // Cliente que está asociado a la cuenta.
    private Cliente cliente;

    // Saldo actual de la cuenta.
    private double saldo;

    // Constructor: se usa para crear una cuenta
    // con su número y su cliente.
    public Cuenta(int numCuenta, Cliente cliente) {

        // Guardo los datos recibidos en los atributos.
        this.numCuenta = numCuenta;
        this.cliente = cliente;

        // Toda cuenta comienza con saldo cero.
        this.saldo = 0.0;
    }

    // Permite depositar dinero en la cuenta.
    public void depositarEfectivo(double monto) {

        // No permito depositar cero o un valor negativo.
        if (monto <= 0) {
            throw new IllegalArgumentException(
                    "El monto a depositar debe ser mayor que cero.");
        }

        saldo += monto;
    }

    // Permite retirar dinero de la cuenta.
    public void debitarEfectivo(double monto) {

        // El monto a retirar debe ser positivo.
        if (monto <= 0) {
            throw new IllegalArgumentException(
                    "El monto a debitar debe ser mayor que cero.");
        }

        // En una cuenta común no se puede retirar
        // más dinero del saldo disponible. 
        // Si el monto es menor o igual a cero, entonces lanzo un error
        // Uso if para validar las condiciones de las operaciones. Por ejemplo, verifico 
        // que el monto sea positivo y que haya saldo suficiente antes de realizar una extracción
        if (monto > saldo) {
            throw new IllegalArgumentException(
                    "No hay saldo suficiente.");
        }

        saldo -= monto;
    }

    // Lo usan las clases hijas cuando necesitan
    // modificar el saldo directamente.
    protected void modificarSaldo(double variacion) {
        saldo += variacion;
    }

    // Permite mostrar los datos principales de la cuenta
    // cuando imprimimos el objeto.
    @Override
    public String toString() {
        return "Cuenta{" +
                "numCuenta=" + numCuenta +
                ", cliente=" + cliente +
                ", saldo=" + saldo +
                '}';
    }
}