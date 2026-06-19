package cuentas;

public class CuentaCorriente extends CuentaAhorros {

    public CuentaCorriente(
            String numeroDeCuenta,
            double saldo,
            Cliente cliente){

        super(numeroDeCuenta, saldo, cliente);
    }

    public void saldoCuentaCorriente(){

        System.out.println(
            "Tu saldo de cuenta corriente es "
            + consultarSaldo()
        );
    }
}