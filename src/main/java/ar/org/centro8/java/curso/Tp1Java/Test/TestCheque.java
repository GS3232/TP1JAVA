package ar.org.centro8.java.curso.Tp1Java.Test;

import java.time.LocalDate;

import ar.org.centro8.java.curso.Tp1Java.Cheque;

public class TestCheque {

    public static void main(String[] args) {

        Cheque cheque =
                new Cheque(
                        5000,
                        "Banco Ejemplo",
                        LocalDate.of(2026, 10, 15));

        System.out.println("Cheque creado");

        System.out.println(
                "Monto: $" + cheque.getMonto());

        System.out.println(
                "Banco emisor: " + cheque.getBancoEmisor());

        System.out.println(
                "Fecha de pago: " + cheque.getFechaPago());
    }
}