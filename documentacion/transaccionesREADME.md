# Módulo de Transacciones
# Descripción

El módulo de transacciones contiene las operaciones financieras principales del sistema Financiera R&R.

Permite realizar consultas de saldo, depósitos, retiros y transferencias entre cuentas bancarias.

Estas operaciones interactúan con la clase CuentaAhorros y con la base de datos mediante CuentaDAO.
------------------------------------------------------------------------------
# ConsultaSaldo.java

# Descripción

# Permite consultar el saldo actual de una cuenta bancaria.

-Funcionalidad
-Muestra el número de cuenta.
-Muestra el saldo disponible.
-Formatea el saldo con dos decimales.
-Método
-realizar(CuentaAhorros cuenta)
# Ejemplo de salida
Cuenta: CTA0001
Saldo actual: S/ 70.00
------------------------------------------------------------------------------
# Deposito.java

# Descripción

Permite realizar depósitos en una cuenta bancaria.

# Funcionamiento
Verifica que el monto sea mayor a cero.
Actualiza el saldo en memoria mediante CuentaAhorros.
Actualiza el saldo en MySQL mediante CuentaDAO.
Informa si la operación fue exitosa.
# Método
realizar(
    CuentaAhorros cuenta,
    double monto
)
# Validaciones
El monto debe ser mayor a cero.
La actualización en la base de datos debe completarse correctamente.
Ejemplo
deposito.realizar(
    cuenta,
    100
);
------------------------------------------------------------------------------
# Retiro.java

# Descripción

Permite retirar dinero de una cuenta bancaria.

# Funcionamiento
Verifica que el monto sea válido.
Solicita a CuentaDAO realizar el retiro.
Comprueba que exista saldo suficiente.
Actualiza el saldo de la cuenta.
Método
realizar(
    CuentaAhorros cuenta,
    double monto
)
# Validaciones
El monto debe ser mayor a cero.
El usuario debe disponer de saldo suficiente.
Mensajes posibles
Retiro realizado
Saldo insuficiente
------------------------------------------------------------------------------
# Transferencia.java

# Descripción

Permite transferir dinero entre dos cuentas bancarias.

# Funcionamiento
Retira el monto de la cuenta origen.
Deposita el monto en la cuenta destino.
Informa el resultado de la operación.
# Método
realizar(
    CuentaAhorros origen,
    CuentaAhorros destino,
    double monto
)
Ejemplo
transferencia.realizar(
    cuentaOrigen,
    cuentaDestino,
    50
);
# Mensajes posibles
Transferencia realizada correctamente
Saldo insuficiente para transferir
Tecnologías utilizadas
Java
Programación Orientada a Objetos (POO)
JDBC
MySQL
DAO Pattern
Relación con el sistema

# Este módulo interactúa con:

>CuentaAhorros.java
>Cliente.java
>CuentaDAO.java
>MenuFrame.java
>DepositoFrame.java
>RetiroFrame.java
>TransferenciaFrame.java

Es el núcleo de las operaciones financieras del sistema Financiera R&R.