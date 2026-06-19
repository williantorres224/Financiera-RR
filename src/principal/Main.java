package principal;

import vistas.LoginFrame;
import dao.Conexion;

public class Main {

public static void main(String[] args) {

    Conexion.conectar();

    new LoginFrame();
}

}