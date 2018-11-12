/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncing.presentation.Bien.Bienes;

import bouncing.DAO.GlobalException;
import bouncing.DAO.NoDataException;
import bouncing.logic.Solicitud;

/**
 *
 * @author Escinf
 */
public class ControllerBienes {
    ModelBienes model;
    ViewBienes view;

    public ControllerBienes(ModelBienes model, ViewBienes view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
    }
    
    Solicitud devolverSolicitud(int row){
      Solicitud seleccionada=model.getRowAt(row);
      return seleccionada;
    }

    public ViewBienes getView() {
        return view;
    }
    
    
    
    public  void listarSolicitud() throws GlobalException, NoDataException{
        model.listarSolicitud();
    }
    
    public void ListarActivo() throws GlobalException, NoDataException{
        model.ListarActivo();
    }
    
    public void iniciarVista(){
        view.setVisible(true);
    }    

 
}
