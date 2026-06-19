package reportes;

import cuentas.CuentaAhorros;

public class ReporteMovimiento {

    public void mostrarMovimientos(
            CuentaAhorros cuenta
    ){

        System.out.println(
            "**** REPORTE MOVIMIENTOS ****"
        );

        System.out.println(
            "Numero cuenta: "
            + cuenta.getNumeroCuenta()
        );

        System.out.println(
            "Cliente: "
            + cuenta.getCliente().getNombre()
        );

        System.out.println(
            "Saldo actual: "
            + cuenta.consultarSaldo()
        );
    }
}