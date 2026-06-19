package cuentas;

public class CuentaAhorros {

    private String numeroCuenta;

    private double saldo;

    private Cliente cliente;

    public CuentaAhorros(
            String numeroCuenta,
            double saldo,
            Cliente cliente
    ){

        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public void depositar(double monto){

        saldo += monto;
    }

    public boolean retirar(double monto){

        if(monto > saldo){

            return false;
        }

        saldo -= monto;

        return true;
    }

    public double consultarSaldo(){

        return saldo;
    }

    public String getNumeroCuenta(){

        return numeroCuenta;
    }

    public Cliente getCliente(){

        return cliente;
    }
}