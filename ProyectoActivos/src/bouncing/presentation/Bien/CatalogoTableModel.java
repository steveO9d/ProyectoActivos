/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncing.presentation.Bien;

import bouncing.logic.CategoriaDeBien;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Tulio
 */
public class CatalogoTableModel extends AbstractTableModel implements TableModel{
    List<CategoriaDeBien> rows;
    int[] cols;

    public CatalogoTableModel(int[] cols, List<CategoriaDeBien> rows) {
        this.cols = cols;
        this.rows = rows;
        initColNames();
    }

    public CategoriaDeBien getRowAt(int row) {
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
        CategoriaDeBien cat = rows.get(row);
        switch (cols[col]) {
            case DESCRIPCION:
                return cat.getDescripcionCategoria();
            default:
                return "";
        }
    }

    public static final int DESCRIPCION= 0;

    String[] colNames = new String[11];

    private void initColNames() {
        colNames[DESCRIPCION] = "Descripcion";
    }
    
}
