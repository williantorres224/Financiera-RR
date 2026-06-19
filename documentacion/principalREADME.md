# main

# Main.java

# Descripción

La clase Main es el punto de entrada principal del sistema Financiera R&R.

Su función es iniciar la conexión con la base de datos y mostrar la ventana de inicio de sesión para que el usuario pueda autenticarse en el sistema.

# Método principal
<main()
public static void main(String[] args)

Es el primer método ejecutado por la JVM al iniciar la aplicación.

# Funcionamiento
1. Conexión a la base de datos
Conexion.conectar();

Establece la conexión con MySQL utilizando la clase Conexion.

Permite que el sistema pueda acceder a los datos almacenados en la base de datos.

2. Apertura de la ventana de inicio de sesión
new LoginFrame();

Muestra la interfaz gráfica de autenticación para que el usuario ingrese sus credenciales.

# Flujo de ejecución
Inicio del programa
        │
        ▼
Conectar a MySQL
        │
        ▼
Mostrar LoginFrame
        │
        ▼
Validar usuario
        │
        ▼
Acceder al sistema

# Tecnologías utilizadas
1- Java
2- JVM
3- Swing
4- JDBC
5- MySQL

Relación con el sistema

# La clase Main interactúa con:

>Conexion.java
>LoginFrame.java

Es el punto de inicio de toda la aplicación Financiera R&R.
------------------------------------------------------------------------------
