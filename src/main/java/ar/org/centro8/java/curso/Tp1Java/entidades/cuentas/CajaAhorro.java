package ar.org.centro8.java.curso.tp1java.entidades.cuentas;

import ar.org.centro8.java.curso.tp1java.entidades.clientes.Cliente;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// Representa una caja de ahorro.
// Hereda los datos y operaciones de Cuenta.
@Getter
@Setter
@ToString(callSuper = true)
public class CajaAhorro extends Cuenta {

    // Tasa de interés de la caja de ahorro.
    private double tasaInteres;

    // Constructor para crear una caja de ahorro.
    public CajaAhorro(
            int numCuenta,
            Cliente cliente,
            double tasaInteres) {

        // Llama al constructor de Cuenta.
        // La cuenta comienza con saldo 0.
        super(numCuenta, cliente, 0.0);

        // Guarda la tasa de interés.
        this.tasaInteres = tasaInteres;
    }

    // Calcula y agrega los intereses al saldo.
    public void cobrarInteres() {
        double interes = getSaldo() * tasaInteres;
        setSaldo(getSaldo() + interes);
    }
}