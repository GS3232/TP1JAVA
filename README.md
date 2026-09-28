# TP1 Java POO - Sistema Bancario

## Descripción

Trabajo práctico de Java POO sobre relaciones entre clases y modelado de un sistema bancario.

El sistema permite registrar clientes y cuentas bancarias, realizar operaciones con dinero y trabajar con distintos tipos de cuentas.

## Objetivos

- Aplicar programación orientada a objetos.
- Utilizar clases y objetos.
- Aplicar herencia.
- Utilizar clases abstractas.
- Representar relaciones entre clases.
- Aplicar encapsulamiento mediante atributos privados, getters y setters.
- Implementar diferentes comportamientos según el tipo de cuenta.
- Realizar pruebas de las funcionalidades mediante clases de test.

## Clientes

Se creó una clase abstracta `Cliente`.

A partir de ella se crearon:

- `ClienteIndividual`
- `ClienteEmpresa`

### ClienteIndividual

Contiene:

- Nombre
- Apellido
- DNI

### ClienteEmpresa

Contiene:

- Nombre de fantasía
- CUIT

## Cuentas

Se creó la clase `Cuenta` como clase base.

Una cuenta contiene:

- Número de cuenta
- Cliente asociado
- Saldo

Permite:

- Depositar efectivo
- Debitar efectivo

### CajaAhorro

Hereda de `Cuenta` y agrega:

- Tasa de interés
- Cobro de intereses

### CuentaCorriente

Hereda de `Cuenta` y agrega:

- Monto autorizado para girar en descubierto
- Depósito de cheques

También permite utilizar el descubierto respetando el límite autorizado.

### Cheque

Contiene:

- Monto
- Banco emisor
- Fecha de pago

### CuentaConvertibilidad

Hereda de `CuentaCorriente` y está destinada a clientes empresa.

Permite:

- Operar en pesos
- Operar en dólares
- Depositar dólares
- Debitar dólares
- Convertir pesos a dólares
- Convertir dólares a pesos

Para los dólares no se permite utilizar descubierto.

## Relaciones entre clases

```text
Cliente
├── ClienteIndividual
└── ClienteEmpresa

Cuenta
├── CajaAhorro
└── CuentaCorriente
       └── CuentaConvertibilidad