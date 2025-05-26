package model;

import java.util.UUID;

public class Usuario {

    private final UUID id;
    private final String nombre;
    private final String dni;
    private final String direccion;
    private final TIPOUSUARIO tipoUsuario;

    private Usuario(UUID id, String nombre, String dni, String direccion, TIPOUSUARIO tipoUsuario){
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.tipoUsuario = tipoUsuario;
    }

    public static Usuario crearUsuario(UUID id, String nombre, String dni, String direccion, TIPOUSUARIO tipoUsuario){
        return new Usuario(id, nombre, dni, direccion, tipoUsuario);
    }

    public UUID getId() { return id; }

    public String getNombre() {return nombre;}

    public String getDni() {return dni;}

    public String getDireccion() {return direccion;}

    public TIPOUSUARIO getTipoUsuario() {return tipoUsuario;}
}
