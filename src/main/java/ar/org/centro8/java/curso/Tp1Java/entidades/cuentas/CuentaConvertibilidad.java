package ar.org.centro8.java.curso.tp1java.entidades.cuentas;

import ar.org.centro8.java.curso.tp1java.entidades.clientes.ClienteEmpresa;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// Representa una cuenta que permite trabajar con pesos y dólares.
// Hereda las operaciones de CuentaCorriente.
@Getter
@Setter
@ToString(callSuper = true)
public class CuentaConvertibilidad extends CuentaCorriente {

    // Saldo disponible en dólares.
    private double saldoDolares;

    // Constructor para crear una cuenta de convertibilidad.
    public CuentaConvertibilidad(
            int numCuenta,
            ClienteEmpresa cliente,
            double montoDescubierto) {

        // Llama al constructor de CuentaCorriente.
        super(numCuenta, cliente, montoDescubierto);
    }

    // Permite depositar dólares.
    public void depositarDolares(double monto) {
        if (monto > 0) {
            saldoDolares += monto;
        }
    }

    // Permite retirar dólares solamente si hay saldo suficiente.
    public void debitarDolares(double monto) {
        if (monto > 0 && monto <= saldoDolares) {
            saldoDolares -= monto;
        }
    }

    // Convierte pesos a dólares usando la tasa recibida.
    public void convertirPesosADolares(
            double montoPesos,
            double tasaConversion) {

        if (montoPesos > 0
                && tasaConversion > 0
                && montoPesos <= getSaldo()) {

            double dolares = montoPesos / tasaConversion;

            setSaldo(getSaldo() - montoPesos);
            saldoDolares += dolares;
        }
    }

    // Convierte dólares a pesos usando la tasa recibida.
    public void convertirDolaresAPesos(
            double montoDolares,
            double tasaConversion) {

        if (montoDolares > 0
                && tasaConversion > 0
                && montoDolares <= saldoDolares) {

            double pesos = montoDolares * tasaConversion;

            saldoDolares -= montoDolares;
            setSaldo(getSaldo() + pesos);
        }
    }
}