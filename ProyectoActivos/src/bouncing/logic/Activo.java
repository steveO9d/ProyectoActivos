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
public class Activo {

    public Activo() {
        this.codigoId = " ";
        this.bienActivo = new Bien();
        this.laborActivo = new Labor();
        this.consecutivo = " ";
    }
    
    public Activo(String codigoId, Bien bienActivo, Labor laborActivo) {
        this.codigoId = codigoId;
        this.bienActivo = bienActivo;
        this.laborActivo = laborActivo;
        this.consecutivo = "A" + consecutivo;
    }    

    public Bien getBienActivo() {
        return bienActivo;
    }

    public String getCodigoId() {
        return codigoId;
    }

    public Labor getLaborActivo() {
        return laborActivo;
    }

    public String getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(String consecutivo) {
        this.consecutivo = "A" + consecutivo;
    }

    public void setBienActivo(Bien bienActivo) {
        this.bienActivo = bienActivo;
    }

    public void setCodigoId(String codigoId) {
        this.codigoId = codigoId;
    }

    public void setLaborActivo(Labor laborActivo) {
        this.laborActivo = laborActivo;
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        r.append("Codigo: ").append(codigoId);
        r.append("Activo: ").append(bienActivo.getDescripcion());
        r.append("Encargado: ").append(laborActivo.getNombreFuncionario());
        r.append("Dependencia: ").append(laborActivo.getDependencia().getNombre());
        r.append("Puesto del funcionario: ").append(laborActivo.getPuesto().getNombrePuesto());
        return r.toString();
    }
    
    String codigoId;
    Bien bienActivo;
    Labor laborActivo;
    String consecutivo;
}
