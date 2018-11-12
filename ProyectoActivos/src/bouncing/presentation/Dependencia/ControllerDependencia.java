/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncing.presentation.Dependencia;

/**
 *
 * @author Escinf
 */
public class ControllerDependencia {
    ModelDependencia model;
    ViewDependencia view;

    public ControllerDependencia(ModelDependencia model, ViewDependencia view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
    }

 
}
