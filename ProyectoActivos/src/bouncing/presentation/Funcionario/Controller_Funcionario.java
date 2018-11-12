
package bouncing.presentation.Funcionario;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tulio
 */
public class Controller_Funcionario {
     Model_Funcionario model;
    View_Funcionario view;

    public Controller_Funcionario(Model_Funcionario model, View_Funcionario view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
    }
}
