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
public class Puesto {

    public Puesto() {
        this.codigo = " ";
        this.nombrePuesto = " ";
        labores = new ArrayList<>();
    }

    public Puesto(String codigo, String nombrePuesto) {
        this.codigo = codigo;
        this.nombrePuesto = nombrePuesto;
        labores = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombrePuesto() {
        return nombrePuesto;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    public List<Labor> getLabores() {
        return labores;
    }

    public void setLabores(List<Labor> labores) {
        this.labores = labores;
    }

     @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        r.append("Codigo: ").append(codigo);
        r.append("Puesto de trabajo: ").append(nombrePuesto);
        return r.toString();
    }
    
    String codigo;
    String nombrePuesto;
    List<Labor> labores;
}
