/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncing.presentation.Bien.CatalogoBienes;

import bouncing.DAO.DaoCatalogo;
import bouncing.DAO.GlobalException;
import bouncing.DAO.NoDataException;
import bouncing.logic.CategoriaDeBien;
import bouncing.presentation.Bien.CatalogoTableModel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.table.TableModel;


/**
 *
 * @author Escinf
 */
public class ModelCatalogoBienes extends Observable{

 CategoriaDeBien filter;
    DaoCatalogo dao;
    int[] cols={CatalogoTableModel.DESCRIPCION};
    CatalogoTableModel table;


   public ModelCatalogoBienes() {
        this.table = new CatalogoTableModel(cols, new ArrayList<>());
        dao = new DaoCatalogo();
    }

    public CategoriaDeBien getFilter() {
        return filter;
    }

    public TableModel getTableCatalogo() {
        return table;
    }

    public CategoriaDeBien getRowAt(int row) {
        return table.getRowAt(row);
    }

    public void setFilter(CategoriaDeBien filter) {
        this.filter = filter;
    }

    public void setTableCatalogo(List<CategoriaDeBien> personas) {
        this.table = new CatalogoTableModel(cols, personas);
        setChanged();
        notifyObservers();
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

    public void insertarCatalogo(CategoriaDeBien nuevaSolicitud) throws GlobalException, NoDataException, SQLException {
        dao.insertarCatalogo(nuevaSolicitud);
        actualizar();
    }

    public void listar() throws GlobalException, NoDataException {
        List<CategoriaDeBien> rows = dao.listaCatalogos();
        setTableCatalogo(rows);
    }
    
    /*public void buscar(CategoriaDeBien cat) throws GlobalException, NoDataException{
        dao.buscarCatalogos(cat.getDescripcionCategoria());
    }*/
    
    public void modificar(CategoriaDeBien cat) throws Exception{
        dao.actualizarCatalogo(cat);
    }
    
    public void eliminar(CategoriaDeBien cat) throws Exception{
        dao.eliminarCatalogo(cat.getDescripcionCategoria());
    }
}











