package vistas;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import javax.swing.JOptionPane;

import autenticacion.Login;
import dao.CuentaDAO;
import cuentas.Cliente;
import cuentas.CuentaAhorros;

public class LoginFrame extends JFrame {

    private JLabel lblDni;
    private JLabel lblClave;

    private JButton btnRecuperar;

    private JTextField txtDni;

    private JCheckBox chkMostrarClave;

    private JPasswordField txtClave;

    private JButton btnIngresar;
    private JButton btnRegistrarse;

    public LoginFrame() {

        setTitle("Financiera R&R");

        setSize(400, 300);

        setLayout(null);

        setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

      
        lblDni =
            new JLabel("DNI:");

        lblDni.setBounds(
            50,
            50,
            100,
            25
        );

        add(lblDni);

        txtDni =
            new JTextField();

        txtDni.setBounds(
            150,
            50,
            180,
            25
        );

        add(txtDni);

        chkMostrarClave =
            new JCheckBox(
        "Mostrar contraseña"
          );

        chkMostrarClave.setBounds(
          180,
          127,
      180,
     25
        );

        add(chkMostrarClave);

  

        lblClave =
            new JLabel("Contraseña:");

        lblClave.setBounds(
            50,
            100,
            100,
            25
        );

        add(lblClave);

        txtClave =
            new JPasswordField();

        txtClave.setBounds(
            150,
            100,
            180,
            25
        );

        add(txtClave);

    

        btnIngresar =
            new JButton("Ingresar");

        btnIngresar.setBounds(
            60,
            160,
            120,
            30
        );

        add(btnIngresar);



        btnRegistrarse =
            new JButton("Registrarse");

        btnRegistrarse.setBounds(
            200,
            160,
            120,
            30
        );

        add(btnRegistrarse);



        btnRecuperar =
            new JButton("Recuperar");

        btnRecuperar.setBounds(
            130,
            210,
            120,
            30
        );

        add(btnRecuperar);



        btnIngresar.addActionListener(e -> {

            String dni =
                txtDni.getText();

            String clave =
                String.valueOf(
                    txtClave.getPassword()
                );

            Login login =
                new Login(
                    dni,
                    clave
                );

            if(login.iniciarSesion()) {

                JOptionPane.showMessageDialog(
                    null,
                    "Bienvenido"
                );

            int idUsuario =
               login.obtenerIdUsuario();
               System.out.println(
    "ID LOGUEADO = " + idUsuario
);

                 Cliente cliente =
                   new Cliente(

                    idUsuario,

                    "Usuario",

                    dni,

                    dni,

                    clave
                );
                double saldo =
    CuentaDAO.consultarSaldo(
        idUsuario
    );

CuentaAhorros cuenta =
    new CuentaAhorros(

        "1223-2123-0989",

        saldo,

        cliente
    );
                dispose();

                new MenuFrame(cuenta);

            } else {

                JOptionPane.showMessageDialog(
                    null,
                    "dni incorrecto o contraseña incorrecto"
                );
            }
        });


        btnRegistrarse.addActionListener(e -> {

            new RegistroFrame();

        });



     btnRecuperar.addActionListener(e -> {

String dni =
    JOptionPane.showInputDialog(
        this,
        "Ingrese su DNI:"
    );

if(dni == null || dni.isEmpty()) {
    return;
}

String nuevaClave =
    JOptionPane.showInputDialog(
        this,
        "Ingrese su nueva contraseña:"
    );

if(nuevaClave == null || nuevaClave.isEmpty()) {
    return;
}

boolean actualizado =
    CuentaDAO.actualizarClave(
        dni,
        nuevaClave
    );

if(actualizado) {

    JOptionPane.showMessageDialog(
        this,
        "Contraseña actualizada correctamente"
    );

} else {

    JOptionPane.showMessageDialog(
        this,
        "No existe un usuario con ese DNI"
    );
}

});
chkMostrarClave.addActionListener(e -> {

    if(chkMostrarClave.isSelected()) {

        txtClave.setEchoChar(
            (char)0
        );

    } else {

        txtClave.setEchoChar('*');
    }
});

        setVisible(true);
    }
}