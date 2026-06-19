package vistas;

import javax.swing.*;

import cuentas.CuentaAhorros;
import dao.CuentaDAO;
import reportes.HistorialMovimientos;

public class RetiroFrame extends JFrame {

    private JLabel lblMonto;

    private JTextField txtMonto;

    private JButton btnRetirar;

    private CuentaAhorros cuenta;

    public RetiroFrame(
            CuentaAhorros cuenta
    ) {

        this.cuenta = cuenta;

        setTitle("Retiro");

        setSize(350, 220);

        setLayout(null);

        setLocationRelativeTo(null);

        lblMonto =
            new JLabel("Monto:");

        lblMonto.setBounds(
            30,
            40,
            100,
            25
        );

        add(lblMonto);

        txtMonto =
            new JTextField();

        txtMonto.setBounds(
            100,
            40,
            120,
            25
        );

        add(txtMonto);

        btnRetirar =
            new JButton("Retirar");

        btnRetirar.setBounds(
            90,
            100,
            140,
            30
        );

        add(btnRetirar);

        btnRetirar.addActionListener(e -> {

            String montoTexto =
                txtMonto.getText();

            if(montoTexto.isEmpty()) {

                JOptionPane.showMessageDialog(
                    null,
                    "Ingrese un monto"
                );

                return;
            }

            double monto;

            try {

                monto =
                    Double.parseDouble(
                        montoTexto
                    );

            } catch(NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                    null,
                    "Ingrese un número válido"
                );

                return;
            }

            int opcion =
                JOptionPane.showConfirmDialog(
                    null,
                    "¿Está seguro de realizar este retiro?",
                    "Confirmar retiro",
                    JOptionPane.YES_NO_OPTION
                );

            if(opcion == JOptionPane.YES_OPTION) {

            boolean retiroExitoso =
    CuentaDAO.retirar(
        cuenta.getCliente().getId(),
        monto
    );

if(retiroExitoso){

    cuenta.retirar(monto);

    HistorialMovimientos.movimientos.add(
        "Retiro de S/ "
        + monto
    );

    JOptionPane.showMessageDialog(
        null,
        "Nuevo saldo: "
        + cuenta.consultarSaldo()
    );

}else{

    JOptionPane.showMessageDialog(
        null,
        "Saldo insuficiente"
    );
}    
            }
        });

        setVisible(true);
    }
}