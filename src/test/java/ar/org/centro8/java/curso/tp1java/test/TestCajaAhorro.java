package ar.org.centro8.java.curso.tp1java.test;

import ar.org.centro8.java.curso.tp1java.entidades.clientes.ClienteIndividual;
import ar.org.centro8.java.curso.tp1java.entidades.cuentas.CajaAhorro;

public class TestCajaAhorro {

    public static void main(String[] args) {

        // Creo un cliente individual.
        ClienteIndividual cliente = new ClienteIndividual(
                1,
                "Juan",
                "Perez",
                "30123456"
        );

        // Creo una caja de ahorro con una tasa de interés del 5%.
        CajaAhorro caja = new CajaAhorro(
                1001,
                cliente,
                0.05
        );

        System.out.println("Saldo inicial: " + caja.getSaldo());

        // Deposito $10000.
        caja.depositarEfectivo(10000);
        System.out.println("Saldo después del depósito: " + caja.getSaldo());

        // Retiro $3000.
        caja.debitarEfectivo(3000);
        System.out.println("Saldo después del retiro: " + caja.getSaldo());

        // Intento retirar $10000, pero no hay saldo suficiente.
        caja.debitarEfectivo(10000);
        System.out.println("Saldo después de intentar retirar de más: " + caja.getSaldo());

        // Cobro los intereses sobre el saldo disponible.
        caja.cobrarInteres();
        System.out.println("Saldo después de cobrar intereses: " + caja.getSaldo());
    }
}
