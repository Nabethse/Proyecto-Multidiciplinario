package com.nabethse.bufetadogados.models;

import java.util.ArrayList;

public class Horario {
    private String asunto;
    private String hora;
    private String fecha;
    private String lugar;
    private int numeroCita;

    private  ArrayList<Horario> horarios = new ArrayList<>();
    private  ArrayList<Horario> horariosList = new ArrayList<>();
    public ArrayList<Horario> getHorariosList() {
        return horarios;
    }


    public Horario(String asunto, String hora, String fecha, String lugar, int numeroCita) {
        this.asunto = asunto;
        this.hora = hora;
        this.fecha = fecha;
        this.lugar = lugar;
        this.numeroCita = numeroCita;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setNumeroCita(int numeroCita) {
        this.numeroCita = numeroCita;
    }

    public int getNumeroCita() {
        return numeroCita;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getHora() {
        return hora;
    }

    public String getFecha() {
        return fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public boolean save(Horario horario) {
        return horarios.add(horario);
    }
    public Horario buscarHorarioPorNumeroCita(int numeroCita) {
        for (Horario horario : horarios) {
            if (horario.getNumeroCita() == numeroCita) {
                return horario;
            }
        }
        return null;
    }

}
