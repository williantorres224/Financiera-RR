package vistas;

import javax.swing.*;

import reportes.HistorialMovimientos;

public class ReporteFrame extends JFrame {

    private JTextArea txtReporte;

    public ReporteFrame() {

        setTitle("Reportes");

        setSize(400, 300);

        setLayout(null);

        setLocationRelativeTo(null);

        txtReporte =
            new JTextArea();

        JScrollPane scroll =
            new JScrollPane(txtReporte);

        scroll.setBounds(
            20,
            20,
            340,
            200
        );

        add(scroll);

        for(String movimiento :
            HistorialMovimientos.movimientos) {

            txtReporte.append(
                movimiento + "\n"
            );
        }

        setVisible(true);
    }
}