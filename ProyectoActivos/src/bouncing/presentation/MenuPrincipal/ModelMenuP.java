/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncing.presentation.MenuPrincipal;

import java.util.Observable;
import java.util.Observer;


/**
 *
 * @author Escinf
 */
public class ModelMenuP extends Observable{


    public ModelMenuP() {
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











