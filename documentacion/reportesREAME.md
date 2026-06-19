# reportes

# HistorialMovimientos.java

# Descripción

La clase HistorialMovimientos es responsable de almacenar temporalmente los movimientos realizados por los usuarios dentro del sistema financiero.

Utiliza una colección ArrayList para guardar el historial de operaciones ejecutadas durante la ejecución del programa.

# Estructura de datos

La clase utiliza:

ArrayList<String>

para almacenar los movimientos registrados.

Cada elemento de la lista representa una operación financiera.

Atributos
movimientos
public static ArrayList<String>
    movimientos =
        new ArrayList<>();

Lista estática compartida por toda la aplicación.

Permite almacenar registros como:

Deposito de S/ 100
Retiro de S/ 50
Transferencia de S/ 20
Características
Almacena movimientos en memoria.
Puede ser utilizada desde cualquier clase del sistema.
Conserva los registros mientras la aplicación permanezca abierta.
Facilita la generación de reportes.

# Ejemplo de uso
Registrar un movimiento
HistorialMovimientos.movimientos.add(
    "Deposito de S/ 100"
);
Mostrar movimientos
for(String movimiento :
    HistorialMovimientos.movimientos) {

    System.out.println(
        movimiento
    );
}
# Tecnologías utilizadas
1- Java
2- ArrayList
3- Java Collections Framework


Persistencia de datos

Los movimientos realizados por los usuarios son almacenados en la base de datos MySQL mediante la tabla:

movimientos

Esto permite conservar la información incluso después de cerrar la aplicación.

Cada operación financiera queda registrada con:

ID del usuario.
Tipo de movimiento.
Monto.
Fecha y hora de la operación.

Ejemplos:

Depósito
Retiro
Transferencia

La información puede ser consultada posteriormente para generar reportes y estados de cuenta.

# Mejoras futuras
Registrar fecha y hora de cada operación.
Generar reportes PDF.
Implementar filtros por fecha.

Relación con el sistema

La clase es utilizada por:

>DepositoFrame.java
>RetiroFrame.java
>TransferenciaFrame.java
>ReporteMovimiento.java

Permite mantener un historial temporal de las operaciones financieras realizadas por los usuarios.
------------------------------------------------------------------------------

# ReporteMovimiento.java

# Descripción

La clase ReporteMovimiento es responsable de generar un reporte básico de la cuenta bancaria de un cliente.

Muestra información relevante de la cuenta, incluyendo el número de cuenta, el nombre del titular y el saldo actual.

Su propósito es proporcionar un resumen rápido del estado de la cuenta.

Método
mostrarMovimientos()
public void mostrarMovimientos(
        CuentaAhorros cuenta
)

Genera un reporte en consola utilizando la información de una cuenta bancaria.

Parámetros
Parámetro	Tipo	Descripción
cuenta	CuentaAhorros	Cuenta que será utilizada para generar el reporte
Información mostrada

El reporte incluye:

Número de cuenta.
Nombre del cliente.
Saldo actual.
Ejemplo de salida
**** REPORTE MOVIMIENTOS ****

Numero cuenta: CTA0001

Cliente: Willian Torres

Saldo actual: 70.0
# Tecnologías utilizadas
1- Java
2- Programación Orientada a Objetos (POO)
3- Encapsulamiento
4- Asociación entre clases
5- Relación con el sistema

La clase utiliza:

>CuentaAhorros.java
>Cliente.java

para obtener la información necesaria para construir el reporte.

Mejoras futuras

Actualmente el reporte muestra únicamente información básica de la cuenta.

En futuras versiones se podría incluir:

1- Historial completo de movimientos.
2- Fecha y hora de operaciones.
3- Transferencias realizadas.
6- Exportación a PDF.

Estas mejoras permitirían acercar el sistema al funcionamiento de una entidad financiera real.
------------------------------------------------------------------------------
# ReportePDF.java

# Descripción

La clase ReportePDF es responsable de generar reportes en formato PDF para el sistema Financiera R&R.

Actualmente se encuentra implementada como una simulación, mostrando mensajes en consola que representan el proceso de generación del documento.

Su propósito es servir como base para futuras versiones que permitan exportar información financiera a archivos PDF reales.

# Método
generarReportePdf()
public void generarReportePdf()

Simula la generación de un reporte PDF.

# Funcionamiento

Al ejecutar el método se muestran los siguientes mensajes:

Generando reporte PDF...

Reporte generado correctamente

Estos mensajes indican el inicio y la finalización del proceso de generación del reporte.

Ejemplo de uso
ReportePDF reporte =
    new ReportePDF();

reporte.generarReportePdf();
Salida esperada
Generando reporte PDF...

Reporte generado correctamente
Tecnologías utilizadas
Java
Programación Orientada a Objetos (POO)
Estado actual

Actualmente la clase funciona como una simulación.

No genera archivos PDF reales ni almacena información en el sistema de archivos.

# Mejoras futuras

La implementación futura podría incluir:

1- Generación de archivos PDF reales.
2- Exportación del historial de movimientos.
3- Estado de cuenta bancario.
4- Fecha y hora de operaciones.
5- Información del titular.
6- Saldo disponible.
7- Logo institucional.
8- Firma digital.

Relación con el sistema

La clase podrá utilizar información proveniente de:

>Cliente.java
>CuentaAhorros.java
>CuentaDAO.java
>MovimientoDAO.java
>ReporteMovimiento.java

para construir reportes financieros completos en formato PDF.

# Objetivo

Permitir que los usuarios descarguen o impriman estados de cuenta similares a los utilizados por entidades financieras reales.