package ar.org.centro8.java.curso.tp1java.entidades.clientes;

import lombok.AllArgsConstructor;
import lombok.Getter;

// Es la clase padre de ClienteIndividual y ClienteEmpresa.
// Es abstracta porque no vamos a crear un objeto Cliente directamente.
@Getter
@AllArgsConstructor
public abstract class Cliente {

    // Número que identifica al cliente.
    private int numero;
}