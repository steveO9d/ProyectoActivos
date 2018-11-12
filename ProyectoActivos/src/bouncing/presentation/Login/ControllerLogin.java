/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncing.presentation.Login;

/**
 *
 * @author Escinf
 */
public class ControllerLogin {

    ModelLogin model;
    ViewLogin view;

    public ControllerLogin(ModelLogin model, ViewLogin view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
    }

}
