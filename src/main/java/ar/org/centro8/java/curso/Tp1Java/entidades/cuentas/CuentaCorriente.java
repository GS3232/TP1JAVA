package ar.org.centro8.java.curso.tp1java.entidades.cuentas;

import ar.org.centro8.java.curso.tp1java.entidades.clientes.Cliente;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// Representa una cuenta corriente.
// Hereda los datos y operaciones de Cuenta.
@Getter
@Setter
@ToString(callSuper = true)
public class CuentaCorriente extends Cuenta {

    // Monto máximo que se puede utilizar cuando no alcanza el saldo.
    private double montoDescubierto;

    // Constructor para crear una cuenta corriente.
    public CuentaCorriente(
            int numCuenta,
            Cliente cliente,
            double montoDescubierto) {

        // Llama al constructor de Cuenta.
        // La cuenta comienza con saldo 0.
        super(numCuenta, cliente, 0.0);

        // Guarda el monto autorizado para el descubierto.
        this.montoDescubierto = montoDescubierto;
    }

    // Permite extraer dinero usando el saldo y, si hace falta,
    // el monto autorizado de descubierto.
    @Override //redefine un metodo de la clase padre
    public void debitarEfectivo(double monto) {
        if (monto > 0 && monto <= getSaldo() + montoDescubierto) {
            setSaldo(getSaldo() - monto);
        }
    }

    // Recibo un cheque. Si el cheque existe y tiene un monto válido, sumo ese monto al saldo de la cuenta corriente.
    public void depositarCheque(Cheque cheque) {  //Este método recibe un objeto de tipo Cheque
        if (cheque != null && cheque.getMonto() > 0) {  // El cheque tiene que existir y además su monto tiene que ser mayor que cero
            setSaldo(getSaldo() + cheque.getMonto());
        }
    }
}