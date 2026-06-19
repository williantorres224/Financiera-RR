package transsacciones;

import cuentas.CuentaAhorros;

public class ConsultaSaldo {

    public void realizar(
            CuentaAhorros cuenta
    ){

        System.out.println(
            "Cuenta: "
            + cuenta.getNumeroCuenta()
        );

        System.out.printf(
    "Saldo actual: S/ %.2f%n",
            cuenta.consultarSaldo()
        );
    }
}