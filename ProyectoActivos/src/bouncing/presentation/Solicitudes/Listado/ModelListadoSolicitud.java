/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncing.presentation.Solicitudes.Listado;

import bouncing.DAO.DaoSolicitud;
import bouncing.DAO.GlobalException;
import bouncing.DAO.NoDataException;
import bouncing.logic.Solicitud;
import bouncing.presentation.Solicitudes.SolicitudTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.table.TableModel;

/**
 *
 * @author Escinf
 */
public class ModelListadoSolicitud extends Observable {

    public ModelListadoSolicitud() {
        this.tableSolicitud = new SolicitudTableModel(cols, new ArrayList<>());
        daoSolicitud = new DaoSolicitud();
    }

    public Solicitud getFilter() {
        return filter;
    }

    public TableModel getTableSolicitud() {
        return tableSolicitud;
    }

    public Solicitud getRowAt(int row) {
        return tableSolicitud.getRowAt(row);
    }

    public void setFilter(Solicitud filter) {
        this.filter = filter;
    }

    public void setTableSolicitud(List<Solicitud> personas) {
        this.tableSolicitud = new SolicitudTableModel(cols, personas);
        actualizar();
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o); //To change body of generated methods, choose Tools | Templates.
        actualizar();
    }

    private void actualizar() {
        setChanged();
        notifyObservers();
    }

    public void insertarSolicitud(Solicitud nuevaSolicitud) throws GlobalException, NoDataException {
        daoSolicitud.insertarSolicitud(nuevaSolicitud);
        actualizar();
    }

    public void listar() throws GlobalException, NoDataException {
        List<Solicitud> rows = daoSolicitud.listarSolicitudes();
        setTableSolicitud(rows);
    }

    Solicitud filter = new Solicitud();
    SolicitudTableModel tableSolicitud;
    int[] cols = {SolicitudTableModel.NUM_SOLICITUD, SolicitudTableModel.NUM_COMPROBANTE, SolicitudTableModel.FECHA,
        SolicitudTableModel.TIPO_ADQUISICION, SolicitudTableModel.CANTIDAD_BIENES,
        SolicitudTableModel.MONTO_TOTAL, SolicitudTableModel.ESTADO, SolicitudTableModel.CODIGO_DEPARTAMENTO,
        SolicitudTableModel.NOMBRE_FUNCIONARIO};

    DaoSolicitud daoSolicitud;
}
