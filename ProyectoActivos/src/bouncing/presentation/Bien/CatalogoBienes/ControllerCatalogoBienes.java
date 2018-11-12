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
import java.sql.SQLException;

/**
 *
 * @author Escinf
 */
public class ControllerCatalogoBienes {
    ModelCatalogoBienes model;
    ViewCatalogoBienes view;
    DaoCatalogo dao;

    public ControllerCatalogoBienes(ModelCatalogoBienes model, ViewCatalogoBienes view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
        dao = new DaoCatalogo();
    }
    
    public ViewCatalogoBienes getView(){
        return view;
    }
    
    public void guardar(CategoriaDeBien u) throws GlobalException, NoDataException, SQLException{
        dao.insertarCatalogo(u);
        
    }
    
    /*public void consultar(CategoriaDeBien u) throws GlobalException, NoDataException{
        model.buscar(u);
    }*/
    
    public void listar() throws GlobalException, NoDataException{
        model.listar();
    }
    
    public void modificar(CategoriaDeBien cat) throws Exception{
        model.modificar(cat);
    }
    
    public void eliminar(CategoriaDeBien ct) throws Exception{
        model.eliminar(ct);
    }
    
    public void editar(int row){
        //CategoriaDeBien seleccionada=model.getRowAt();
    }
    
    CategoriaDeBien devolverCategoria(int row){
        CategoriaDeBien seleccionada = model.getRowAt(row);
        return seleccionada;
    }

 
}

