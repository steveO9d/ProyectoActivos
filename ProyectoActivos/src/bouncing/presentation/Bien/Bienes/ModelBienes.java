/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncing.presentation.Bien.Bienes;

import bouncing.DAO.DaoActivo;
import bouncing.DAO.DaoSolicitud;
import bouncing.DAO.GlobalException;
import bouncing.DAO.NoDataException;
import bouncing.logic.Activo;
import bouncing.logic.Solicitud;
import bouncing.presentation.Activos.ActivosTableModel;
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
public class ModelBienes extends Observable {

     public ModelBienes() {
        this.tableActivos = new ActivosTableModel(colsActivo, new ArrayList<>());
        this.tableSolicitud = new SolicitudTableModel(colsSolicitud, new ArrayList<>());
        this.daoSolicitud=new DaoSolicitud();
        this.daoActivo=new DaoActivo();
    }

    public Activo getFilterActivo() {
        return filterActivo;
    }

    public TableModel getTableActivos() {
        return tableActivos;
    }

    public Solicitud getFilterSolicitud() {
        return filterSolicitud;
    }

    public SolicitudTableModel getTableSolicitud() {
        return tableSolicitud;
    }

    public void setFilterSolicitud(Solicitud filterSolicitud) {
        this.filterSolicitud = filterSolicitud;
    }

    public void setTableActivos(ActivosTableModel tableActivos) {
        this.tableActivos = tableActivos;
    }

    public void setFilterActivo(Activo filter) {
        this.filterActivo = filter;
    }

    public void setTablePersonas(List<Activo> personas) {
        this.tableActivos = new ActivosTableModel(colsActivo, personas);
        setChanged();
        notifyObservers();
    }
    
    public void setTableSolicitud(List<Solicitud> personas) {
        this.tableSolicitud = new SolicitudTableModel(colsSolicitud, personas);
        setChanged();
        notifyObservers();
    }
    
    public Solicitud getRowAt(int row) {
        return tableSolicitud.getRowAt(row);
    }
    
    public void listarSolicitud() throws GlobalException, NoDataException{
        List<Solicitud>solicitudes=daoSolicitud.listarSolicitudes();
        setTableSolicitud(solicitudes);
    }
    
    public void ListarActivo() throws GlobalException, NoDataException{
        List<Activo>activos=daoActivo.listarActivo();
        setTablePersonas(activos);
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o); //To change body of generated methods, choose Tools | Templates.
        setChanged();
        notifyObservers();
    }

    Activo filterActivo = new Activo();
    ActivosTableModel tableActivos;
    int[] colsActivo = {ActivosTableModel.CODIGO, ActivosTableModel.BIEN, ActivosTableModel.FUNCIONARIO,
        ActivosTableModel.DEPENDENCIA, ActivosTableModel.PUESTO};
    
    Solicitud filterSolicitud = new Solicitud();
    SolicitudTableModel tableSolicitud;
    int[] colsSolicitud = {SolicitudTableModel.NUM_SOLICITUD, SolicitudTableModel.NUM_COMPROBANTE, SolicitudTableModel.FECHA,
        SolicitudTableModel.TIPO_ADQUISICION, SolicitudTableModel.CANTIDAD_BIENES
    , SolicitudTableModel.CANTIDAD_BIENES, SolicitudTableModel.MONTO_TOTAL
    , SolicitudTableModel.ESTADO, SolicitudTableModel.CODIGO_DEPARTAMENTO};
    
    DaoSolicitud daoSolicitud;
    DaoActivo daoActivo;

}
