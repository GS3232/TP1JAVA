package ar.org.centro8.java.curso.Tp1Java.test;

import ar.org.centro8.java.curso.Tp1Java.Entidades.ClienteEmpresa;
import ar.org.centro8.java.curso.Tp1Java.Entidades.CuentaConvertibilidad;

// Esta clase sirve para probar el funcionamiento
// de CuentaConvertibilidad.
public class TestCuentaConvertibilidad {

    // El main es el punto desde donde comienza
    // la ejecución del test.
    public static void main(String[] args) {

        // Creo un cliente empresa con sus datos.
        ClienteEmpresa empresa =
                new ClienteEmpresa(
                        2,
                        "Mi Empresa",
                        "30-12345678-9");

        // Creo una cuenta de convertibilidad y la asocio
        // con el cliente empresa.
        // El descubierto autorizado es de $5000.
        CuentaConvertibilidad cuenta =
                new CuentaConvertibilidad(
                        3001,
                        empresa,
                        5000);

        // Muestro el saldo inicial en pesos.
        System.out.println(
                "Pesos iniciales: $" + cuenta.getSaldo());

        // Muestro el saldo inicial en dólares.
        System.out.println(
                "Dolares iniciales: $" +
                cuenta.getSaldoDolares());

        // Muestro la operación que voy a realizar.
        System.out.println("Deposito de $100000");

        // Deposito $100000 en pesos.
        cuenta.depositarEfectivo(100000);

        // Muestro el saldo en pesos después del depósito.
        System.out.println(
                "Pesos actuales: $" + cuenta.getSaldo());

        // Muestro la operación que voy a realizar.
        System.out.println("Deposito de 1000 dolares");

        // Deposito 1000 dólares.
        cuenta.depositarDolares(1000);

        // Muestro el saldo en dólares después del depósito.
        System.out.println(
                "Dolares actuales: $" +
                cuenta.getSaldoDolares());

        // Muestro la operación que voy a realizar.
        System.out.println("Debito de 200 dolares");

        // Retiro 200 dólares.
        cuenta.debitarDolares(200);

        // Muestro el saldo en dólares después del retiro.
        System.out.println(
                "Dolares actuales: $" +
                cuenta.getSaldoDolares());

        // Muestro la conversión que voy a realizar.
        System.out.println(
                "Conversion de $10000 pesos a dolares");

        // Convierto $10000 pesos a dólares.
        // La tasa utilizada es de 1000 pesos por dólar.
        cuenta.convertirPesosADolares(
                10000,
                1000);

        // Muestro los pesos que quedaron después
        // de realizar la conversión.
        System.out.println(
                "Pesos actuales: $" + cuenta.getSaldo());

        // Muestro los dólares obtenidos después
        // de la conversión.
        System.out.println(
                "Dolares actuales: $" +
                cuenta.getSaldoDolares());

        // Muestro la conversión que voy a realizar.
        System.out.println(
                "Conversion de 5 dolares a pesos");

        // Convierto 5 dólares a pesos.
        // La tasa utilizada es de 1000 pesos por dólar.
        cuenta.convertirDolaresAPesos(
                5,
                1000);

        // Muestro los pesos que quedaron después
        // de realizar la conversión.
        System.out.println(
                "Pesos actuales: $" + cuenta.getSaldo());

        // Muestro los dólares que quedaron después
        // de realizar la conversión.
        System.out.println(
                "Dolares actuales: $" +
                cuenta.getSaldoDolares());

        // Intento retirar 1000 dólares.
        // La cuenta no tiene esa cantidad disponible.
        System.out.println(
                "Intento de debitar 1000 dolares");

        // Uso try porque esta operación debería generar
        // una excepción por falta de dólares.
        try {
            cuenta.debitarDolares(1000);

        // Capturo la excepción y muestro el mensaje.
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}