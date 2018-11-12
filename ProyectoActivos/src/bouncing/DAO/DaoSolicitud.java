/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncing.DAO;

import bouncing.logic.Departamento;
import bouncing.logic.Funcionario;
import bouncing.logic.Solicitud;
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
 * @author steve
 */
public class DaoSolicitud extends Servicio {

    public DaoSolicitud() {
    }

    // PROCEDIMIENTOS ALMACENADOS
    public void insertarSolicitud(Solicitud solicitud) throws GlobalException, NoDataException {
        try {
            conectar();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DaoSolicitud.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement pstmt = conexion.prepareStatement(INSERTARSOLICITUD);
            pstmt.setString(1, solicitud.getNumComprobante());
            pstmt.setString(2, solicitud.getFecha());
            pstmt.setString(3, solicitud.getTipoAdquisicion());
            pstmt.setInt(4, solicitud.getCantidadBienes());
            pstmt.setDouble(5, solicitud.getMontoToTal());
            pstmt.setString(6, solicitud.getRazonRechazo());
            pstmt.setString(7, solicitud.getEstado());
            pstmt.setObject(8, null);
            pstmt.setObject(9, null);

            int exito = pstmt.executeUpdate();

            if (exito != 1) {
                throw new Exception("Solicitud no ingresada");
            }
        } catch (Exception e) {
            throw new GlobalException(e.getMessage());
        }
    }


    //FUNCIONES ALMACENADAS
    public List<Solicitud> listarSolicitudes() throws GlobalException, NoDataException {
        List<Solicitud> r = new ArrayList<>();
        try {
            conectar();
            CallableStatement stm = conexion.prepareCall(LISTARSOLICITUD);
            stm.registerOutParameter(1, OracleTypes.CURSOR);
            stm.execute();
            ResultSet rs = (ResultSet) stm.getObject(1);

            while (rs.next()) {
                r.add(new Solicitud(
                        rs.getString("numsolicitud"),
                        rs.getString("numcomprobante"),
                        rs.getString("fecha"),
                        rs.getString("tipoadquisicion"),
                        rs.getInt("cantidadbienes"),
                        rs.getDouble("montototal"),
                        rs.getString("razonrechazo"),
                        rs.getString("estado"),
                        toDependencia(rs),
                        toFuncionario(rs)));
            }
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        return r;
    }

    private Departamento toDependencia(ResultSet rs) {
        try {
            Departamento ec = new Departamento();
            ec.setCodigo(rs.getString("dependencia_codigo"));
            return ec;
        } catch (SQLException ex) {
            return null;
        }
    }

    private Funcionario toFuncionario(ResultSet rs) {
        try {
            Funcionario ec = new Funcionario();
            ec.setNombre(rs.getString("funcionario_id"));
            return ec;
        } catch (SQLException ex) {
            return null;
        }
    }

    private static final String INSERTARSOLICITUD
            = "{call insertarSolicitud(?,?,?,?,?,?,?,?,?)}";
    private static final String LISTARSOLICITUD
            = "{? = call listarSolicitudes()}";

}
