/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncing.presentation.Solicitudes.Edicion;

import bouncing.DAO.GlobalException;
import bouncing.DAO.NoDataException;
import bouncing.logic.Bien;
import bouncing.logic.Solicitud;

/**
 *
 * @author Escinf
 */
public class ControllerSolicitud {
    ModelSolicitud model;
    ViewSolicitud view;

    public ControllerSolicitud(ModelSolicitud model, ViewSolicitud view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
    }

    public void agregarBien(Bien nuevo) throws GlobalException, NoDataException{
        model.agregarBien(nuevo);
    }    
    
    public void listarBien() throws GlobalException, NoDataException{
        model.listarBien();
    }
    
    public void agregarSolicitud(Solicitud nueva) throws GlobalException, NoDataException{
        model.agregarSolicitud(nueva);
    }

    public void iniciarVista() {
        view.setVisible(true);
    }
    
    public void ocultarVista() {
        view.setVisible(false);
    }
 
}
