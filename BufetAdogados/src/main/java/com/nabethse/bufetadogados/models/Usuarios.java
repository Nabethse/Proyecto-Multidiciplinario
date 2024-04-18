
package com.nabethse.bufetadogados.models;

import java.util.ArrayList;

public class Usuarios {
    private String nombre;
    private String clave;

    public Usuarios(String nombre, String clave) {
        this.nombre = nombre;
        this.clave = clave;
    }
    public boolean validarIniciarSesion (){
        return nombre.equals("Fryda") && clave.equals("123");
    }
}


