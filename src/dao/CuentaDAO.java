package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CuentaDAO {

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
            con.prepareStatement(
                sql,
                Statement.RETURN_GENERATED_KEYS
            );

        ps.setString(1, nombre);
        ps.setString(2, apellidoPaterno);
        ps.setString(3, apellidoMaterno);
        ps.setString(4, dni);
        ps.setString(5, clave);
        ps.setString(6, foto);  
        
        int filas =
            ps.executeUpdate();

        if(filas > 0) {

            ResultSet rs =
                ps.getGeneratedKeys();

            if(rs.next()) {

                int idUsuario =
                    rs.getInt(1);

                String numeroCuenta =
                    "CTA" +
                    System.currentTimeMillis();

                String sqlCuenta =
                    "INSERT INTO cuentas(numero_cuenta, saldo, id_usuario) VALUES(?,?,?)";

                PreparedStatement psCuenta =
                    con.prepareStatement(
                        sqlCuenta
                    );

                psCuenta.setString(
                    1,
                    numeroCuenta
                );

                psCuenta.setDouble(
                    2,
                    0
                );

                psCuenta.setInt(
                    3,
                    idUsuario
                );

                psCuenta.executeUpdate();

                psCuenta.close();
            }
        }

        ps.close();
        con.close();

        return true;

    } catch(Exception e) {

        System.out.println(
            "ERROR SQL:"
        );

        e.printStackTrace();

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

        ps.close();
        con.close();

        return filas > 0;

    } catch(Exception e) {

        System.out.println(
            "ERROR SQL:"
        );

        e.printStackTrace();

        return false;
    }
}
public static boolean depositar(
    int idUsuario,
    double monto
) {

    try {

        Connection con =
            Conexion.conectar();

        String sql =
            "UPDATE cuentas SET saldo = saldo + ? WHERE id_usuario = ?";

        PreparedStatement ps =
            con.prepareStatement(sql);

        ps.setDouble(1, monto);
        ps.setInt(2, idUsuario);

        int filas =
            ps.executeUpdate();

        System.out.println(
            "Filas actualizadas: " + filas
        );

        ps.close();
        con.close();

        return filas > 0;

    } catch(Exception e) {

        e.printStackTrace();

        return false;
    }
}
public static double consultarSaldo(
int idUsuario
) {

try {

    Connection con =
        Conexion.conectar();

    String sql =
        "SELECT saldo FROM cuentas WHERE id_usuario = ?";

    PreparedStatement ps =
        con.prepareStatement(sql);

    ps.setInt(1, idUsuario);

    ResultSet rs =
        ps.executeQuery();

    if(rs.next()) {

        double saldo =
            rs.getDouble(
                "saldo"
            );

        rs.close();
        ps.close();
        con.close();

        return saldo;
    }

} catch(Exception e) {

    e.printStackTrace();
}

return 0;

}
public static boolean retirar(
    int idUsuario,
    double monto
) {

    try {

        Connection con =
            Conexion.conectar();

        String sql =
            "UPDATE cuentas SET saldo = saldo - ? " +
            "WHERE id_usuario = ? AND saldo >= ?";

        PreparedStatement ps =
            con.prepareStatement(sql);

        ps.setDouble(1, monto);
        ps.setInt(2, idUsuario);
        ps.setDouble(3, monto);

        int filas =
            ps.executeUpdate();

        ps.close();
        con.close();

        return filas > 0;

    } catch(Exception e) {

        e.printStackTrace();

        return false;
    }
}
public static boolean existeCuenta(
String numeroCuenta
) {

try {

    Connection con =
        Conexion.conectar();

    String sql =
        "SELECT * FROM cuentas WHERE numero_cuenta = ?";

    PreparedStatement ps =
        con.prepareStatement(sql);

    ps.setString(
        1,
        numeroCuenta
    );

    ResultSet rs =
        ps.executeQuery();

    boolean existe =
        rs.next();

    rs.close();
    ps.close();
    con.close();

    return existe;

} catch(Exception e) {

    e.printStackTrace();

    return false;
}

}
public static boolean transferir(
int idUsuarioOrigen,
String cuentaDestino,
double monto
) {

try {

    Connection con =
        Conexion.conectar();

    con.setAutoCommit(false);

    String sqlRetirar =
        "UPDATE cuentas SET saldo = saldo - ? " +
        "WHERE id_usuario = ? AND saldo >= ?";

    PreparedStatement psRetirar =
        con.prepareStatement(
            sqlRetirar
        );

    psRetirar.setDouble(1, monto);
    psRetirar.setInt(2, idUsuarioOrigen);
    psRetirar.setDouble(3, monto);

    int filasRetiro =
        psRetirar.executeUpdate();

    if(filasRetiro == 0) {

        con.rollback();

        return false;
    }

    String sqlDepositar =
        "UPDATE cuentas SET saldo = saldo + ? " +
        "WHERE numero_cuenta = ?";

    PreparedStatement psDepositar =
        con.prepareStatement(
            sqlDepositar
        );

    psDepositar.setDouble(1, monto);
    psDepositar.setString(2, cuentaDestino);

    psDepositar.executeUpdate();

    con.commit();

    psRetirar.close();
    psDepositar.close();
    con.close();

    return true;

} catch(Exception e) {

    e.printStackTrace();

    return false;
}

}
}