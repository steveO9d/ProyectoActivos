/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncing.DAO;

import bouncing.logic.Bien;
import bouncing.logic.CategoriaDeBien;
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
public class DaoBien extends Servicio {

    // PROCEDIMIENTOS ALMACENADOS
    public void insertarBien(Bien bien) throws GlobalException, NoDataException {
        try {
            conectar();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DaoBien.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            PreparedStatement pstmt = conexion.prepareStatement(INSERTARBIEN);
            pstmt.setString(1, bien.getSerial());
            pstmt.setString(2, bien.getIdCategoria().getDescripcionCategoria());
            pstmt.setString(3, bien.getMarca());
            pstmt.setString(4, bien.getModelo());
            pstmt.setDouble(5, bien.getPrecioUnitario());
            pstmt.setString(6, bien.getNumSolicitudBien().getNumSolicitud());
            pstmt.setString(7, bien.getDescripcion());
            int exito = pstmt.executeUpdate();

            if (exito != 1) {
                throw new Exception("Solicitud no ingresada");
            }
        } catch (Exception e) {
            throw new GlobalException("Solicitud duplicada");
        }
    }

    //FUNCIONES ALMACENADAS
    public List<Bien> listarBien() throws GlobalException, NoDataException {
        List<Bien> r = new ArrayList<>();
        try {
            conectar();
            CallableStatement stm = conexion.prepareCall(LISTARBIENES);
            stm.registerOutParameter(1, OracleTypes.CURSOR);
            stm.execute();
            ResultSet rs = (ResultSet) stm.getObject(1);

            while (rs.next()) {
                r.add(new Bien(
                        rs.getString("serial"),
                        rs.getString("descripcion"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getDouble("preciounitario"),
                        toSolicitud(rs),
                        toCategoria(rs)));
            }
        } catch (ClassNotFoundException e) {
            throw new GlobalException("No se ha localizado el driver");
        } catch (SQLException e) {
            throw new NoDataException("La base de datos no se encuentra disponible");
        }
        return r;
    }

    private CategoriaDeBien toCategoria(ResultSet rs) {
        CategoriaDeBien categoria = new CategoriaDeBien();
        try {
            String numero = rs.getString("categoria_descripcion");
            categoria.setDescripcionCategoria(numero);
        } catch (SQLException ex) {
            Logger.getLogger(DaoSolicitud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categoria;
    }

    private Solicitud toSolicitud(ResultSet rs) {
        Solicitud solicitud = new Solicitud();
        try {
            String numero = rs.getString("solicitud_numsolicitud");
            solicitud.setNumSolicitud(numero);

        } catch (SQLException ex) {
            Logger.getLogger(DaoSolicitud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return solicitud;
    }

    private static final String INSERTARBIEN
            = "{call INSERTARBIEN(?, ?, ?, ?, ?, ?, ?}";
    private static final String LISTARBIENES
            = "{? = call LISTARBIEN()}";

}
