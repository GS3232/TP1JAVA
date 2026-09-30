# TP1 Java POO - Sistema Bancario

## Descripción

Trabajo práctico de Java POO sobre relaciones entre clases y modelado de un sistema bancario.

El sistema permite registrar clientes y cuentas bancarias, realizar operaciones con dinero y trabajar con distintos tipos de cuentas.

El proyecto utiliza **Lombok** para simplificar el código repetitivo, principalmente mediante `@Getter`, `@Setter` y `@ToString`.

## Objetivos

- Aplicar programación orientada a objetos.
- Utilizar clases y objetos.
- Aplicar herencia.
- Utilizar clases abstractas.
- Representar relaciones entre clases.
- Aplicar encapsulamiento mediante atributos privados, getters y setters.
- Implementar diferentes comportamientos según el tipo de cuenta.
- Utilizar Lombok para simplificar getters, setters y métodos `toString`.
- Realizar pruebas de las funcionalidades mediante clases de test.
- Mantener el proyecto modularizado mediante paquetes.

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

## Métodos principales

Entre los principales métodos implementados se encuentran:

- `depositarEfectivo()`
- `debitarEfectivo()`
- `cobrarInteres()`
- `depositarCheque()`
- `depositarDolares()`
- `debitarDolares()`
- `convertirPesosADolares()`
- `convertirDolaresAPesos()`

Estos métodos permiten realizar las operaciones correspondientes a cada tipo de cuenta.

## Lombok

El proyecto utiliza **Lombok** para simplificar el código repetitivo.

Se utilizan las siguientes anotaciones:

- `@Getter`: permite acceder a los valores de los atributos mediante getters.
- `@Setter`: permite modificar los valores de los atributos mediante setters.
- `@ToString`: genera automáticamente el método `toString()`.

De esta forma se reduce la cantidad de código repetitivo en las clases.

## Modularización

El proyecto está organizado en paquetes para separar las responsabilidades.

### `Entidades`

Contiene las clases principales del sistema:

- `Cliente`
- `ClienteIndividual`
- `ClienteEmpresa`
- `Cuenta`
- `CajaAhorro`
- `CuentaCorriente`
- `CuentaConvertibilidad`
- `Cheque`

### `test`

Contiene las clases utilizadas para probar el funcionamiento de las entidades:

- `TestCajaAhorro`
- `TestCuentaCorriente`
- `TestCheque`
- `TestCuentaConvertibilidad`

## Relaciones entre clases

```text
Cliente
├── ClienteIndividual
└── ClienteEmpresa

Cuenta
├── CajaAhorro
└── CuentaCorriente
       └── CuentaConvertibilidad