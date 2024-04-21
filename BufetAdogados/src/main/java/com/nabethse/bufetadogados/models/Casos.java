// Clase Casos
package com.nabethse.bufetadogados.models;

import java.util.ArrayList;

public class Casos {
    private String nombreCaso;
    private String tipoCaso;
    private String nombreAbogado;
    private String informacion;
    private int numerocaso;

    private  ArrayList<Casos> casosList = new ArrayList<>();

    public Casos(String nombreCaso, String tipoCaso, String nombreAbogado, String informacion, int numerocaso) {
        this.nombreCaso = nombreCaso;
        this.tipoCaso = tipoCaso;
        this.nombreAbogado = nombreAbogado;
        this.informacion = informacion;
        this.numerocaso = numerocaso;
    }

    public void setNombreCaso(String nombreCaso) {
        this.nombreCaso = nombreCaso;
    }

    public void setTipoCaso(String tipoCaso) {
        this.tipoCaso = tipoCaso;
    }

    public void setNombreAbogado(String nombreAbogado) {
        this.nombreAbogado = nombreAbogado;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public void setNumerocaso(int numerocaso) {
        this.numerocaso = numerocaso;
    }

    public String getNombreCaso() {
        return nombreCaso;
    }

    public String getTipoCaso() {
        return tipoCaso;
    }

    public String getNombreAbogado() {
        return nombreAbogado;
    }

    public String getInformacion() {
        return informacion;
    }

    public int getNumerocaso() {
        return numerocaso;
    }

    public boolean save() {
        return casosList.add(this);
    }

    public ArrayList<Casos> getCasosList() {
        return casosList;
    }
    @Override
    public String toString() {
        return "Nombre del caso: " + nombreCaso + ", Tipo de caso: " + tipoCaso + ", Nombre del abogado: " + nombreAbogado + ", Información: " + informacion + ", Número de caso: " + numerocaso;
    }
    public void eliminarCaso(Casos caso) {
        casosList.remove(caso);
    }

}
