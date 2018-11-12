/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncing.DAO;

import bouncing.logic.CategoriaDeBien;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Tulio
 */
public class DaoCatalogo extends Servicio{
    private static final String INSERTAR_CATALOGO
            ="{call insertarcategoria(?)}";
    private static final String LISTAR_CATALOGO
            ="{? = call listarcategorias()}";
    private static final String MODIFICAR_CATALOGO
            ="{call modificarCategoria(?,?)}";
    private static final String ELIMINAR_CATALOGO
            ="{call eliminarcategoria(?)}";
    
    public DaoCatalogo(){
        
    }
    
    public void insertarCatalogo(CategoriaDeBien cat) throws GlobalException, NoDataException, SQLException {
        try {
            conectar();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DaoCatalogo.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            PreparedStatement pstmt = conexion.prepareStatement(INSERTAR_CATALOGO);
            pstmt.setString(1,cat.getDescripcionCategoria());
            boolean exito = pstmt.execute();

            if (exito) {
                throw new Exception("Catalogo no ingresado");
            }
        } catch (Exception e) {
            throw new GlobalException("Catalogo duplicado");
        }
    }
    
    public boolean actualizarCatalogo(CategoriaDeBien cat) throws Exception {
        boolean exito;
        try {
            conectar();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DaoCatalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement pstmt;
        pstmt = conexion.prepareStatement(MODIFICAR_CATALOGO);
        pstmt.clearParameters();

        pstmt.setString(1, cat.getDescripcionCategoria());

        exito = pstmt.execute();

        if (exito) {
            throw new Exception("Ese estudiante no existe");
        }
        return exito;
    }
    
    public boolean eliminarCatalogo(String id) throws Exception {
        boolean exito;
        try {
            conectar();
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoCatalogo.class.getName()).log(Level.SEVERE, null, ex);
        }

        PreparedStatement stm = conexion.prepareStatement(ELIMINAR_CATALOGO);
        stm.clearParameters();
        stm.setString(1, id);

        exito = stm.execute();

        if (exito) {
            throw new Exception("Ese estudiante no existe");
        }
        return exito;
    }
    
     public List<CategoriaDeBien> listaCatalogos() throws GlobalException, NoDataException {
        List<CategoriaDeBien> r = new ArrayList<>();
        try {
            conectar();
            CallableStatement stm = conexion.prepareCall(LISTAR_CATALOGO);
            stm.registerOutParameter(1, OracleTypes.CURSOR);
            stm.execute();
            ResultSet rs = (ResultSet) stm.getObject(1);

            while (rs.next()) {
                r.add(new CategoriaDeBien(
                        rs.getString("Descripcion")));
            }
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        return r;
    }
     /*
     public List<CategoriaDeBien> buscarCatalogos(String id) throws GlobalException, NoDataException {
        List<CategoriaDeBien> r = new ArrayList<>();
        try {
            conectar();
            CallableStatement stm = conexion.prepareCall(BUSCAR_CATALOGO);
            stm.registerOutParameter(1, OracleTypes.CURSOR);
            stm.setString(2, id);
            stm.execute();
            ResultSet rs = (ResultSet) stm.getObject(1);

            while (rs.next()) {
                r.add(new CategoriaDeBien(
                        rs.getString("descripcion")));
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoCatalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
     
     public CategoriaDeBien CatalogoGet(String id) throws Exception {
        CategoriaDeBien r = new CategoriaDeBien();
        try {
            conectar();
            CallableStatement stm = conexion.prepareCall(BUSCAR_CATALOGO);
            stm.registerOutParameter(1, OracleTypes.CURSOR);
            stm.setString(2, id);
            stm.execute();
            ResultSet rs = (ResultSet) stm.getObject(1);
            if (rs.next()) {
                r = new CategoriaDeBien(
                        rs.getString("descripcion"));
            } else {
                throw new Exception("El catalogo no existe");
            }
        } catch (SQLException ex) {
            System.err.printf("Excepción: '%s'%n",
                    ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoCatalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    */
    
}

