package ar.org.centro8.java.curso.tp1java.test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import ar.org.centro8.java.curso.tp1java.entidades.clientes.ClienteEmpresa;
import ar.org.centro8.java.curso.tp1java.entidades.clientes.ClienteIndividual;

import ar.org.centro8.java.curso.tp1java.entidades.cuentas.CajaAhorro;
import ar.org.centro8.java.curso.tp1java.entidades.cuentas.Cheque;
import ar.org.centro8.java.curso.tp1java.entidades.cuentas.CuentaConvertibilidad;
import ar.org.centro8.java.curso.tp1java.entidades.cuentas.CuentaCorriente;


// Esta clase contiene las pruebas del sistema bancario.
class Tp1JavaApplicationTests {

    @Test
    void probarDepositoDeCuenta() {

        // Creo un cliente individual.
        ClienteIndividual cliente =
                new ClienteIndividual(
                        1,
                        "Juan",
                        "Perez",
                        "30123456");

        // Creo una caja de ahorro.
        // Uso una clase hija porque Cuenta es abstracta.
        CajaAhorro cuenta =
                new CajaAhorro(
                        1001,
                        cliente,
                        0.05);

        // Deposito $10000.
        cuenta.depositarEfectivo(10000);

        // Compruebo que el saldo sea $10000.
        assertEquals(10000.0, cuenta.getSaldo());
    }

    @Test
    void probarDebitoDeCuenta() {

        // Creo un cliente individual.
        ClienteIndividual cliente =
                new ClienteIndividual(
                        1,
                        "Juan",
                        "Perez",
                        "30123456");

        // Creo una caja de ahorro.
        CajaAhorro cuenta =
                new CajaAhorro(
                        1001,
                        cliente,
                        0.05);

        // Deposito $10000.
        cuenta.depositarEfectivo(10000);

        // Retiro $3000.
        cuenta.debitarEfectivo(3000);

        // Compruebo que queden $7000.
        assertEquals(7000.0, cuenta.getSaldo());
    }

    @Test
    void noPermitirDepositoNegativo() {

        // Creo un cliente individual.
        ClienteIndividual cliente =
                new ClienteIndividual(
                        1,
                        "Juan",
                        "Perez",
                        "30123456");

        // Creo una caja de ahorro.
        CajaAhorro cuenta =
                new CajaAhorro(
                        1001,
                        cliente,
                        0.05);

        // Intento depositar un monto negativo.
        cuenta.depositarEfectivo(-100);

        // El saldo debe seguir en cero.
        assertEquals(0.0, cuenta.getSaldo());
    }

    @Test
    void noPermitirDebitoMayorAlSaldo() {

        // Creo un cliente individual.
        ClienteIndividual cliente =
                new ClienteIndividual(
                        1,
                        "Juan",
                        "Perez",
                        "30123456");

        // Creo una caja de ahorro.
        CajaAhorro cuenta =
                new CajaAhorro(
                        1001,
                        cliente,
                        0.05);

        // Deposito $5000.
        cuenta.depositarEfectivo(5000);

        // Intento retirar $6000.
        cuenta.debitarEfectivo(6000);

        // El retiro no debe realizarse.
        assertEquals(5000.0, cuenta.getSaldo());
    }

    @Test
    void probarCajaDeAhorro() {

        // Creo un cliente individual.
        ClienteIndividual cliente =
                new ClienteIndividual(
                        1,
                        "Juan",
                        "Perez",
                        "30123456");

        // Creo una caja de ahorro con una tasa del 5%.
        CajaAhorro caja =
                new CajaAhorro(
                        2001,
                        cliente,
                        0.05);

        // Deposito $100000.
        caja.depositarEfectivo(100000);

        // Cobro los intereses.
        caja.cobrarInteres();

        // El 5% de $100000 es $5000.
        // El saldo final debe ser $105000.
        assertEquals(105000.0, caja.getSaldo());
    }

    @Test
    void probarCuentaCorrienteConDescubierto() {

        // Creo un cliente empresa.
        ClienteEmpresa empresa =
                new ClienteEmpresa(
                        2,
                        "Mi Empresa",
                        "30-12345678-9");

        // Creo una cuenta corriente
        // con $5000 de descubierto autorizado.
        CuentaCorriente cuenta =
                new CuentaCorriente(
                        3001,
                        empresa,
                        5000);

        // Deposito $10000.
        cuenta.depositarEfectivo(10000);

        // Retiro $12000.
        // Utiliza $2000 del descubierto.
        cuenta.debitarEfectivo(12000);

        // El saldo queda en -$2000.
        assertEquals(-2000.0, cuenta.getSaldo());
    }

    @Test
    void noSuperarDescubiertoAutorizado() {

        // Creo un cliente empresa.
        ClienteEmpresa empresa =
                new ClienteEmpresa(
                        2,
                        "Mi Empresa",
                        "30-12345678-9");

        // Creo una cuenta corriente
        // con $5000 de descubierto.
        CuentaCorriente cuenta =
                new CuentaCorriente(
                        3001,
                        empresa,
                        5000);

        // Deposito $10000.
        cuenta.depositarEfectivo(10000);

        // Intento retirar $16000.
        // Solo tiene disponibles $15000 entre saldo y descubierto.
        cuenta.debitarEfectivo(16000);

        // La operación no debe realizarse.
        assertEquals(10000.0, cuenta.getSaldo());
    }

    @Test
    void probarDepositoDeCheque() {

        // Creo un cliente empresa.
        ClienteEmpresa empresa =
                new ClienteEmpresa(
                        2,
                        "Mi Empresa",
                        "30-12345678-9");

        // Creo una cuenta corriente.
        CuentaCorriente cuenta =
                new CuentaCorriente(
                        3001,
                        empresa,
                        5000);

        // Creo un cheque.
        Cheque cheque =
                new Cheque(
                        3000,
                        "Banco Ejemplo",
                        LocalDate.of(2026, 10, 15));

        // Deposito el cheque.
        cuenta.depositarCheque(cheque);

        // El saldo debe aumentar en $3000.
        assertEquals(3000.0, cuenta.getSaldo());
    }

    @Test
    void probarDepositoDeDolares() {

        // Creo un cliente empresa.
        ClienteEmpresa empresa =
                new ClienteEmpresa(
                        2,
                        "Mi Empresa",
                        "30-12345678-9");

        // Creo una cuenta de convertibilidad.
        CuentaConvertibilidad cuenta =
                new CuentaConvertibilidad(
                        4001,
                        empresa,
                        5000);

        // Deposito 1000 dólares.
        cuenta.depositarDolares(1000);

        // Compruebo el saldo en dólares.
        assertEquals(1000.0, cuenta.getSaldoDolares());
    }

    @Test
    void probarDebitoDeDolares() {

        // Creo un cliente empresa.
        ClienteEmpresa empresa =
                new ClienteEmpresa(
                        2,
                        "Mi Empresa",
                        "30-12345678-9");

        // Creo una cuenta de convertibilidad.
        CuentaConvertibilidad cuenta =
                new CuentaConvertibilidad(
                        4001,
                        empresa,
                        5000);

        // Deposito 1000 dólares.
        cuenta.depositarDolares(1000);

        // Retiro 300 dólares.
        cuenta.debitarDolares(300);

        // Deben quedar 700 dólares.
        assertEquals(700.0, cuenta.getSaldoDolares());
    }

    @Test
    void noPermitirDescubiertoEnDolares() {

        // Creo un cliente empresa.
        ClienteEmpresa empresa =
                new ClienteEmpresa(
                        2,
                        "Mi Empresa",
                        "30-12345678-9");

        // Creo una cuenta de convertibilidad.
        CuentaConvertibilidad cuenta =
                new CuentaConvertibilidad(
                        4001,
                        empresa,
                        5000);

        // Deposito 1000 dólares.
        cuenta.depositarDolares(1000);

        // Intento retirar 1500 dólares.
        // No se permite utilizar descubierto en dólares.
        cuenta.debitarDolares(1500);

        // El saldo debe seguir siendo 1000 dólares.
        assertEquals(1000.0, cuenta.getSaldoDolares());
    }

    @Test
    void probarConversionDePesosADolares() {

        // Creo un cliente empresa.
        ClienteEmpresa empresa =
                new ClienteEmpresa(
                        2,
                        "Mi Empresa",
                        "30-12345678-9");

        // Creo una cuenta de convertibilidad.
        CuentaConvertibilidad cuenta =
                new CuentaConvertibilidad(
                        4001,
                        empresa,
                        5000);

        // Deposito $100000.
        cuenta.depositarEfectivo(100000);

        // Convierto $10000 a dólares.
        // La tasa es 1000 pesos por dólar.
        cuenta.convertirPesosADolares(
                10000,
                1000);

        // Deben quedar $90000.
        assertEquals(90000.0, cuenta.getSaldo());

        // Y deben quedar 10 dólares.
        assertEquals(10.0, cuenta.getSaldoDolares());
    }

    @Test
    void probarConversionDeDolaresAPesos() {

        // Creo un cliente empresa.
        ClienteEmpresa empresa =
                new ClienteEmpresa(
                        2,
                        "Mi Empresa",
                        "30-12345678-9");

        // Creo una cuenta de convertibilidad.
        CuentaConvertibilidad cuenta =
                new CuentaConvertibilidad(
                        4001,
                        empresa,
                        5000);

        // Deposito 10 dólares.
        cuenta.depositarDolares(10);

        // Convierto 5 dólares a pesos.
        // La tasa es 1000 pesos por dólar.
        cuenta.convertirDolaresAPesos(
                5,
                1000);

        // Deben quedar $5000.
        assertEquals(5000.0, cuenta.getSaldo());

        // Deben quedar 5 dólares.
        assertEquals(5.0, cuenta.getSaldoDolares());
    }

    @Test
    void noPermitirConversionSinPesosSuficientes() {

        // Creo un cliente empresa.
        ClienteEmpresa empresa =
                new ClienteEmpresa(
                        2,
                        "Mi Empresa",
                        "30-12345678-9");

        // Creo una cuenta de convertibilidad.
        CuentaConvertibilidad cuenta =
                new CuentaConvertibilidad(
                        4001,
                        empresa,
                        5000);

        // Deposito $5000.
        cuenta.depositarEfectivo(5000);

        // Intento convertir $6000.
        // No hay pesos suficientes.
        cuenta.convertirPesosADolares(
                6000,
                1000);

        // El saldo debe seguir siendo $5000.
        assertEquals(5000.0, cuenta.getSaldo());

        // No se deben haber generado dólares.
        assertEquals(0.0, cuenta.getSaldoDolares());
    }

    @Test
    void noPermitirConversionSinDolaresSuficientes() {

        // Creo un cliente empresa.
        ClienteEmpresa empresa =
                new ClienteEmpresa(
                        2,
                        "Mi Empresa",
                        "30-12345678-9");

        // Creo una cuenta de convertibilidad.
        CuentaConvertibilidad cuenta =
                new CuentaConvertibilidad(
                        4001,
                        empresa,
                        5000);

        // Deposito 5 dólares.
        cuenta.depositarDolares(5);

        // Intento convertir 10 dólares.
        // No hay dólares suficientes.
        cuenta.convertirDolaresAPesos(
                10,
                1000);

        // El saldo en dólares debe seguir siendo 5.
        assertEquals(5.0, cuenta.getSaldoDolares());

        // El saldo en pesos debe seguir siendo cero.
        assertEquals(0.0, cuenta.getSaldo());
    }
}