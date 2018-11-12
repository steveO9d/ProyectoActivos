/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncing.presentation.Solicitudes.Edicion;

import bouncing.DAO.DaoBien;
import bouncing.DAO.DaoSolicitud;
import bouncing.DAO.GlobalException;
import bouncing.DAO.NoDataException;
import bouncing.logic.Bien;
import bouncing.logic.Solicitud;
import bouncing.presentation.Bien.BienTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.table.TableModel;

/**
 *
 * @author Escinf
 */
public class ModelSolicitud extends Observable {

    public ModelSolicitud() {
        this.tableBien = new BienTableModel(cols, new ArrayList<>());
        daoBien = new DaoBien();
        daoSolicitud = new DaoSolicitud();
    }

    public Bien getFilter() {
        return filter;
    }

    public TableModel getTableBien() {
        return tableBien;
    }

    public Bien getRowAt(int row) {
        return tableBien.getRowAt(row);
    }

    public void setFilter(Bien filter) {
        this.filter = filter;
    }

    public void setTableBien(List<Bien> personas) {
        this.tableBien = new BienTableModel(cols, personas);
        actualizar();
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o); //To change body of generated methods, choose Tools | Templates.
        actualizar();
    }

    public void agregarBien(Bien nuevo) throws GlobalException, NoDataException {
        daoBien.insertarBien(nuevo);
        actualizar();
    }

    public void listarBien() throws GlobalException, NoDataException {
        List<Bien> rows = daoBien.listarBien();
        setTableBien(rows);
    }

    public void agregarSolicitud(Solicitud nueva) throws GlobalException, NoDataException {
        daoSolicitud.insertarSolicitud(nueva);
        actualizar();
    }
    
    public String consecutivo(){
        return null;
    }

    private void actualizar() {
        setChanged();
        notifyObservers();
    }

    Bien filter = new Bien();
    BienTableModel tableBien;
    int[] cols = {BienTableModel.SERIAL, BienTableModel.DESCRIPCION, BienTableModel.MARCA,
        BienTableModel.MODELO, BienTableModel.PRECIO_UNIT,
        BienTableModel.NUM_SOLICITUD_BIEN, BienTableModel.CATEGORIA_BIEN};

    DaoBien daoBien;
    DaoSolicitud daoSolicitud;

}
