package vistas;

import javax.swing.*;

import cuentas.CuentaAhorros;
import reportes.HistorialMovimientos;

public class TransferenciaFrame extends JFrame {

    private JLabel lblMonto;

    private JTextField txtMonto;

    private JButton btnTransferir;

    private CuentaAhorros cuenta;

    public TransferenciaFrame(
            CuentaAhorros cuenta
    ) {

        this.cuenta = cuenta;

        setTitle("Transferencia");

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

        btnTransferir =
            new JButton("Transferir");

        btnTransferir.setBounds(
            90,
            100,
            140,
            30
        );

        add(btnTransferir);

btnTransferir.addActionListener(e -> {

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
            "¿Está seguro de realizar esta transferencia?",
            "Confirmar transferencia",
            JOptionPane.YES_NO_OPTION
        );

    if(opcion == JOptionPane.YES_OPTION) {

        boolean transferencia =
            cuenta.retirar(monto);

   if(transferencia) {

    HistorialMovimientos.movimientos.add(
        "Transferencia de S/ "
        + monto
    );

    JOptionPane.showMessageDialog(
        null,
        "Transferencia realizada\n"
        + "Nuevo saldo: "
        + cuenta.consultarSaldo()
    );


        } else {

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