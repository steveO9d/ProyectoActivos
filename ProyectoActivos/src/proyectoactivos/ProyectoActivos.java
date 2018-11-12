/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoactivos;

import bouncing.presentation.Bien.Bienes.ControllerBienes;
import bouncing.presentation.Bien.Bienes.ModelBienes;
import bouncing.presentation.Bien.Bienes.ViewBienes;
import bouncing.presentation.Bien.CatalogoBienes.ControllerCatalogoBienes;
import bouncing.presentation.Bien.CatalogoBienes.ModelCatalogoBienes;
import bouncing.presentation.Bien.CatalogoBienes.ViewCatalogoBienes;
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
        
        ModelCatalogoBienes modelCatalogoBienes = new ModelCatalogoBienes();
        ViewCatalogoBienes viewCatalogoBienes = new ViewCatalogoBienes();
        ControllerCatalogoBienes controllerCatalogoBienes = new ControllerCatalogoBienes(modelCatalogoBienes, viewCatalogoBienes);
        CONTROL_CATALOGO_BIENES = controllerCatalogoBienes;
        
        ModelBienes modelIncluir = new ModelBienes();
        ViewBienes viewInlcuir = new ViewBienes();
        ControllerBienes controlIncluirBienes = new ControllerBienes(modelIncluir, viewInlcuir);
        CONTROL_INCLUIR_BIENES = controlIncluirBienes;
        
    }

    public static ControllerSolicitud CONTROL_EDICION_SOLICITUD;
    public static ControllerListadoSolicitud CONTROL_LISTADO_SOLICITUD;
    
    public static ControllerCatalogoBienes CONTROL_CATALOGO_BIENES;
    public static ControllerBienes CONTROL_INCLUIR_BIENES;

}
