package autenticacion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.Conexion;

public class Login {

    private String dni;

    private String contraseña;

    public Login(
            String dni,
            String contraseña
    ) {

        this.dni = dni;

        this.contraseña = contraseña;
    }

    public boolean iniciarSesion() {

        try {

            Connection con =
                Conexion.conectar();

            String sql =
                "SELECT * FROM usuarios WHERE dni=? AND clave=?";

            PreparedStatement ps =
                con.prepareStatement(sql);

            ps.setString(1, dni);

            ps.setString(2, contraseña);

            ResultSet rs =
                ps.executeQuery();

            boolean existe =
                rs.next();

            rs.close();

            ps.close();

            con.close();

            return existe;

        } catch(Exception e) {

            System.out.println(
                "Error login: "
                + e.getMessage()
            );

            return false;
        }
    }
    public int obtenerIdUsuario() {

try {

    Connection con =
        Conexion.conectar();

    String sql =
        "SELECT id FROM usuarios WHERE dni=?";

    PreparedStatement ps =
        con.prepareStatement(sql);

    ps.setString(1, dni);

    ResultSet rs =
        ps.executeQuery();

    if(rs.next()) {

        return rs.getInt("id");
    }

} catch(Exception e) {

    e.printStackTrace();
}

return -1;

}
}