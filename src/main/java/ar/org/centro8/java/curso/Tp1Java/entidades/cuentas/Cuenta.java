package ar.org.centro8.java.curso.tp1java.entidades.cuentas;

import ar.org.centro8.java.curso.tp1java.entidades.clientes.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// Es la clase padre de los distintos tipos de cuenta.
// Es abstracta porque no vamos a crear una Cuenta directamente.
@Getter
@Setter
@ToString
@AllArgsConstructor
public abstract class Cuenta {

    // Número que identifica la cuenta.
    private int numCuenta;

    // Cliente que es dueño de la cuenta.
    private Cliente cliente;

    // Dinero disponible en la cuenta.
    private double saldo;

    // Permite ingresar dinero a la cuenta.
    public void depositarEfectivo(double monto) {
        if (monto > 0) {
            saldo += monto;
        }
    }

    // Permite sacar dinero cuando hay saldo suficiente.
    public void debitarEfectivo(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
        }
    }
}