package ar.org.centro8.java.curso.tp1java.entidades.cuentas;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// Representa un cheque que puede ser depositado en una cuenta corriente.
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Cheque {

    // Dinero que representa el cheque.
    private double monto;

    // Banco que emitió el cheque.
    private String bancoEmisor;

    // Fecha en la que se puede pagar el cheque.
    private LocalDate fechaPago;
}
