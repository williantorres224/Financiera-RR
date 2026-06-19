package cuentas;

public class Cliente {

    private int id;

    private String nombre;

    private String dni;

    private String usuario;

    private String clave;

    public Cliente(

            int id,

            String nombre,

            String dni,

            String usuario,

            String clave

    ) {

        this.id = id;

        this.nombre = nombre;

        this.dni = dni;

        this.usuario = usuario;

        this.clave = clave;
    }

    public int getId() {

        return id;
    }

    public String getNombre() {

        return nombre;
    }

    public String getDni() {

        return dni;
    }

    public String getUsuario() {

        return usuario;
    }

    public String getClave() {

        return clave;
    }
}