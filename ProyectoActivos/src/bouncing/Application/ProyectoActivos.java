/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncing.Application;

import bouncing.presentation.Controller;
import bouncing.presentation.Model;
import bouncing.presentation.View;

/**
 *
 * @author steve
 */
public class ProyectoActivos {

    public static void main(String[] args) {
        Model model=new Model() ;
        View view = new View();
        Controller controller = new Controller(model,view);
        view.setVisible(true);     
    }
    
}
