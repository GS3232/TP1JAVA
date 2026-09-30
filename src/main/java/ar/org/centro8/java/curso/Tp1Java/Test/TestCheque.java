package ar.org.centro8.java.curso.Tp1Java.test;

import java.time.LocalDate;

import ar.org.centro8.java.curso.Tp1Java.Entidades.Cheque;

// Esta clase sirve para probar el funcionamiento de Cheque.
public class TestCheque {

    // El main es el punto desde donde comienza
    // la ejecución del test.
    public static void main(String[] args) {

        // Creo un objeto Cheque con sus datos iniciales.
        Cheque cheque =
                new Cheque(
                        5000,
                        "Banco Ejemplo",
                        LocalDate.of(2026, 10, 15));

        // Muestro que el cheque fue creado.
        System.out.println("Cheque creado");

        // Muestro el monto del cheque.
        System.out.println(
                "Monto: $" + cheque.getMonto());

        // Muestro el banco que emitió el cheque.
        System.out.println(
                "Banco emisor: " + cheque.getBancoEmisor());

        // Muestro la fecha en la que se puede pagar el cheque.
        System.out.println(
                "Fecha de pago: " + cheque.getFechaPago());
    }
}