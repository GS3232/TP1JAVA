package ar.org.centro8.java.curso.Tp1Java.Test;

import ar.org.centro8.java.curso.Tp1Java.ClienteEmpresa;
import ar.org.centro8.java.curso.Tp1Java.CuentaConvertibilidad;

public class TestCuentaConvertibilidad {

    public static void main(String[] args) {

        ClienteEmpresa empresa =
                new ClienteEmpresa(
                        2,
                        "Mi Empresa",
                        "30-12345678-9");

        CuentaConvertibilidad cuenta =
                new CuentaConvertibilidad(
                        3001,
                        empresa,
                        5000);

        System.out.println(
                "Pesos iniciales: $" + cuenta.getSaldo());

        System.out.println(
                "Dolares iniciales: $" +
                cuenta.getSaldoDolares());

        System.out.println("Deposito de $100000");

        cuenta.depositarEfectivo(100000);

        System.out.println(
                "Pesos actuales: $" + cuenta.getSaldo());

        System.out.println("Deposito de 1000 dolares");

        cuenta.depositarDolares(1000);

        System.out.println(
                "Dolares actuales: $" +
                cuenta.getSaldoDolares());

        System.out.println("Debito de 200 dolares");

        cuenta.debitarDolares(200);

        System.out.println(
                "Dolares actuales: $" +
                cuenta.getSaldoDolares());

        System.out.println(
                "Conversion de $10000 pesos a dolares");

        cuenta.convertirPesosADolares(
                10000,
                1000);

        System.out.println(
                "Pesos actuales: $" + cuenta.getSaldo());

        System.out.println(
                "Dolares actuales: $" +
                cuenta.getSaldoDolares());

        System.out.println(
                "Conversion de 5 dolares a pesos");

        cuenta.convertirDolaresAPesos(
                5,
                1000);

        System.out.println(
                "Pesos actuales: $" + cuenta.getSaldo());

        System.out.println(
                "Dolares actuales: $" +
                cuenta.getSaldoDolares());

        System.out.println(
                "Intento de debitar 1000 dolares");

        try {
            cuenta.debitarDolares(1000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}