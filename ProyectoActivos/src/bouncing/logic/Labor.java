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
public class Labor {

    public Labor() {
        this.funcionario = new Funcionario();
        this.dependencia = new Departamento();
        this.puesto = new Puesto();
        activos = new ArrayList<>();
    }

    public Labor(Funcionario funcionario, Departamento dependicia, Puesto puesto) {
        this.funcionario = funcionario;
        this.dependencia = dependicia;
        this.puesto = puesto;
        activos = new ArrayList<>();
    }

    public Departamento getDependencia() {
        return dependencia;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public List<Activo> getActivos() {
        return activos;
    }

    public void setActivos(List<Activo> activos) {
        this.activos = activos;
    }

    public void setDependencia(Departamento dependicia) {
        this.dependencia = dependicia;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }
    
    public String getNombreFuncionario(){
        return funcionario.getNombre();
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        r.append("Funcionario: ").append(funcionario.getNombre());
        r.append("Departamento de trabajo: ").append(dependencia.getNombre());
        r.append("Puesto de trabajo: ").append(puesto.getNombrePuesto());
        return r.toString();
    }

    Funcionario funcionario;
    Departamento dependencia;
    Puesto puesto;
    List<Activo> activos;
}
