package ar.org.centro8.java.curso.Tp1Java.test;

import java.time.LocalDate;

import ar.org.centro8.java.curso.Tp1Java.Entidades.CuentaCorriente;
import ar.org.centro8.java.curso.Tp1Java.Entidades.Cheque;
import ar.org.centro8.java.curso.Tp1Java.Entidades.ClienteEmpresa;

// Esta clase sirve para probar el funcionamiento
// de CuentaCorriente.
public class TestCuentaCorriente {

    // El main es el punto desde donde comienza
    // la ejecución del test.
    public static void main(String[] args) {

        // Creo un cliente empresa con sus datos.
        ClienteEmpresa empresa =
                new ClienteEmpresa(
                        2,
                        "Mi Empresa",
                        "30-12345678-9");

        // Muestro los datos de la empresa por consola.
        System.out.println(
                "Cliente empresa: " +
                empresa.getNumero() + " - " +
                empresa.getNombreFantasia() +
                " (CUIT: " + empresa.getCuit() + ")");

        // Creo una cuenta corriente y la asocio
        // con el cliente empresa.
        // El descubierto autorizado es de $5000.
        CuentaCorriente cuenta =
                new CuentaCorriente(
                        2001,
                        empresa,
                        5000);

        // Muestro el saldo inicial de la cuenta.
        System.out.println(
                "Saldo inicial: $" + cuenta.getSaldo());

        // Muestro la operación que voy a realizar.
        System.out.println("Deposito de $10000");

        // Deposito $10000 en la cuenta.
        cuenta.depositarEfectivo(10000);

        // Muestro el saldo después del depósito.
        System.out.println(
                "Saldo actual: $" + cuenta.getSaldo());

        // Intento retirar $12000.
        // La cuenta puede utilizar el descubierto autorizado.
        System.out.println("Debito de $12000");

        // Retiro $12000 de la cuenta.
        cuenta.debitarEfectivo(12000);

        // Muestro el saldo después de utilizar
        // parte del descubierto.
        System.out.println(
                "Saldo con descubierto: $" + cuenta.getSaldo());

        // Intento retirar otros $4000.
        // Esta operación supera el descubierto disponible.
        System.out.println("Debito de $4000");

        // Uso try porque la operación debería generar
        // una excepción.
        try {
            cuenta.debitarEfectivo(4000);

        // Capturo la excepción y muestro el mensaje.
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Creo un cheque con su monto,
        // banco emisor y fecha de pago.
        Cheque cheque =
                new Cheque(
                        3000,
                        "Banco Ejemplo",
                        LocalDate.of(2026, 10, 15));

        // Muestro el monto del cheque.
        System.out.println(
                "Deposito de cheque de $" +
                cheque.getMonto());

        // Deposito el cheque en la cuenta corriente.
        cuenta.depositarCheque(cheque);

        // Muestro el saldo después de depositar el cheque.
        System.out.println(
                "Saldo actual: $" + cuenta.getSaldo());
    }
}