package ar.org.centro8.java.curso.tp1java.test;

import ar.org.centro8.java.curso.tp1java.entidades.clientes.ClienteEmpresa;
import ar.org.centro8.java.curso.tp1java.entidades.cuentas.CuentaConvertibilidad;

// Esta clase sirve para probar el funcionamiento
// de CuentaConvertibilidad.
public class TestCuentaConvertibilidad {

    public static void main(String[] args) {

        // Creo un cliente empresa con sus datos.
        ClienteEmpresa empresa = new ClienteEmpresa(
                2,
                "Mi Empresa",
                "30-12345678-9"
        );

        // Creo una cuenta de convertibilidad.
        // El descubierto autorizado es de $5000.
        CuentaConvertibilidad cuenta = new CuentaConvertibilidad(
                3001,
                empresa,
                5000
        );

        // Muestro los saldos iniciales.
        System.out.println("Pesos iniciales: $" + cuenta.getSaldo());
        System.out.println("Dolares iniciales: " + cuenta.getSaldoDolares());

        // Deposito $100000 en pesos.
        System.out.println("Deposito de $100000");
        cuenta.depositarEfectivo(100000);
        System.out.println("Pesos actuales: $" + cuenta.getSaldo());

        // Deposito 1000 dólares.
        System.out.println("Deposito de 1000 dolares");
        cuenta.depositarDolares(1000);
        System.out.println("Dolares actuales: " + cuenta.getSaldoDolares());

        // Retiro 200 dólares.
        System.out.println("Debito de 200 dolares");
        cuenta.debitarDolares(200);
        System.out.println("Dolares actuales: " + cuenta.getSaldoDolares());

        // Convierto $10000 pesos a dólares.
        // La tasa es de 1000 pesos por dólar.
        System.out.println("Conversion de $10000 pesos a dolares");
        cuenta.convertirPesosADolares(10000, 1000);
        System.out.println("Pesos actuales: $" + cuenta.getSaldo());
        System.out.println("Dolares actuales: " + cuenta.getSaldoDolares());

        // Convierto 5 dólares a pesos.
        System.out.println("Conversion de 5 dolares a pesos");
        cuenta.convertirDolaresAPesos(5, 1000);
        System.out.println("Pesos actuales: $" + cuenta.getSaldo());
        System.out.println("Dolares actuales: " + cuenta.getSaldoDolares());

        // Intento retirar 1000 dólares.
        // Como no hay suficientes dólares, el saldo no debe cambiar.
        System.out.println("Intento de debitar 1000 dolares");
        cuenta.debitarDolares(1000);
        System.out.println("Dolares después del intento: " + cuenta.getSaldoDolares());
    }
}
