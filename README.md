# TP1 Java POO — Sistema Bancario

## Descripción del proyecto

Este proyecto consiste en modelar un sistema bancario utilizando Java y los principios de la Programación Orientada a Objetos (POO).

El sistema permite registrar clientes individuales y empresas, administrar cuentas bancarias, realizar depósitos y extracciones, depositar cheques y convertir saldos entre pesos y dólares.

## Tecnologías utilizadas

- **Java:** lenguaje de programación.
- **Maven:** compilación y administración del proyecto.
- **Lombok:** generación automática de código repetitivo.
- **Git y GitHub:** control de versiones y entrega del trabajo.
- **UML:** representación gráfica de las clases y sus relaciones.

## Estructura del proyecto

Las clases están organizadas en los siguientes paquetes:

- `entidades.clientes`: contiene las clases relacionadas con los clientes.
- `entidades.cuentas`: contiene las clases relacionadas con las cuentas bancarias y los cheques.
- `test`: contiene los programas utilizados para probar las operaciones.

## Clases principales

### Clientes

- `Cliente`: clase abstracta que contiene el número identificador del cliente.
- `ClienteIndividual`: representa un cliente individual con nombre, apellido y DNI.
- `ClienteEmpresa`: representa una empresa con nombre de fantasía y CUIT.

### Cuentas

- `Cuenta`: clase abstracta que contiene el número de cuenta, el cliente titular, el saldo y las operaciones generales.
- `CajaAhorro`: permite depositar y extraer efectivo y cobrar intereses.
- `CuentaCorriente`: permite depositar efectivo, depositar cheques y utilizar un descubierto autorizado.
- `CuentaConvertibilidad`: hereda de `CuentaCorriente` y permite operar en pesos y dólares, además de convertir entre ambas monedas.
- `Cheque`: representa un cheque con monto, banco emisor y fecha de pago.

## Los cuatro pilares de la Programación Orientada a Objetos

### 1. Abstracción

Se aplica mediante las clases abstractas `Cliente` y `Cuenta`, que representan características y operaciones comunes a sus clases derivadas.

### 2. Encapsulamiento

Los atributos se declaran como `private`. Se utilizan getters y setters generados mediante Lombok para consultar y modificar los datos.

### 3. Herencia

Se reutilizan atributos y métodos mediante las siguientes relaciones:

- `ClienteIndividual` hereda de `Cliente`.
- `ClienteEmpresa` hereda de `Cliente`.
- `CajaAhorro` hereda de `Cuenta`.
- `CuentaCorriente` hereda de `Cuenta`.
- `CuentaConvertibilidad` hereda de `CuentaCorriente`.

### 4. Polimorfismo

Se utiliza la sobrescritura del método `debitarEfectivo()` en `CuentaCorriente`, mediante `@Override`, para permitir el uso del descubierto autorizado.

## Uso de Lombok

Lombok reduce el código repetitivo mediante anotaciones:

- `@Getter`: genera métodos para consultar atributos.
- `@Setter`: genera métodos para modificar atributos.
- `@ToString`: genera una representación textual del objeto.
- `@AllArgsConstructor`: genera un constructor con todos los atributos declarados en la clase.

En las clases derivadas se utiliza `@ToString(callSuper = true)` para incluir también la información heredada en la representación textual.

## Pruebas del proyecto

El proyecto contiene cuatro programas de prueba que utilizan `main()` y `System.out.println()` para mostrar los resultados en la consola.

- `TestCajaAhorro`: comprueba depósitos, extracciones e intereses.
- `TestCheque`: comprueba la creación y consulta de los datos de un cheque.
- `TestCuentaCorriente`: comprueba depósitos, extracciones con descubierto y depósitos de cheques.
- `TestCuentaConvertibilidad`: comprueba operaciones en pesos y dólares y conversiones de moneda.

Las pruebas se ejecutan individualmente desde Visual Studio Code mediante la opción **Run Java**.

También se verificó la compilación del proyecto mediante Maven.

## Compilación del proyecto

Desde la terminal, ubicada en la carpeta raíz del proyecto, se puede ejecutar:

```powershell
.\mvnw.cmd clean test
```

Este comando limpia los archivos compilados anteriores, compila el proyecto y ejecuta las pruebas automatizadas que Maven reconoce.

## Diagrama UML

El diagrama UML representa las clases del sistema, sus atributos, métodos, relaciones de herencia y asociaciones.

## Autor

Trabajo práctico individual de Java POO.
