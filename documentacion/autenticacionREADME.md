autenticación

## HuellaDigital.java

# Descripción
clase que simula una autenticación de reconocimiento mediante huella digital.

# Metodo principal 
verificarHuella()
solicita un codigo al usuario mediante una venta emergente.
true -> si el codigo es correcto.
false -> si el codigo es falso.

# codigo utilizable public boolean verificarHuella()
lo que hace es solo simulación academica y no utiliza un lector biometrico.

------------------------------------------------------------------------------

## login.java

# Discripción
clase que se encarga de validar los credenciales de acceso de los usuarios reguistrados en el sistema finaciero.

# atributos
dni -> almacena el numero de DNI ingresado por los usuarios.
private String dni;

contraseña -> almacena la contraseña ingresada por los usuarios.
private String contraseña;

# constructor
login(String dni, String contraseña)
inicializa un objeto login con los credenciales proporcionados por del usuario.
Parámetros
----------------------------------------------------
Parámetro	|  Tipo	   |      Descripción          |
------------|----------|---------------------------| 
dni	        | String   |	DNI del usuario        | 
------------|----------|---------------------------|
contraseña	| String   |	Contraseña del usuario |
----------------------------------------------------

# metodos
iniciarSesion()
verifica si los credenciales exiten en la base de datos

# Funcionamiento
1->Establece conexión con MySQL.
2->Ejecuta una consulta SQL utilizando PreparedStatement.
3->Busca un usuario con el DNI y contraseña proporcionados.
4->Devuelve el resultado de la validación.

# Retorno
Tipo 	  Descripción
boolean	  true si las credenciales son correctas, false en caso contrario

# Consulta SQL utilizada
SELECT * FROM usuarios
WHERE dni=? AND clave=?

Tecnologías utilizadas
Java
JDBC
MySQL
PreparedStatement
ResultSet
Seguridad

La clase utiliza PreparedStatement, lo que ayuda a prevenir ataques de inyección SQL al parametrizar las consultas realizadas a la base de datos.

Relación con el sistema

Esta clase es utilizada por:

LoginFrame.java
UsuarioSistema.java
Menú Principal

Permite controlar el acceso de los usuarios al sistema financiero R&R.
dato <contraseña se compara usando el hash almacenado en la base de datos, no texto plano>
------------------------------------------------------------------------------
# ReconocimientoFacial.java

# Descripción

La clase ReconocimientoFacial simula un sistema de autenticación mediante reconocimiento facial dentro del sistema financiero.

Actualmente es una implementación de prueba que representa el proceso de validación biométrica de un usuario.

# Método
vereficarReconocimientoFacial()

Simula una verificación facial mostrando un mensaje en consola.

# Funcionamiento
Muestra el mensaje:
vereficación de rostro...
Retorna un valor booleano indicando que la validación fue exitosa.
Retorno
Tipo	   Descripción
boolean	   true cuando la verificación es considerada exitosa

# ódigo principal
public boolean vereficarReconocimientoFacial() {
    System.out.println("vereficación de rostro...");
    return true;
}
# Observaciones

Esta implementación es una simulación académica y no utiliza:

Cámara web.
Inteligencia artificial.
OpenCV.
Reconocimiento biométrico real.

Su propósito es representar cómo podría integrarse un sistema de reconocimiento facial en futuras versiones del proyecto.

# Mejoras futuras
1-Captura de imagen desde cámara web.
2-Detección de rostro.
3-Comparación facial con fotografías almacenadas.
4-Integración con OpenCV.
5-Autenticación biométrica real.
6-Relación con el sistema

Esta clase pertenece al módulo de autenticación y puede utilizarse como una capa adicional de seguridad antes de permitir el acceso al sistema financiero.

------------------------------------------------------------------------------
