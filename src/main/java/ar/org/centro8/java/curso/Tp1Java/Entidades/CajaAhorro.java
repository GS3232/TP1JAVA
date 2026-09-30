package ar.org.centro8.java.curso.Tp1Java.Entidades;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// Representa una caja de ahorro.
// Hereda las características y operaciones básicas de Cuenta.
@Getter
@Setter
@ToString(callSuper = true) 
//CajaAhorro hereda de Cuenta, entonces 
// callSuper = true le dice a Lombok:
//Cuando generes el toString() de CajaAhorro, también incluí los datos de Cuenta.

public class CajaAhorro extends Cuenta {

    // Tasa de interés que genera la caja de ahorro.
    private double tasaInteres;

    // Constructor: se usa para crear una caja de ahorro
    // con su número, cliente y tasa de interés.
    public CajaAhorro(
            int numCuenta,
            Cliente cliente,
            double tasaInteres) {

        // Llama al constructor de la clase padre Cuenta
        // para inicializar el número y el cliente.
        super(numCuenta, cliente);

        // Guardo la tasa de interés recibida.
        this.tasaInteres = tasaInteres;
    }

    // Permite cobrar el interés generado por la cuenta.
    public void cobrarInteres() {

        // Calculo el interés multiplicando el saldo
        // por la tasa de interés.
        double interes = getSaldo() * tasaInteres;

        // Sumo el interés calculado al saldo de la cuenta.
        modificarSaldo(interes);
    }

    // Lombok genera automáticamente:
    // - getTasaInteres()
    // - setTasaInteres()
    // - toString()
}