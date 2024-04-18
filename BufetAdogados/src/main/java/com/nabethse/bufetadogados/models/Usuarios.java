
package com.nabethse.bufetadogados.models;

import java.util.ArrayList;

public class Usuarios {
    private String nombre;
    private String tipoUsuario;
    private int clave;
    private String correo;



    public Usuarios(String nombre, String tipoUsuario, String correo, int clave) {
        this.nombre = nombre;
        this.tipoUsuario = tipoUsuario;
        this.correo = correo;
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public int getClave() {
        return clave;
    }




}
