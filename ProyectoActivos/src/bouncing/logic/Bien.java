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
public class Bien {

    public Bien() {
        this.serial = " ";
        this.descripcion = " ";
        this.marca = " ";
        this.modelo = " ";
        this.precioUnitario = 0.0;
        this.numSolicitudBien = new Solicitud();
        this.idCategoria = new CategoriaDeBien();
    }

    public Bien(String serial, String descripcion, String marca, String modelo, double precioUnitario, Solicitud numSolicitudBien, CategoriaDeBien idCategoria) {
        this.serial = serial;
        this.descripcion = descripcion;
        this.marca = marca;
        this.modelo = modelo;
        this.precioUnitario = precioUnitario;
        this.numSolicitudBien = numSolicitudBien;
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Solicitud getNumSolicitudBien() {
        return numSolicitudBien;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public String getSerial() {
        return serial;
    }

    public CategoriaDeBien getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(CategoriaDeBien idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setNumSolicitudBien(Solicitud numSolicitudBien) {
        this.numSolicitudBien = numSolicitudBien;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        r.append("Serial: ").append(serial);
        r.append("Descripcion: ").append(descripcion);
        r.append("Marca: ").append(marca);
        r.append("Modelo: ").append(modelo);
        r.append("Precio unitario: ").append(precioUnitario);
        r.append("Numero solicitud: ").append(numSolicitudBien.getNumSolicitud());
        r.append("Categoría: ").append(idCategoria.getDescripcionCategoria());
        return r.toString();
    }
    
    String serial;
    String descripcion;
    String marca;
    String modelo;
    double precioUnitario;
    Solicitud numSolicitudBien;
    CategoriaDeBien idCategoria;
}
