package vistas;

import javax.swing.*;
import util.HashUtil;
import dao.CuentaDAO;

public class RegistroFrame extends JFrame {

    private JLabel lblNombre;
    private JLabel lblPaterno;
    private JLabel lblMaterno;
    private JLabel lblDni;
    private JLabel lblClave;
    private JLabel lblConfirmarClave;
    private JPasswordField txtConfirmarClave;
    private JTextField txtNombre;
    private JTextField txtPaterno;
    private JTextField txtMaterno;
    private JTextField txtDni;
    private JCheckBox chkMostrarClave;

    private JPasswordField txtClave;

    private JButton btnRegistrar;

    public RegistroFrame() {

        setTitle("Registro");

        setSize(450, 500);

        setLayout(null);

        setLocationRelativeTo(null);

        // Nombre

        lblNombre =
            new JLabel("Nombre:");

        lblNombre.setBounds(
            40,
            40,
            120,
            25
        );

        add(lblNombre);

        lblConfirmarClave =
            new JLabel("Confirmar:");

        lblConfirmarClave.setBounds(
            40,
            280,
        120,
       25
        );

        add(lblConfirmarClave);

        txtConfirmarClave =
            new JPasswordField();

        txtConfirmarClave.setBounds(
           180,
           280,
       180,
      25
        );

        add(txtConfirmarClave);

        txtNombre =
            new JTextField();

        txtNombre.setBounds(
            180,
            40,
            180,
            25
        );

        add(txtNombre);

        // Apellido paterno

        lblPaterno =
            new JLabel("Apellido Paterno:");

        lblPaterno.setBounds(
            40,
            90,
            120,
            25
        );

        add(lblPaterno);

        txtPaterno =
            new JTextField();

        txtPaterno.setBounds(
            180,
            90,
            180,
            25
        );

        add(txtPaterno);

        // Apellido materno

        lblMaterno =
            new JLabel("Apellido Materno:");

        lblMaterno.setBounds(
            40,
            140,
            130,
            25
        );

        add(lblMaterno);

        txtMaterno =
            new JTextField();

        txtMaterno.setBounds(
            180,
            140,
            180,
            25
        );

        add(txtMaterno);

        // DNI

        lblDni =
            new JLabel("DNI:");

        lblDni.setBounds(
            40,
            190,
            120,
            25
        );

        add(lblDni);

        txtDni =
            new JTextField();

        txtDni.setBounds(
            180,
            190,
            180,
            25
        );

        add(txtDni);

 

        lblClave =
            new JLabel("Contraseña:");

        lblClave.setBounds(
            40,
            240,
            120,
            25
        );

        add(lblClave);

        txtClave =
            new JPasswordField();

        txtClave.setBounds(
            180,
            240,
            180,
            25
        );

        add(txtClave);

  

        btnRegistrar =
            new JButton("Registrar");

        btnRegistrar.setBounds(
            140,
            370,
            140,
            35
        );

        add(btnRegistrar);
        chkMostrarClave =
    new JCheckBox(
        "Mostrar contraseñas"
         );

        chkMostrarClave.setBounds(
           180,
           310,
       180,
      25
        );

        add(chkMostrarClave);

        btnRegistrar.addActionListener(e -> {

    String nombre =
        txtNombre.getText();

    String apellidoPaterno =
        txtPaterno.getText();

    String apellidoMaterno =
        txtMaterno.getText();

    String dni =
        txtDni.getText();

    String clave =
    String.valueOf(
        txtClave.getPassword()
        
        );
        String confirmarClave =
    String.valueOf(
        txtConfirmarClave.getPassword()
    );
    if(!clave.equals(confirmarClave)) {

    JOptionPane.showMessageDialog(
        null,
        "Las contraseñas no coinciden"
    );

    return;
}
    
        

String claveHash =
HashUtil.hash(
clave
);

if(nombre.isEmpty() ||
apellidoPaterno.isEmpty() ||
apellidoMaterno.isEmpty() ||
dni.isEmpty() ||
clave.isEmpty()) {

JOptionPane.showMessageDialog(
    null,
    "Debe completar todos los campos"
);

return;

}

if(!dni.matches("\\d{8}")) {

JOptionPane.showMessageDialog(
    null,
    "El DNI debe tener 8 dígitos"
);

return;

}

if(clave.length() < 6) {

JOptionPane.showMessageDialog(
    null,
    "La contraseña debe tener mínimo 6 caracteres"
);

return;

}

boolean registrado =
CuentaDAO.registrarUsuario(

    nombre,

    apellidoPaterno,

    apellidoMaterno,

    dni,

    claveHash,

    ""
);
            if(registrado) {

        JOptionPane.showMessageDialog(
            null,
            "Usuario registrado"
        );

        dispose();

    } else {

        JOptionPane.showMessageDialog(
            null,
            "Error al registrar"
        );
    }
});
chkMostrarClave.addActionListener(e -> {

    if(chkMostrarClave.isSelected()) {

        txtClave.setEchoChar(
            (char)0
        );

        txtConfirmarClave.setEchoChar(
            (char)0
        );

    } else {

        txtClave.setEchoChar('*');

        txtConfirmarClave.setEchoChar('*');
    }
});

setVisible(true);

    }
}

    