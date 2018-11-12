/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncing.presentation.Activos;

import bouncing.logic.Activo;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author steve
 */
public class ActivosTableModel extends AbstractTableModel implements TableModel {

    List<Activo> rows;
    int[] cols;

    public ActivosTableModel(int[] cols, List<Activo> rows) {
        this.cols = cols;
        this.rows = rows;
        initColNames();
    }

    public Activo getRowAt(int row) {
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
        Activo activo = rows.get(row);
        switch (cols[col]) {
            case CODIGO:
                return activo.getCodigoId();
            case BIEN:
                return activo.getBienActivo();
            case FUNCIONARIO:
                return activo.getLaborActivo().getNombreFuncionario();
                case DEPENDENCIA:
                return activo.getLaborActivo().getDependencia().getNombre();
                case PUESTO:
                return activo.getLaborActivo().getPuesto().getNombrePuesto();
            default:
                return "";
        }
    }

    public static final int CODIGO = 0;
    public static final int BIEN = 1;
    public static final int FUNCIONARIO = 2;
    public static final int DEPENDENCIA = 3;
    public static final int PUESTO = 4;

    String[] colNames = new String[11];

    private void initColNames() {
        colNames[CODIGO] = "Id";
        colNames[BIEN] = "Descripción";
        colNames[FUNCIONARIO] = "Encargado";
        colNames[DEPENDENCIA] = "Dependencia";
        colNames[PUESTO] = "Puesto";
    }
    
}
