package ar.org.centro8.java.curso.Tp1Java.Test;

import java.time.LocalDate;

import ar.org.centro8.java.curso.Tp1Java.Cheque;
import ar.org.centro8.java.curso.Tp1Java.ClienteEmpresa;
import ar.org.centro8.java.curso.Tp1Java.CuentaCorriente;

public class TestCuentaCorriente {

    public static void main(String[] args) {

        ClienteEmpresa empresa =
                new ClienteEmpresa(
                        2,
                        "Mi Empresa",
                        "30-12345678-9");

        System.out.println(
                "Cliente empresa: " +
                empresa.getNumero() + " - " +
                empresa.getNombreFantasia() +
                " (CUIT: " + empresa.getCuit() + ")");

        CuentaCorriente cuenta =
                new CuentaCorriente(
                        2001,
                        empresa,
                        5000);

        System.out.println(
                "Saldo inicial: $" + cuenta.getSaldo());

        System.out.println("Deposito de $10000");

        cuenta.depositarEfectivo(10000);

        System.out.println(
                "Saldo actual: $" + cuenta.getSaldo());

        System.out.println("Debito de $12000");

        cuenta.debitarEfectivo(12000);

        System.out.println(
                "Saldo con descubierto: $" + cuenta.getSaldo());

        System.out.println("Debito de $4000");

        try {
            cuenta.debitarEfectivo(4000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        Cheque cheque =
                new Cheque(
                        3000,
                        "Banco Ejemplo",
                        LocalDate.of(2026, 10, 15));

        System.out.println(
                "Deposito de cheque de $" +
                cheque.getMonto());

        cuenta.depositarCheque(cheque);

        System.out.println(
                "Saldo actual: $" + cuenta.getSaldo());
    }
}