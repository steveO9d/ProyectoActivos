/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncing.presentation.Bien;

import bouncing.logic.Bien;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author steve
 */
public class BienTableModel extends AbstractTableModel implements TableModel {

    List<Bien> rows;
    int[] cols;

    public BienTableModel(int[] cols, List<Bien> rows) {
        this.cols = cols;
        this.rows = rows;
        initColNames();
    }

    public Bien getRowAt(int row) {
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
        Bien bien = rows.get(row);
        switch (cols[col]) {
            case SERIAL:
                return bien.getSerial();
            case DESCRIPCION:
                return bien.getDescripcion();
            case MARCA:
                return bien.getMarca();
            case MODELO:
                return bien.getModelo();
            case PRECIO_UNIT:
                return bien.getPrecioUnitario();
            case NUM_SOLICITUD_BIEN:
                return bien.getNumSolicitudBien().getNumSolicitud();
            case CATEGORIA_BIEN:
                return bien.getIdCategoria().getDescripcionCategoria();
            default:
                return "";
        }
    }

    public static final int SERIAL = 0;
    public static final int DESCRIPCION = 1;
    public static final int MARCA = 2;
    public static final int MODELO = 3;
    public static final int PRECIO_UNIT = 4;
    public static final int NUM_SOLICITUD_BIEN = 5;
    public static final int CATEGORIA_BIEN = 6;

    String[] colNames = new String[11];

    private void initColNames() {
        colNames[SERIAL] = "Serial";
        colNames[DESCRIPCION] = "Descripción";
        colNames[MARCA] = "Marca";
        colNames[MODELO] = "Modelo";
        colNames[PRECIO_UNIT] = "Precio unit";
        colNames[NUM_SOLICITUD_BIEN] = "Numero solicitud";
        colNames[CATEGORIA_BIEN] = "Categoría";
    }

}
