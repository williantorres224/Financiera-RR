package transsacciones;

import cuentas.CuentaAhorros;
import dao.CuentaDAO;

public class Deposito {

public void realizar(
        CuentaAhorros cuenta,
        double monto
) {

    if(monto > 0) {

        cuenta.depositar(
            monto
        );

        boolean actualizado =
            CuentaDAO.depositar(
                cuenta.getCliente().getId(),
                monto
            );

        if(actualizado) {

            System.out.println(
                "Deposito realizado"
            );

        } else {

            System.out.println(
                "Error al guardar deposito"
            );
        }

    } else {

        System.out.println(
            "Monto invalido"
        );
    }
}

}