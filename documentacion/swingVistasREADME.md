# vistasREADME.md

# Descripción

El paquete vistas contiene todas las interfaces gráficas del sistema Financiera R&R.

Estas ventanas permiten la interacción entre el usuario y las funcionalidades bancarias implementadas en el sistema.

Las interfaces fueron desarrolladas utilizando Java Swing.
---------------------------------------------------------------------------------

# LoginFrame.java

# Descripción

Ventana principal de autenticación.

Permite:

Iniciar sesión.
Registrarse.
Recuperar contraseña.
Mostrar u ocultar contraseña.
Funcionalidades
Validación de credenciales.
Obtención del ID del usuario.
Carga del saldo desde MySQL.
Apertura del menú principal.
Componentes
JTextField (DNI)
JPasswordField (Contraseña)
JCheckBox (Mostrar contraseña)
JButton (Ingresar)
JButton (Registrarse)
JButton (Recuperar)
---------------------------------------------------------------------------------
# RegistroFrame.java

# Descripción

Permite registrar nuevos usuarios dentro del sistema.

# Validaciones
Todos los campos son obligatorios.
DNI de exactamente 8 dígitos.
Contraseña mínima de 6 caracteres.
Confirmación de contraseña.
Cifrado SHA-256 antes de guardar.
Funcionalidades
Registro de usuario.
Creación automática de cuenta bancaria.
Mostrar/Ocultar contraseña.
Seguridad

Las contraseñas son cifradas utilizando:

HashUtil.hash()

antes de almacenarse en la base de datos.
---------------------------------------------------------------------------------
# MenuFrame.java

# Descripción

Es el menú principal del sistema financiero.

Desde esta ventana el usuario puede acceder a todas las operaciones bancarias.

Opciones disponibles
Transferencias
Depósitos
Consultar saldo
Retiros
Reportes
Salir
ConsultaSaldorFrame.java
# Descripción

Permite visualizar el saldo actual de la cuenta.

Información mostrada
Saldo disponible.
Ejemplo
Saldo actual: 70.00
---------------------------------------------------------------------------------

# DepositoFrame.java

# Descripción

Interfaz para realizar depósitos y transferencias.

Funcionalidades
Depósito a cuenta propia

Permite agregar dinero a la cuenta del usuario.

Transferencia a otra cuenta

Permite enviar dinero a otra cuenta registrada en el sistema.

# Validaciones
Monto obligatorio.
Monto numérico válido.
Confirmación de operación.
Verificación de existencia de la cuenta destino.
Integración

Utiliza:

>CuentaDAO.depositar()
>CuentaDAO.transferir()
---------------------------------------------------------------------------------

# RetiroFrame.java

# Descripción

Permite retirar dinero de una cuenta bancaria.

Validaciones
Monto obligatorio.
Formato numérico correcto.
Confirmación del retiro.
Verificación de saldo suficiente.
Integración

Utiliza:
CuentaDAO.retirar()

para actualizar el saldo en MySQL.
---------------------------------------------------------------------------------

# TransferenciaFrame.java

# Descripción

Permite transferencias básicas entre cuentas.

Funcionalidades
Validación del monto.
Confirmación de la operación.
Descuento del saldo disponible.
Observación

Actualmente esta ventana trabaja principalmente sobre el objeto en memoria.

En futuras versiones puede integrarse completamente con:

CuentaDAO.transferir()

para registrar todas las transferencias directamente en MySQL.
---------------------------------------------------------------------------------

# ReporteFrame.java

# Descripción

Muestra el historial de movimientos realizados por el usuario.

Información mostrada
Depósitos.
Retiros.
Transferencias.
Componentes
JTextArea
JScrollPane
Fuente de datos
HistorialMovimientos.movimientos
# Tecnologías utilizadas
1- Java
2- Swing
3- JDBC
4- MySQL
5- Programación Orientada a Objetos (POO)

# Relación con el sistema

El paquete vistas interactúa con:

autenticacion
cuentas
dao
reportes
transsacciones
util

y constituye la capa de presentación del sistema Financiera R&R.