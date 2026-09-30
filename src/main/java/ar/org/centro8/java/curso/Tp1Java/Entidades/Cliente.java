package ar.org.centro8.java.curso.Tp1Java.Entidades;

import lombok.Getter;

// Es abstracta porque no quiero crear un Cliente directamente.
// La uso como clase padre de ClienteIndividual y ClienteEmpresa.
@Getter
public abstract class Cliente {

    // Guardo el número que identifica al cliente.
    private int numero;

    // El constructor se usa cuando creo un cliente
    // para darle su número inicial.
    public Cliente(int numero) {
        // this.numero es el atributo del objeto
        // y numero es el dato que recibo.
        this.numero = numero;
    }

    // Lombok genera automáticamente el getter de numero.
}