package vistas;

import javax.swing.*;

import cuentas.CuentaAhorros;

public class ConsultaSaldorFrame extends JFrame {

    private JLabel lblSaldo;

    private CuentaAhorros cuenta;

    public ConsultaSaldorFrame(
            CuentaAhorros cuenta
    ) {

        this.cuenta = cuenta;

        setTitle("Consultar Saldo");

        setSize(350, 200);

        setLayout(null);    

        setLocationRelativeTo(null);

        lblSaldo = new JLabel(
            "Saldo actual: "
            + cuenta.consultarSaldo()
        );

        lblSaldo.setBounds(
            60,
            60,
            250,
            30
        );

        add(lblSaldo);

        setVisible(true);
    }
}