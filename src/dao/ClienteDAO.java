package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClienteDAO {

public static boolean registrarUsuario(

        String nombre,
        String apellidoPaterno,
        String apellidoMaterno,
        String dni,
        String clave,
        String foto

) {

    try {

        Connection con =
            Conexion.conectar();

        String sql =
            "INSERT INTO usuarios(nombre, apellido_paterno, apellido_materno, dni, clave, foto) VALUES(?,?,?,?,?,?)";

        PreparedStatement ps =
            con.prepareStatement(sql);

        ps.setString(1, nombre);
        ps.setString(2, apellidoPaterno);
        ps.setString(3, apellidoMaterno);
        ps.setString(4, dni);
        ps.setString(5, clave);
        ps.setString(6, foto);

        int filas =
            ps.executeUpdate();

        System.out.println(
            "Filas insertadas: "
            + filas
        );

        con.close();

        return true;

    } catch(Exception e) {

        System.out.println(
            "Error: "
            + e.getMessage()
        );

        return false;
    }
}

public static boolean actualizarClave(
        String dni,
        String nuevaClave
) {

    try {

        Connection con =
            Conexion.conectar();

        String sql =
            "UPDATE usuarios SET clave = ? WHERE dni = ?";

        PreparedStatement ps =
            con.prepareStatement(sql);

        ps.setString(1, nuevaClave);
        ps.setString(2, dni);

        int filas =
            ps.executeUpdate();

        con.close();

        return filas > 0;

    } catch(Exception e) {

        System.out.println(
            "Error: "
            + e.getMessage()
        );

        return false;
    }
}

}