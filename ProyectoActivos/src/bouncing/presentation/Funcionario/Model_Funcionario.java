/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncing.presentation.Funcionario;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Tulio
 */
public class Model_Funcionario extends Observable{


    public Model_Funcionario() {
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
}
