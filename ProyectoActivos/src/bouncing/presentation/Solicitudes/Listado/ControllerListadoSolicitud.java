/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncing.presentation.Solicitudes.Listado;

import bouncing.DAO.GlobalException;
import bouncing.DAO.NoDataException;

/**
 *
 * @author Escinf
 */
public class ControllerListadoSolicitud {
    ModelListadoSolicitud model;
    ViewListadoSolicitud view;

    public ControllerListadoSolicitud(ModelListadoSolicitud model, ViewListadoSolicitud view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
    }
    
    public void iniciarVista(){
        view.setVisible(true);
    }
    
    public void listar() throws GlobalException, NoDataException{
        model.listar();
    }

 
}
