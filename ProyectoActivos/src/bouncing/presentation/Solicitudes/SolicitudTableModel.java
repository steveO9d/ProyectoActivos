/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncing.presentation.Solicitudes;

import bouncing.logic.Solicitud;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author jsanchez
 */
public class SolicitudTableModel extends AbstractTableModel implements TableModel {

    List<Solicitud> rows;
    int[] cols;

    public SolicitudTableModel(int[] cols, List<Solicitud> rows) {
        this.cols = cols;
        this.rows = rows;
        initColNames();
    }

    public Solicitud getRowAt(int row) {
        return rows.get(row);
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public String getColumnName(int col) {
        return colNames[cols[col]];
    }

    @Override
    public Class<?> getColumnClass(int col) {
//        switch (cols[col]) {
//            case SEXO:
//                return Icon.class;
//            case PASATIEMPO_CINE:
//                return Boolean.class;
//            case PASATIEMPO_MUSICA:
//                return Boolean.class;
//            default:
        return super.getColumnClass(col);
//        }
    }

    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public Object getValueAt(int row, int col) {
        Solicitud solicitud = rows.get(row);
        switch (cols[col]) {
            case NUM_SOLICITUD:
                return solicitud.getNumSolicitud();
            case NUM_COMPROBANTE:
                return solicitud.getNumComprobante();
            case FECHA:
                return solicitud.getFecha();
            case TIPO_ADQUISICION:
                return solicitud.getTipoAdquisicion();
            case CANTIDAD_BIENES:
                return solicitud.getCantidadBienes();
            case MONTO_TOTAL:
                return solicitud.getMontoToTal();
            case ESTADO:
                return solicitud.getEstado();
            case CODIGO_DEPARTAMENTO:
                return solicitud.getDepartamento().getCodigo();
            case NOMBRE_FUNCIONARIO:
                return solicitud.getFuncionario().getNombre();
            default:
                return "";
        }
    }

    public static final int NUM_SOLICITUD = 0;
    public static final int NUM_COMPROBANTE = 1;
    public static final int FECHA = 2;
    public static final int TIPO_ADQUISICION = 3;
    public static final int CANTIDAD_BIENES = 4;
    public static final int MONTO_TOTAL = 5;
    public static final int ESTADO = 6;
    public static final int CODIGO_DEPARTAMENTO = 7;
    public static final int NOMBRE_FUNCIONARIO = 8;

    String[] colNames = new String[11];

    private void initColNames() {
        colNames[NUM_SOLICITUD] = "N°";
        colNames[NUM_COMPROBANTE] = "Comprobante";
        colNames[FECHA] = "Fecha adquisición";
        colNames[TIPO_ADQUISICION] = "Tipo. Adq";
        colNames[CANTIDAD_BIENES] = "Cant. Bienes";
        colNames[MONTO_TOTAL] = "Monto total";
        colNames[ESTADO] = "Estado";
        colNames[CODIGO_DEPARTAMENTO] = "Departamento";
        colNames[NOMBRE_FUNCIONARIO] = "Funcionario";
    }

}
