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
public class Funcionario {

    public Funcionario() {
        this.id = " ";
        this.nombre = " ";
        labores = new ArrayList<>();
        solicitudes = new ArrayList<>();
    }

    public Funcionario(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        labores = new ArrayList<>();
        solicitudes = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        r.append("Id: ").append(id);
        r.append("Nombre: ").append(nombre);
        return r.toString();
    }
   
    String id;
    String nombre;
    List labores;
    List solicitudes;
    
}
