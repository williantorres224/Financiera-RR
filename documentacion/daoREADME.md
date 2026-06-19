# dao
# ClienteDAO.java
# Descripción

La clase ClienteDAO es responsable de realizar operaciones relacionadas con los usuarios en la base de datos.

Implementa el patrón DAO (Data Access Object), permitiendo separar la lógica de acceso a datos de la lógica de negocio del sistema.

# Funcionalidades
Registrar usuarios.
Actualizar contraseñas.
Conectarse a MySQL mediante JDBC.
Ejecutar consultas SQL utilizando PreparedStatement.
Métodos
registrarUsuario()

Registra un nuevo usuario en la tabla usuarios.

# Parámetros
-------------------------------------------------------
Parámetro	    |   Tipo	|      Descripción        |
----------------|-----------|-------------------------|
nombre	        |   String	|  Nombre del usuario     |
----------------|-----------|-------------------------|
apellidoPaterno	|   String	|  Apellido paterno       |
----------------|-----------|-------------------------|
apellidoMaterno	|   String	|  Apellido materno       |
----------------|-----------|-------------------------|
dni	            |   String	|  Documento de identidad |
----------------|-----------|-------------------------|
clave	        |   String	|  Contraseña cifrada     |
----------------|-----------|-------------------------|
foto	        |   String	|  Ruta de la fotografía  |
-------------------------------------------------------
# Retorno
---------------------------------------------
Tipo    |	   Descripción                  |
--------|-----------------------------------|
boolean	|   true si el registro fue exitoso |
--------|-----------------------------------|
boolean	|   false si ocurrió un error       |
---------------------------------------------

# Consulta SQL
INSERT INTO usuarios
(nombre, apellido_paterno, apellido_materno, dni, clave, foto)
VALUES(?,?,?,?,?,?)
actualizarClave()

Actualiza la contraseña de un usuario existente.

# Parámetros
-------------------------------------------------
Parámetro	|   Tipo	|      Descripción      |
------------|-----------|-----------------------|
dni	String	|  DNI del  |      usuario          |
------------|-----------|-----------------------|             
nuevaClave	|  String   |	   Nueva contraseña |  
-------------------------------------------------
# Retorno
-----------------------------------------------------------------------
Tipo	   |              Descripción                                 |   
-----------|----------------------------------------------------------|
boolean	   |    true si la actualización fue exitosa                  |
-----------|----------------------------------------------------------|
boolean	   |    false si no se encontró el usuario o ocurrió un error |
-----------------------------------------------------------------------

# Consulta SQL
UPDATE usuarios
SET clave = ?
WHERE dni = ?
# Tecnologías utilizadas
1-> Java
2-> JDBC
3-> MySQL
4-> PreparedStatement
5-> SQL
6-> Seguridad

La clase utiliza PreparedStatement, lo que ayuda a prevenir ataques de inyección SQL mediante consultas parametrizadas.

# elación con el sistema

Esta clase es utilizada por:

>RegistroFrame.java
>LoginFrame.java
>Sistema de recuperación de contraseña

Permite administrar la información de los usuarios almacenados en la base de datos del sistema Financiera R&R.
------------------------------------------------------------------------------

# Conexion.java

# Descripción

La clase Conexion es responsable de establecer la conexión entre la aplicación Financiera R&R y la base de datos MySQL.

Utiliza JDBC (Java Database Connectivity) para permitir que las demás clases del sistema puedan realizar consultas, inserciones, actualizaciones y eliminaciones de datos.

# Configuración
URL
<private static final String URL =
    "jdbc:mysql://localhost:3306/financiera";

Define la dirección de la base de datos MySQL.

# Usuario
<private static final String USUARIO =
    System.getenv("DB_USER");

Obtiene el nombre de usuario desde una variable de entorno del sistema operativo.

# Contraseña
private static final String CLAVE =
    System.getenv("DB_PASS");

Obtiene la contraseña desde una variable de entorno.

# Seguridad

El uso de variables de entorno evita almacenar credenciales directamente en el código fuente.

# Variables utilizadas
DB_USER
DB_PASS

Esto mejora la seguridad del proyecto y evita exponer información sensible al subir el código a GitHub.

# Método
>conectar()

Establece la conexión con MySQL.

# Retorno
---------------------------------------------------------------
Tipo	        |       Descripción                           |  
----------------|---------------------------------------------|
Connection	    |      Objeto de conexión a la base de datos  |
----------------|---------------------------------------------|
null	        |      Si ocurre un error durante la conexión |
---------------------------------------------------------------
# Funcionamiento
Carga el controlador JDBC de MySQL.
Intenta conectarse utilizando las credenciales configuradas.
Retorna el objeto Connection.
Muestra mensajes de éxito o error en consola.
Código utilizado
Class.forName(
    "com.mysql.cj.jdbc.Driver"
);

conexion =
    DriverManager.getConnection(
        URL,
        USUARIO,
        CLAVE
    );

# Tecnologías utilizadas
1-> Java
2-> JDBC
3-> MySQL
4-> Driver MySQL Connector/J
5-> Ventajas de la implementación
6-> Centraliza la conexión a la base de datos.
7-> Facilita el mantenimiento del sistema.
8-> Permite reutilizar la conexión desde cualquier módulo.
9-> Mejora la seguridad mediante variables de entorno.
10-> Relación con el sistema

La clase Conexion es utilizada por:

>Login.java
>ClienteDAO.java
>CuentaDAO.java
>MovimientoDAO.java

Es la puerta de acceso principal entre la aplicación y la base de datos MySQL.
------------------------------------------------------------------------------

# CuentaDAO.java
# Descripción

La clase CuentaDAO implementa el patrón DAO (Data Access Object) y es responsable de administrar las operaciones relacionadas con usuarios, cuentas bancarias y transacciones almacenadas en la base de datos MySQL.

Permite registrar usuarios, crear cuentas bancarias automáticamente, realizar depósitos, retiros, transferencias y consultar saldos.

# Funcionalidades principales
1- Registro de usuarios.
2- Creación automática de cuentas bancarias.
3- Actualización de contraseñas.
4- Consulta de saldo.
5- Depósitos.
6- Retiros.
7- Validación de cuentas.
8- Transferencias entre cuentas.
9- Gestión de transacciones SQL.
# Métodos
registrarUsuario()

Registra un nuevo usuario en la tabla usuarios.

Posteriormente crea automáticamente una cuenta bancaria asociada al usuario en la tabla cuentas.

# Tablas utilizadas
usuarios
cuentas
Retorno
boolean
true → Registro exitoso.
false → Error durante el registro.
actualizarClave()

Actualiza la contraseña de un usuario mediante su DNI.

# Consulta SQL
UPDATE usuarios
SET clave = ?
WHERE dni = ?
depositar()

Incrementa el saldo de una cuenta bancaria.

# Parámetros
int idUsuario
double monto
Consulta SQL
UPDATE cuentas
SET saldo = saldo + ?
WHERE id_usuario = ?
consultarSaldo()

Obtiene el saldo actual de una cuenta bancaria.

# Parámetro
int idUsuario
Retorno
double

Saldo actual del usuario.

Consulta SQL
SELECT saldo
FROM cuentas
WHERE id_usuario = ?
retirar()

Reduce el saldo disponible si existen fondos suficientes.

# Consulta SQL
UPDATE cuentas
SET saldo = saldo - ?
WHERE id_usuario = ?
AND saldo >= ?
Retorno
true → Retiro exitoso.
false → Saldo insuficiente.
existeCuenta()

Verifica si una cuenta bancaria existe en la base de datos.

# Consulta SQL
SELECT *
FROM cuentas
WHERE numero_cuenta = ?
Retorno
boolean
true → La cuenta existe.
false → La cuenta no existe.
transferir()

Realiza una transferencia bancaria entre cuentas.

# Funcionamiento
1->Inicia una transacción SQL.
2->Retira el dinero de la cuenta origen.
3->Deposita el dinero en la cuenta destino.
4->Confirma los cambios mediante COMMIT.
5->En caso de error ejecuta ROLLBACK.

# Consulta de retiro
UPDATE cuentas
SET saldo = saldo - ?
WHERE id_usuario = ?
AND saldo >= ?
Consulta de depósito
UPDATE cuentas
SET saldo = saldo + ?
WHERE numero_cuenta = ?
# Características
Utiliza transacciones SQL.
Garantiza integridad de los datos.
Evita pérdidas de dinero por errores durante la transferencia.
Tecnologías utilizadas
Java
JDBC
MySQL
PreparedStatement
ResultSet
SQL Transactions
Seguridad

La clase utiliza:

PreparedStatement

para evitar ataques de inyección SQL.

Además implementa:

con.setAutoCommit(false);
con.commit();
con.rollback();

para garantizar operaciones financieras seguras.

Relación con el sistema

La clase es utilizada por:

>LoginFrame.java
>RegistroFrame.java
>Deposito.java
>Retiro.java
>Transferencia.java
>ConsultaSaldo.java

Es el componente encargado de conectar las operaciones bancarias del sistema con la base de datos MySQL.