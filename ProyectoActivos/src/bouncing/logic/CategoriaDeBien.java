/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncing.logic;

/**
 *
 * @author steve
 */
public class CategoriaDeBien {

    public CategoriaDeBien() {
        this.descripcionCategoria = " ";
    }

    public CategoriaDeBien(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }

        @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        r.append("Descripcion categoría: ").append(descripcionCategoria);
        return r.toString();
    }
    
    String descripcionCategoria;
}
