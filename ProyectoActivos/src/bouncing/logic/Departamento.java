/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncing.logic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author steve
 */
public class Departamento {

    public Departamento() {
        this.codigo = " ";
        this.nombre = " ";
        laboradores = new ArrayList<>();
        solicitudes = new ArrayList<>();
    }

    public Departamento(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        laboradores = new ArrayList<>();
        solicitudes = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Labor> getLaboradores() {
        return laboradores;
    }

    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setLaboradores(List<Labor> laboradores) {
        this.laboradores = laboradores;
    }

    public void setSolicitudes(List<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        r.append("Codigo: ").append(codigo);
        r.append("Nombre: ").append(nombre);
        return r.toString();
    }
  
    String codigo;
    String nombre;
    List<Labor> laboradores;
    List<Solicitud> solicitudes;
}
