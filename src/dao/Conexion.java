package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

private static final String URL =
    "jdbc:mysql://localhost:3306/financiera";

private static final String USUARIO =
    System.getenv("DB_USER");

private static final String CLAVE =
    System.getenv("DB_PASS");

public static Connection conectar() {

    Connection conexion = null;

    try {

        Class.forName(
            "com.mysql.cj.jdbc.Driver"
        );

        conexion =
            DriverManager.getConnection(
                URL,
                USUARIO,
                CLAVE
                
            );
            

        System.out.println(
            "Conexion exitosa"
        );

    } catch(Exception e) {

        System.out.println(
            "Error: " + e.getMessage()
        );

        e.printStackTrace();
    }

    return conexion;
}

}