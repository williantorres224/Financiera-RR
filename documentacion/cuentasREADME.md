# cuentas

Cliente.java
# Descripción

La clase Cliente representa a un usuario registrado dentro del sistema financiero.

Su función es almacenar la información personal y de acceso de un cliente, permitiendo que otras clases del sistema puedan consultar sus datos mediante métodos de acceso (getters).

# Atributos
id
private int id;

Identificador único del cliente.

# nombre
private String nombre;

Nombre completo del cliente.

dni
private String dni;

Documento Nacional de Identidad del cliente.

# usuario
private String usuario;

Nombre de usuario utilizado para identificarse en el sistema.

# clave
private String clave;

Contraseña asociada al cliente.

# Constructor
Cliente()

Inicializa un objeto cliente con todos sus datos.

# Parámetros
----------------------------------------------------
Parámetro	Tipo    |	  Descripción              |
--------------------|------------------------------|
id	        int	    |    Identificador del cliente |
--------------------|------------------------------|
nombre	    String  |	 Nombre del cliente        |
--------------------|------------------------------|
dni	        String  | 	 Documento de identidad    | 
--------------------|------------------------------|
usuario	    String  |	 Usuario del sistema       |  
--------------------|------------------------------|
clave	    String  |	 Contraseña                | 
----------------------------------------------------
Ejemplo
Cliente cliente =
    new Cliente(
        1,
        "Willian Torres",
        "71779927",
        "willian",
        "123456"
    );
# Métodos
getId()

Obtiene el identificador del cliente.

<public int getId()
getNombre()>

Obtiene el nombre del cliente.

<public String getNombre()
getDni()>

Obtiene el DNI del cliente.

<public String getDni()
getUsuario()>

Obtiene el nombre de usuario.

<public String getUsuario()
getClave()>

Obtiene la contraseña almacenada.

public String getClave()

# Tecnologías utilizadas
1-> Java
2-> Programación Orientada a Objetos (POO)
3-> Encapsulamiento
4-> Constructores
5-> Métodos Getter
6-> Relación con el sistema

La clase Cliente es utilizada por:

CuentaAhorros.java
CuentaCorriente.java
Login.java
MenuFrame.java
TransferenciaFrame.java

Permite representar al titular de una cuenta bancaria dentro del sistema Financiera R&R.
------------------------------------------------------------------------------

# CuentaAhorros.java
# Descripción

La clase CuentaAhorros representa una cuenta bancaria de ahorros dentro del sistema Financiera R&R.

Permite realizar operaciones básicas como depósitos, retiros y consultas de saldo, además de mantener la relación con el cliente propietario de la cuenta.

# Atributos
numeroCuenta
private String numeroCuenta;

Número único que identifica la cuenta bancaria.

# saldo
private double saldo;

Saldo actual disponible en la cuenta.

# cliente
private Cliente cliente;

Cliente propietario de la cuenta.

# Constructor
CuentaAhorros()

Inicializa una nueva cuenta de ahorros.

# Parámetros
Parámetro	Tipo	Descripción
numeroCuenta	String	Número de cuenta
saldo	double	Saldo inicial
cliente	Cliente	Titular de la cuenta
Ejemplo
CuentaAhorros cuenta =
    new CuentaAhorros(
        "CTA0001",
        1000,
        cliente
    );
# Métodos
depositar(double monto)

Incrementa el saldo de la cuenta.

# Parámetros
Parámetro	Tipo	Descripción
monto	double	Cantidad a depositar
Ejemplo
cuenta.depositar(100);
retirar(double monto)

Permite retirar dinero si existe saldo suficiente.

# Retorno
Valor	Significado
true	Retiro realizado correctamente
false	Saldo insuficiente
Ejemplo
boolean resultado =
    cuenta.retirar(50);
consultarSaldo()

Obtiene el saldo actual de la cuenta.

Retorno
double

Saldo disponible.

Ejemplo
double saldo =
    cuenta.consultarSaldo();
getNumeroCuenta()

Obtiene el número de cuenta.

Retorno
String

Número de cuenta.

getCliente()

Obtiene el titular de la cuenta.

Retorno
Cliente

Objeto cliente asociado a la cuenta.

# Tecnologías aplicadas
1-> Programación Orientada a Objetos (POO)
2-> Encapsulamiento
3-> Asociación entre clases
4-> Métodos de negocio
5-> Relación con el sistema

La clase CuentaAhorros es utilizada por:

>Deposito.java
>Retiro.java
>Transferencia.java
>ConsultaSaldo.java
>MenuFrame.java
>DepositoFrame.java
>RetiroFrame.java

Representa el núcleo de las operaciones financieras del sistema.
------------------------------------------------------------------------------
# CuentaCorriente.java
# Descripción

La clase CuentaCorriente representa una cuenta corriente dentro del sistema Financiera R&R.

Esta clase hereda todas las características de CuentaAhorros, incluyendo el manejo de saldo, depósitos, retiros y la asociación con un cliente.

Además, incorpora un método para mostrar el saldo actual de la cuenta corriente.

# Herencia
public class CuentaCorriente
    extends CuentaAhorros

La clase hereda de:

CuentaAhorros

Por lo tanto, puede utilizar:

>depositar()
>retirar()
>consultarSaldo()
>getNumeroCuenta()
>getCliente()
>Constructor
>CuentaCorriente()

Inicializa una nueva cuenta corriente.

# Parámetros
------------------------------------------------------
Parámetro	   |   Tipo	    |      Descripción       |
-----------------------------------------------------|                        
numeroDeCuenta |  String	|    Número de cuenta    |
-----------------------------------------------------|
saldo	       |  double	|     Saldo inicial      |
-----------------------------------------------------|                        
cliente	       |  Cliente	|    Titular de la cuenta|

------------------------------------------------------
Ejemplo
CuentaCorriente cuenta =
    new CuentaCorriente(
        "CTA0002",
        500,
        cliente
    );
Métodos
saldoCuentaCorriente()

Muestra en consola el saldo actual de la cuenta corriente.

Funcionamiento

Obtiene el saldo mediante el método heredado:

consultarSaldo()

y lo muestra en pantalla.

# Ejemplo de salida

Tu saldo de cuenta corriente es 500.0
Tecnologías aplicadas
Programación Orientada a Objetos (POO)
Herencia
Polimorfismo
Reutilización de código
Relación con el sistema

La clase CuentaCorriente hereda la lógica principal de CuentaAhorros y permite representar otro tipo de cuenta bancaria dentro del sistema.

Actualmente comparte las mismas operaciones financieras:

-Consulta de saldo
-Depósitos
-Retiros

En futuras versiones podría incluir funcionalidades exclusivas de cuentas corrientes, como:

Sobregiro.
Cheques.
Límites de crédito.
Comisiones bancarias.