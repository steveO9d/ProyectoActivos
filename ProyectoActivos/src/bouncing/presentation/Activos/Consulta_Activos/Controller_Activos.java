/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncing.presentation.Activos.Consulta_Activos;

/**
 *
 * @author Tulio
 */
public class Controller_Activos {
        Model_Activos model;
    View_Activos view;

    public Controller_Activos(Model_Activos model, View_Activos view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
    }
    
    
    public void iniciarVista(){
        view.setVisible(true);
    }   
}
