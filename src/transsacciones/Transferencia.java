package transsacciones;


import cuentas.CuentaAhorros;

public class Transferencia {

    public void realizar(
            CuentaAhorros origen,
            CuentaAhorros destino,
            double monto) {

        if(origen.retirar(monto)) {

            destino.depositar(monto);

            System.out.println(
                "Transferencia realizada correctamente"
            );

        } else {

            System.out.println(
                "Saldo insuficiente para transferir"
            );
        }
    }
}