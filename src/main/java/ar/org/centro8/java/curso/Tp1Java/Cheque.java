package ar.org.centro8.java.curso.Tp1Java;

import java.time.LocalDate;

public class Cheque {

    private double monto;
    private String bancoEmisor;
    private LocalDate fechaPago;

    public Cheque(
            double monto,
            String bancoEmisor,
            LocalDate fechaPago) {

        this.monto = monto;
        this.bancoEmisor = bancoEmisor;
        this.fechaPago = fechaPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getBancoEmisor() {
        return bancoEmisor;
    }

    public void setBancoEmisor(String bancoEmisor) {
        this.bancoEmisor = bancoEmisor;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    @Override
    public String toString() {
        return "Cheque{" +
                "monto=" + monto +
                ", bancoEmisor='" + bancoEmisor + '\'' +
                ", fechaPago=" + fechaPago +
                '}';
    }
}
