package autenticacion;

import javax.swing.JOptionPane;

public class HuellaDigital {

    public boolean verificarHuella() {

        String codigo =
            JOptionPane.showInputDialog(
                "Ingrese codigo de huella"
            );

        return codigo.equals("1234");
    }
}