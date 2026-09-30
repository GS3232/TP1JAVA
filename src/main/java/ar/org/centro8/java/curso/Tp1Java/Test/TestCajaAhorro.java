package ar.org.centro8.java.curso.Tp1Java.test;

import ar.org.centro8.java.curso.Tp1Java.Entidades.CajaAhorro;
import ar.org.centro8.java.curso.Tp1Java.Entidades.ClienteIndividual;

// Esta clase sirve para probar el funcionamiento de CajaAhorro.
public class TestCajaAhorro {

    // El main es el punto desde donde comienza la ejecución del test.
    public static void main(String[] args) {

        // Creo un cliente individual con sus datos.
        ClienteIndividual cliente =
                new ClienteIndividual(
                        1,
                        "Juan",
                        "Perez",
                        "30123456");

        // Muestro los datos del cliente por consola.
        System.out.println(
                "Cliente: " +
                cliente.getNumero() + " - " +
                cliente.getNombre() + " " +
                cliente.getApellido() +
                " (DNI: " + cliente.getDni() + ")");

        // Creo una caja de ahorro y la asocio al cliente.
        // También le asigno una tasa de interés del 5%.
        CajaAhorro caja =
                new CajaAhorro(
                        1001,
                        cliente,
                        0.05);

        // Muestro el saldo inicial de la cuenta.
        System.out.println(
                "Saldo inicial: $" + caja.getSaldo());

        // Muestro qué operación voy a realizar.
        System.out.println("Deposito de $10000");

        // Deposito $10000 en la caja de ahorro.
        caja.depositarEfectivo(10000);

        // Muestro el saldo después del depósito.
        System.out.println(
                "Saldo actual: $" + caja.getSaldo());

        // Muestro qué operación voy a realizar.
        System.out.println("Debito de $3000");

        // Retiro $3000 de la cuenta.
        caja.debitarEfectivo(3000);

        // Muestro el saldo después del retiro.
        System.out.println(
                "Saldo actual: $" + caja.getSaldo());

        // Intento retirar $10000.
        // En este momento no hay saldo suficiente.
        System.out.println("Debito de $10000");

        // Uso try porque esta operación debería generar
        // una excepción por falta de saldo.
        try {
            caja.debitarEfectivo(10000);

        // Uso catch para capturar la excepción
        // y mostrar el mensaje correspondiente.
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Muestro que voy a realizar el cobro de intereses.
        System.out.println("Cobro de intereses");

        // Calculo el interés y lo sumo al saldo.
        caja.cobrarInteres();

        // Muestro el saldo final después de cobrar los intereses.
        System.out.println(
                "Saldo + intereses: $" + caja.getSaldo());
    }
}