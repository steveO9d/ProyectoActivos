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
public class Solicitud {

    public Solicitud() {
        this.numSolicitud = " ";
        this.numComprobante = " ";
        this.fecha = " ";
        this.tipoAdquisicion = " ";
        this.cantidadBienes = 0;
        this.montoToTal = 0.0;
        this.razonRechazo = " ";
        this.estado = " ";
        this.departamento = new Departamento();
        this.funcionario = new Funcionario();
        bienes = new ArrayList<>();
    }

    public Solicitud(String numSolicitud, String numComprobante, String fecha, String tipoAdquisicion,
            int cantidadBienes, double montoToTal, String razonRechazo, String estado,
            Departamento codigoDepartamento, Funcionario funcionario) {
        this.numSolicitud = numSolicitud;
        this.numComprobante = numComprobante;
        this.fecha = fecha;
        this.tipoAdquisicion = tipoAdquisicion;
        this.cantidadBienes = cantidadBienes;
        this.montoToTal = montoToTal;
        this.razonRechazo = razonRechazo;
        this.estado = estado;
        this.departamento = codigoDepartamento;
        this.funcionario = funcionario;
        bienes = new ArrayList<>();
    }

    public int getCantidadBienes() {
        return cantidadBienes;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public String getEstado() {
        return estado;
    }

    public String getFecha() {
        return fecha;
    }

    public double getMontoToTal() {
        double suma = 0;
        for(Bien b : bienes){
            suma += b.getPrecioUnitario();
        }
        montoToTal += suma;
        return montoToTal;
    }

    public String getNumComprobante() {
        return numComprobante;
    }

    public String getNumSolicitud() {
        return numSolicitud;
    }

    public String getRazonRechazo() {
        return razonRechazo;
    }

    public String getTipoAdquisicion() {
        return tipoAdquisicion;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public List<Bien> getBienes() {
        return bienes;
    }

    public void setBienes(List<Bien> bienes) {
        this.bienes = bienes;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void setCantidadBienes(int cantidadBienes) {
        this.cantidadBienes = cantidadBienes;
    }

    public void setCodigoDepartamento(Departamento codigoDepartamento) {
        this.departamento = codigoDepartamento;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setMontoToTal(double montoToTal) {
        this.montoToTal = montoToTal;
    }

    public void setNumComprobante(String numComprobante) {
        this.numComprobante = numComprobante;
    }

    public void setNumSolicitud(String numSolicitud) {
        this.numSolicitud = numSolicitud;
    }

    public void setRazonRechazo(String razonRechazo) {
        this.razonRechazo = razonRechazo;
    }

    public void setTipoAdquisicion(String tipoAdquisicion) {
        this.tipoAdquisicion = tipoAdquisicion;
    }

    public void agregarBien(Bien nuevo) {
        bienes.add(nuevo);
        cantidadBienes++;
    }

    public double definirMontoTotal() {
        double monto = 0;
        for (Bien b : bienes) {
            monto += b.getPrecioUnitario();
        }
        return monto;
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        r.append("Número solicitud: ").append(numSolicitud);
        r.append("Número de comprobante: ").append(numComprobante);
        r.append("Fecha: ").append(fecha);
        r.append("Tipo de adquisición: ").append(tipoAdquisicion);
        r.append("Cantidad de bienes: ").append(cantidadBienes);
        r.append("Monto total: ").append(montoToTal);
        r.append("Razón rechazo: ").append(razonRechazo);
        r.append("Estado: ").append(estado);
        r.append("Codigo de departamento: ").append(departamento.getCodigo());
        return r.toString();
    }

    String numSolicitud;
    String numComprobante;
    String fecha;
    String tipoAdquisicion;
    int cantidadBienes;
    double montoToTal;
    String razonRechazo;
    String estado;
    Departamento departamento;
    Funcionario funcionario;
    List<Bien> bienes;

}
