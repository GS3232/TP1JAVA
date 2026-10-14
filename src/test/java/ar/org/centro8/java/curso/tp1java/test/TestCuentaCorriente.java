package ar.org.centro8.java.curso.tp1java.test;

import java.time.LocalDate;

import ar.org.centro8.java.curso.tp1java.entidades.clientes.ClienteEmpresa;
import ar.org.centro8.java.curso.tp1java.entidades.cuentas.Cheque;
import ar.org.centro8.java.curso.tp1java.entidades.cuentas.CuentaCorriente;

// Esta clase sirve para probar el funcionamiento
// de CuentaCorriente.
public class TestCuentaCorriente {

public static void main(String[] args) {

        // Creo un cliente empresa con sus datos.
        ClienteEmpresa empresa = new ClienteEmpresa(
                2,
                "Mi Empresa",
                "30-12345678-9"
        );

        System.out.println(
                "Cliente empresa: " +
                empresa.getNumero() + " - " +
                empresa.getNombreFantasia() +
                " (CUIT: " + empresa.getCuit() + ")"
        );

        // Creo una cuenta corriente con $5000 de descubierto autorizado.
        CuentaCorriente cuenta = new CuentaCorriente(
                2001,
                empresa,
                5000
        );

        System.out.println("Saldo inicial: $" + cuenta.getSaldo());

        // Deposito $10000.
        System.out.println("Deposito de $10000");
        cuenta.depositarEfectivo(10000);
        System.out.println("Saldo actual: $" + cuenta.getSaldo());

        // Retiro $12000 usando parte del descubierto.
        System.out.println("Debito de $12000");
        cuenta.debitarEfectivo(12000);
        System.out.println("Saldo con descubierto: $" + cuenta.getSaldo());

        // Intento retirar $4000 adicionales.
        // Como supera el descubierto disponible, el saldo no cambia.
        System.out.println("Intento de debito de $4000");
        cuenta.debitarEfectivo(4000);
        System.out.println("Saldo después del intento: $" + cuenta.getSaldo());

        // Creo un cheque.
        Cheque cheque = new Cheque(
                3000,
                "Banco Ejemplo",
                LocalDate.of(2026, 10, 15)
        );

        System.out.println(
                "Deposito de cheque de $" + cheque.getMonto()
        );

        // Deposito el cheque.
        cuenta.depositarCheque(cheque);

        System.out.println(
                "Saldo después de depositar el cheque: $" +
                cuenta.getSaldo()
        );
    }
}
