package ar.org.centro8.java.curso.Tp1Java.Entidades;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

// Representa un cheque que se puede depositar
// en una cuenta corriente.
@Getter
@Setter
@ToString
public class Cheque {

    // Monto de dinero que tiene el cheque.
    private double monto;

    // Banco que emitió el cheque.
    private String bancoEmisor;

    // Fecha en la que se puede pagar el cheque.
    private LocalDate fechaPago;

    // Constructor: se usa para crear un cheque
    // con sus datos iniciales.
    public Cheque(
            double monto,
            String bancoEmisor,
            LocalDate fechaPago) {

        // Guardo los datos recibidos en los atributos.
        this.monto = monto;
        this.bancoEmisor = bancoEmisor;
        this.fechaPago = fechaPago;
    }

    // Lombok genera automáticamente:
    // - getters
    // - setters
    // - toString
}