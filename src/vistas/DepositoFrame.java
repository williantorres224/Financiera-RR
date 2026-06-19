package vistas;

import javax.swing.*;

import transsacciones.Deposito;

import cuentas.CuentaAhorros;
import dao.CuentaDAO;
import reportes.HistorialMovimientos;

public class DepositoFrame extends JFrame {

    private JLabel lblMonto;

    private JTextField txtMonto;


    private JButton btnDepositar;
    private JButton btnCerrar;

    private CuentaAhorros cuenta;

    public DepositoFrame(
            CuentaAhorros cuenta
    ) {

        this.cuenta = cuenta;

        setTitle("Depositar");
        setSize(350, 220);
        setLayout(null);
        setLocationRelativeTo(null);

        lblMonto = new JLabel("Monto:");
        lblMonto.setBounds(30, 40, 100, 25);
        add(lblMonto);

        txtMonto = new JTextField();
        txtMonto.setBounds(100, 40, 120, 25);
        add(txtMonto);

        btnDepositar = new JButton("Depositar");
        btnDepositar.setBounds(40, 100, 120, 30);
        add(btnDepositar);

        btnCerrar = new JButton("Cerrar");
        btnCerrar.setBounds(180, 100, 120, 30);
        add(btnCerrar);
 
        btnDepositar.addActionListener(e -> {

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
        "¿Está seguro de realizar este depósito?",
        "Confirmar depósito",
        JOptionPane.YES_NO_OPTION
    );

if(opcion == JOptionPane.YES_OPTION) {

    String[] opcionesDeposito = {
        "Mis cuentas",
        "Otra cuenta"
    };

    int tipoDeposito =
        JOptionPane.showOptionDialog(
            null,
            "¿Dónde desea depositar?",
            "Tipo de depósito",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opcionesDeposito,
            opcionesDeposito[0]
        );

    if(tipoDeposito == -1){
        return;
    }

    if(tipoDeposito == 0){

        Deposito deposito =
            new Deposito();

        deposito.realizar(
            cuenta,
            monto
        );

        HistorialMovimientos.movimientos.add(
            "Deposito a cuenta propia S/ "
            + monto
        );

        JOptionPane.showMessageDialog(
            null,
            "Nuevo saldo: "
            + cuenta.consultarSaldo()
        );

    } else {

String cuentaDestino =
    JOptionPane.showInputDialog(
        null,
        "Ingrese número de cuenta destino:"
    );

if(cuentaDestino == null ||
   cuentaDestino.isEmpty()) {

    return;
}

if(!CuentaDAO.existeCuenta(
        cuentaDestino
)) {

    JOptionPane.showMessageDialog(
        null,
        "La cuenta no existe"
    );

    return;
}

boolean transferenciaExitosa =
    CuentaDAO.transferir(
        cuenta.getCliente().getId(),
        cuentaDestino,
        monto
    );

if(transferenciaExitosa) {

    cuenta.retirar(
        monto
    );

    HistorialMovimientos.movimientos.add(
        "Transferencia de S/ "
        + monto
        + " a "
        + cuentaDestino
    );

    JOptionPane.showMessageDialog(
        null,
        "Transferencia realizada correctamente"
    );

} else {

    JOptionPane.showMessageDialog(
        null,
        "Saldo insuficiente"
    );
}

}
}

});

btnCerrar.addActionListener(e -> {

    dispose();

});

setVisible(true);

}

}

