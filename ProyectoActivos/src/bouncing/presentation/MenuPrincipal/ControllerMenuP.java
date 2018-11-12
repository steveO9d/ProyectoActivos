/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncing.presentation.MenuPrincipal;

import static proyectoactivos.ProyectoActivos.CONTROL_EDICION_SOLICITUD;
import static proyectoactivos.ProyectoActivos.CONTROL_LISTADO_SOLICITUD;

/**
 *
 * @author Escinf
 */
public class ControllerMenuP {

    ModelMenuP model;
    ViewMenuP view;

    public ControllerMenuP(ModelMenuP model, ViewMenuP view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
    }

    public void iniciarEdicionSolicitud() {
        CONTROL_EDICION_SOLICITUD.iniciarVista();
    }

    public void iniciarListadoSolicitud() {
        CONTROL_LISTADO_SOLICITUD.iniciarVista();
    }

}
