# Módulo Util

# Descripción

El módulo util contiene clases auxiliares utilizadas por el sistema Financiera R&R.

Su objetivo es proporcionar funcionalidades de apoyo relacionadas con la seguridad y el procesamiento de datos.
------------------------------------------------------------------------------
# HashUtil.java

# Descripción

La clase HashUtil permite cifrar texto utilizando el algoritmo criptográfico SHA-256.

Es utilizada principalmente para proteger las contraseñas de los usuarios antes de almacenarlas en la base de datos.

Método
hash()
public static String hash(
        String texto
)

Convierte un texto plano en un hash SHA-256.

# Parámetros
--------------------------------------------------
Parámetro	 Tipo  |	   Descripción           |
-------------------|-----------------------------|
texto	    String | 	  Texto que será cifrado |
-------------------|------------------------------

# Retorno
---------------------------------------------
Tipo	|     Descripción                   |
--------|-----------------------------------|
String	|    Hash generado mediante SHA-256 |
---------------------------------------------

Ejemplo
Entrada
123456
Salida
8d969eef6ecad3c29a3a629280e686cf...
# Tecnologías utilizadas
1- Java
2- MessageDigest
3- SHA-256
4- Beneficios
# Protege contraseñas.
Evita almacenar claves en texto plano.
Incrementa la seguridad del sistema.

------------------------------------------------------------------------------
# TokenSeguridad.java

# Descripción

La clase TokenSeguridad genera códigos numéricos aleatorios de seis dígitos.

Puede utilizarse como mecanismo de verificación para recuperación de contraseña, autenticación de dos factores o validaciones adicionales de seguridad.

# Método
>generarToken()
>public String generarToken()

Genera un código aleatorio de seis dígitos.

# Retorno
------------------------------------------
Tipo    |	   Descripción               |
--------|--------------------------------|
String	|  Token de seguridad generado   |
------------------------------------------

Ejemplo
Posibles resultados
583291
104728
875412
# Tecnologías utilizadas
1- Java
2- Random
3- Aplicaciones futuras
4- Recuperación de contraseña.
5- Verificación por correo electrónico.
6- Autenticación en dos pasos (2FA).
7- Confirmación de operaciones bancarias.
9- Relación con el sistema

# Las clases del módulo util son utilizadas por:

>RegistroFrame.java
>Login.java
>CuentaDAO.java
>Sistema de recuperación de contraseña

y proporcionan mecanismos adicionales de seguridad para la aplicación Financiera R&R.