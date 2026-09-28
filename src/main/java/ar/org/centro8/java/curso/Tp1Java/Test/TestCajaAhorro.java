package ar.org.centro8.java.curso.Tp1Java.Test;

import ar.org.centro8.java.curso.Tp1Java.CajaAhorro;
import ar.org.centro8.java.curso.Tp1Java.ClienteIndividual;

public class TestCajaAhorro {

    public static void main(String[] args) {

        ClienteIndividual cliente =
                new ClienteIndividual(
                        1,
                        "Juan",
                        "Perez",
                        "30123456");

        System.out.println(
                "Cliente: " +
                cliente.getNumero() + " - " +
                cliente.getNombre() + " " +
                cliente.getApellido() +
                " (DNI: " + cliente.getDni() + ")");

        CajaAhorro caja =
                new CajaAhorro(
                        1001,
                        cliente,
                        0.05);

        System.out.println(
                "Saldo inicial: $" + caja.getSaldo());

        System.out.println("Deposito de $10000");

        caja.depositarEfectivo(10000);

        System.out.println(
                "Saldo actual: $" + caja.getSaldo());

        System.out.println("Debito de $3000");

        caja.debitarEfectivo(3000);

        System.out.println(
                "Saldo actual: $" + caja.getSaldo());

        System.out.println("Debito de $10000");

        try {
            caja.debitarEfectivo(10000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Cobro de intereses");

        caja.cobrarInteres();

        System.out.println(
                "Saldo + intereses: $" + caja.getSaldo());
    }
}