package ar.org.centro8.java.curso.Tp1Java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import ar.org.centro8.java.curso.Tp1Java.Entidades.ClienteIndividual;
import ar.org.centro8.java.curso.Tp1Java.Entidades.ClienteEmpresa;
import ar.org.centro8.java.curso.Tp1Java.Entidades.Cuenta;
import ar.org.centro8.java.curso.Tp1Java.Entidades.CajaAhorro;
import ar.org.centro8.java.curso.Tp1Java.Entidades.CuentaCorriente;
import ar.org.centro8.java.curso.Tp1Java.Entidades.CuentaConvertibilidad;
import ar.org.centro8.java.curso.Tp1Java.Entidades.Cheque;


class Tp1JavaApplicationTests {

    @Test
    void probarDepositoDeCuenta() {

        ClienteIndividual cliente =
                new ClienteIndividual(
                        1,
                        "Juan",
                        "Perez",
                        "30123456");

        Cuenta cuenta =
                new Cuenta(
                        1001,
                        cliente);

        cuenta.depositarEfectivo(10000);

        assertEquals(10000, cuenta.getSaldo());
    }

    @Test
    void probarDebitoDeCuenta() {

        ClienteIndividual cliente =
                new ClienteIndividual(
                        1,
                        "Juan",
                        "Perez",
                        "30123456");

        Cuenta cuenta =
                new Cuenta(
                        1001,
                        cliente);

        cuenta.depositarEfectivo(10000);
        cuenta.debitarEfectivo(3000);

        assertEquals(7000, cuenta.getSaldo());
    }

    @Test
    void noPermitirDepositoNegativo() {

        ClienteIndividual cliente =
                new ClienteIndividual(
                        1,
                        "Juan",
                        "Perez",
                        "30123456");

        Cuenta cuenta =
                new Cuenta(
                        1001,
                        cliente);

        assertThrows(
                IllegalArgumentException.class,
                () -> cuenta.depositarEfectivo(-100));
    }

    @Test
    void noPermitirDebitoMayorAlSaldo() {

        ClienteIndividual cliente =
                new ClienteIndividual(
                        1,
                        "Juan",
                        "Perez",
                        "30123456");

        Cuenta cuenta =
                new Cuenta(
                        1001,
                        cliente);

        cuenta.depositarEfectivo(5000);

        assertThrows(
                IllegalArgumentException.class,
                () -> cuenta.debitarEfectivo(6000));
    }

    @Test
    void probarCajaDeAhorro() {

        ClienteIndividual cliente =
                new ClienteIndividual(
                        1,
                        "Juan",
                        "Perez",
                        "30123456");

        CajaAhorro caja =
                new CajaAhorro(
                        2001,
                        cliente,
                        0.05);

        caja.depositarEfectivo(100000);
        caja.cobrarInteres();

        assertEquals(105000, caja.getSaldo());
    }

    @Test
    void probarCuentaCorrienteConDescubierto() {

        ClienteEmpresa empresa =
                new ClienteEmpresa(
                        2,
                        "Mi Empresa",
                        "30-12345678-9");

        CuentaCorriente cuenta =
                new CuentaCorriente(
                        3001,
                        empresa,
                        5000);

        cuenta.depositarEfectivo(10000);
        cuenta.debitarEfectivo(12000);

        assertEquals(-2000, cuenta.getSaldo());
    }

    @Test
    void noSuperarDescubiertoAutorizado() {

        ClienteEmpresa empresa =
                new ClienteEmpresa(
                        2,
                        "Mi Empresa",
                        "30-12345678-9");

        CuentaCorriente cuenta =
                new CuentaCorriente(
                        3001,
                        empresa,
                        5000);

        cuenta.depositarEfectivo(10000);

        assertThrows(
                IllegalArgumentException.class,
                () -> cuenta.debitarEfectivo(16000));
    }

    @Test
    void probarDepositoDeCheque() {

        ClienteEmpresa empresa =
                new ClienteEmpresa(
                        2,
                        "Mi Empresa",
                        "30-12345678-9");

        CuentaCorriente cuenta =
                new CuentaCorriente(
                        3001,
                        empresa,
                        5000);

        Cheque cheque =
                new Cheque(
                        3000,
                        "Banco Ejemplo",
                        LocalDate.of(2026, 10, 15));

        cuenta.depositarCheque(cheque);

        assertEquals(3000, cuenta.getSaldo());
    }

    @Test
    void probarDepositoDeDolares() {

        ClienteEmpresa empresa =
                new ClienteEmpresa(
                        2,
                        "Mi Empresa",
                        "30-12345678-9");

        CuentaConvertibilidad cuenta =
                new CuentaConvertibilidad(
                        4001,
                        empresa,
                        5000);

        cuenta.depositarDolares(1000);

        assertEquals(1000, cuenta.getSaldoDolares());
    }

    @Test
    void probarDebitoDeDolares() {

        ClienteEmpresa empresa =
                new ClienteEmpresa(
                        2,
                        "Mi Empresa",
                        "30-12345678-9");

        CuentaConvertibilidad cuenta =
                new CuentaConvertibilidad(
                        4001,
                        empresa,
                        5000);

        cuenta.depositarDolares(1000);
        cuenta.debitarDolares(300);

        assertEquals(700, cuenta.getSaldoDolares());
    }

    @Test
    void noPermitirDescubiertoEnDolares() {

        ClienteEmpresa empresa =
                new ClienteEmpresa(
                        2,
                        "Mi Empresa",
                        "30-12345678-9");

        CuentaConvertibilidad cuenta =
                new CuentaConvertibilidad(
                        4001,
                        empresa,
                        5000);

        cuenta.depositarDolares(1000);

        assertThrows(
                IllegalArgumentException.class,
                () -> cuenta.debitarDolares(1500));
    }

    @Test
    void probarConversionDePesosADolares() {

        ClienteEmpresa empresa =
                new ClienteEmpresa(
                        2,
                        "Mi Empresa",
                        "30-12345678-9");

        CuentaConvertibilidad cuenta =
                new CuentaConvertibilidad(
                        4001,
                        empresa,
                        5000);

        cuenta.depositarEfectivo(100000);

        cuenta.convertirPesosADolares(
                10000,
                1000);

        assertEquals(90000, cuenta.getSaldo());
        assertEquals(10, cuenta.getSaldoDolares());
    }

    @Test
    void probarConversionDeDolaresAPesos() {

        ClienteEmpresa empresa =
                new ClienteEmpresa(
                        2,
                        "Mi Empresa",
                        "30-12345678-9");

        CuentaConvertibilidad cuenta =
                new CuentaConvertibilidad(
                        4001,
                        empresa,
                        5000);

        cuenta.depositarDolares(10);

        cuenta.convertirDolaresAPesos(
                5,
                1000);

        assertEquals(5000, cuenta.getSaldo());
        assertEquals(5, cuenta.getSaldoDolares());
    }

    @Test
    void noPermitirConversionSinPesosSuficientes() {

        ClienteEmpresa empresa =
                new ClienteEmpresa(
                        2,
                        "Mi Empresa",
                        "30-12345678-9");

        CuentaConvertibilidad cuenta =
                new CuentaConvertibilidad(
                        4001,
                        empresa,
                        5000);

        cuenta.depositarEfectivo(5000);

        assertThrows(
                IllegalArgumentException.class,
                () -> cuenta.convertirPesosADolares(
                        6000,
                        1000));
    }

    @Test
    void noPermitirConversionSinDolaresSuficientes() {

        ClienteEmpresa empresa =
                new ClienteEmpresa(
                        2,
                        "Mi Empresa",
                        "30-12345678-9");

        CuentaConvertibilidad cuenta =
                new CuentaConvertibilidad(
                        4001,
                        empresa,
                        5000);

        cuenta.depositarDolares(5);

        assertThrows(
                IllegalArgumentException.class,
                () -> cuenta.convertirDolaresAPesos(
                        10,
                        1000));
    }
}