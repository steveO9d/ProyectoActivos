/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoactivos;

import bouncing.presentation.MenuPrincipal.ControllerMenuP;
import bouncing.presentation.MenuPrincipal.ModelMenuP;
import bouncing.presentation.MenuPrincipal.ViewMenuP;
import bouncing.presentation.Solicitudes.Edicion.ControllerSolicitud;
import bouncing.presentation.Solicitudes.Edicion.ModelSolicitud;
import bouncing.presentation.Solicitudes.Edicion.ViewSolicitud;
import bouncing.presentation.Solicitudes.Listado.ControllerListadoSolicitud;
import bouncing.presentation.Solicitudes.Listado.ModelListadoSolicitud;
import bouncing.presentation.Solicitudes.Listado.ViewListadoSolicitud;

/**
 *
 * @author steve
 */
public class ProyectoActivos {

    public static void main(String[] args) {
        ModelMenuP model = new ModelMenuP();
        ViewMenuP view = new ViewMenuP();
        ControllerMenuP controller = new ControllerMenuP(model, view);
        view.setVisible(true);

        ModelSolicitud modelSolicitud = new ModelSolicitud();
        ViewSolicitud viewSolicitud = new ViewSolicitud();
        ControllerSolicitud controllerSolicitud = new ControllerSolicitud(modelSolicitud, viewSolicitud);
        CONTROL_EDICION_SOLICITUD = controllerSolicitud;
        
        ModelListadoSolicitud modelListadoSolicitud = new ModelListadoSolicitud();
        ViewListadoSolicitud viewListadoSolicitud = new ViewListadoSolicitud();
        ControllerListadoSolicitud controllerListadoSolicitud = new ControllerListadoSolicitud(modelListadoSolicitud, viewListadoSolicitud);
        CONTROL_LISTADO_SOLICITUD = controllerListadoSolicitud;
    }

    public static ControllerSolicitud CONTROL_EDICION_SOLICITUD;
    public static ControllerListadoSolicitud CONTROL_LISTADO_SOLICITUD;

}
