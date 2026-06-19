package vistas;

import javax.swing.JButton;
import javax.swing.JFrame;

import cuentas.CuentaAhorros;

public class MenuFrame extends JFrame {

    private JButton btnTransferir;
    private JButton btnDepositar;
    private JButton btnMostrarSaldo;
    private JButton btnCerrarSesion;
    private JButton btnRetiro;
    private JButton btnReportes;

    private CuentaAhorros cuenta;

    public MenuFrame(
            CuentaAhorros cuenta
    ) {

        this.cuenta = cuenta;

        setTitle("Menu Principal");
        setSize(400, 420);
        setLayout(null);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE
        );

        btnTransferir =
            new JButton("Transferir");

        btnTransferir.setBounds(
            100,
            30,
            180,
            30
        );

        add(btnTransferir);

        btnDepositar =
            new JButton("Depositar");

        btnDepositar.setBounds(
            100,
            80,
            180,
            30
        );

        add(btnDepositar);

        btnMostrarSaldo =
            new JButton("Consultar Saldo");

        btnMostrarSaldo.setBounds(
            100,
            130,
            180,
            30
        );

        add(btnMostrarSaldo);

        btnRetiro =
            new JButton("Retiro");

        btnRetiro.setBounds(
            100,
            180,
            180,
            30
        );

        add(btnRetiro);

        btnReportes =
            new JButton("Reportes");

        btnReportes.setBounds(
            100,
            230,
            180,
            30
        );

        add(btnReportes);

        btnCerrarSesion =
            new JButton("Salir");

        btnCerrarSesion.setBounds(
            100,
            280,
            180,
            30
        );

        add(btnCerrarSesion);

        btnTransferir.addActionListener(e -> {

            new TransferenciaFrame(cuenta);

        });

        btnDepositar.addActionListener(e -> {

            new DepositoFrame(cuenta);

        });

        btnMostrarSaldo.addActionListener(e -> {

            new ConsultaSaldorFrame(cuenta);

        });

        btnRetiro.addActionListener(e -> {

            new RetiroFrame(cuenta);

        });

        btnCerrarSesion.addActionListener(e -> {

            dispose();

        });
        btnReportes.addActionListener(e -> {

            new ReporteFrame();

        });

        setVisible(true);
    }
}