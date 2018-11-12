/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncing.DAO;

import bouncing.logic.Activo;
import bouncing.logic.Bien;
import bouncing.logic.Labor;
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
public class DaoActivo extends Servicio{
    private static final String INSERTARACTIVO
            = "{call insertarActivo(?, ?, ?, ?, ?, ?, ?}";
    private static final String LISTARACTIVOS
            = "{? = call listarActivo()}";
    
    
    public void insertarActivo(Activo activo) throws GlobalException, NoDataException, SQLException {
        try {
            conectar();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DaoBien.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement pstmt = conexion.prepareStatement(INSERTARACTIVO);
            pstmt.setString(1, activo.getCodigoId());
            pstmt.setString(2, activo.getBienActivo().getDescripcion());
            pstmt.setString(3, activo.getLaborActivo().getNombreFuncionario());
            pstmt.setString(4, activo.getLaborActivo().getDependencia().getNombre());
            pstmt.setString(5, activo.getLaborActivo().getPuesto().getNombrePuesto());
            
            int exito = pstmt.executeUpdate();

            if (exito != 1) {
                throw new Exception("Solicitud no ingresada");
            }
        } catch (Exception e) {
            throw new GlobalException("Solicitud duplicada");
        }
    }
    
    public List<Activo> listarActivo() throws GlobalException, NoDataException {
        List<Activo> r = new ArrayList<>();
        try {
            conectar();
            CallableStatement stm = conexion.prepareCall(LISTARACTIVOS);
            stm.registerOutParameter(1, OracleTypes.CURSOR);
            stm.execute();
            ResultSet rs = (ResultSet) stm.getObject(1);

            while (rs.next()) {
                r.add(new Activo(
                        rs.getString("codigoid"),
                        toBien(rs),
                        toLabor(rs)));
            }
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException(e.getMessage());
        }
        return r;
    }
    
    private Bien toBien(ResultSet rs){
        try{
            Bien ec=new Bien();
            ec.setDescripcion(rs.getString("descripcion"));
            return ec;
        }catch(SQLException ex){
            return null;
        }
    }
    
    private Labor toLabor(ResultSet rs){
        try{
            Labor ec=new Labor();
            ec.getFuncionario().setNombre(rs.getString("labor_nombre_funcionario"));
            ec.getDependencia().setNombre(rs.getString("labor_nombre_dependencia"));
            ec.getPuesto().setNombrePuesto(rs.getString("labor_nombre_puesto"));
            return ec;
        }catch(SQLException ex){
            return null;
        }
    }
    
}
