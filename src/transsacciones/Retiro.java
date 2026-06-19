package transsacciones;

import cuentas.CuentaAhorros;
import dao.CuentaDAO;

public class Retiro {

    public void realizar(
            CuentaAhorros cuenta,
            double monto
    ) {

        if(monto > 0) {

            boolean actualizado =
                CuentaDAO.retirar(
                    cuenta.getCliente().getId(),
                    monto
                );

            if(actualizado) {

                cuenta.retirar(monto);

                System.out.println(
                    "Retiro realizado"
                );

            } else {

                System.out.println(
                    "Saldo insuficiente"
                );
            }

        } else {

            System.out.println(
                "Monto inválido"
            );
        }
    }
}