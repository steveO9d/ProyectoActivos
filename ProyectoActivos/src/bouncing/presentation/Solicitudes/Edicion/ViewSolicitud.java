/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncing.presentation.Solicitudes.Edicion;

import bouncing.DAO.GlobalException;
import bouncing.DAO.NoDataException;
import bouncing.logic.Bien;
import bouncing.logic.Solicitud;
import java.awt.Color;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Escinf
 */
public class ViewSolicitud extends javax.swing.JFrame implements Observer {

    ModelSolicitud model;
    ControllerSolicitud controller;

    public void setModel(ModelSolicitud model) {
        this.model = model;
        model.addObserver(this);
    }

    public void setController(ControllerSolicitud controller) {
        this.controller = controller;
    }

    /**
     * Creates new form View
     */
    public ViewSolicitud() {
        initComponents();
        configurar();
    }

    private void configurar() {
        setLocationRelativeTo(null);
        setTitle("Solicitud de ingreso de bienes");
        selectorFecha.setMaxDate(Calendar.getInstance());
    }

    public boolean verificarCamposAgregarBien() {
        boolean bandera = true;
        if (campoDescripcion.getText().isEmpty()) {
            lbDescripcion.setForeground(Color.red);
            bandera = false;
        }
        if (campoMarca.getText().isEmpty()) {
            lbMarca.setForeground(Color.red);
            bandera = false;
        }
        if (campoModelo.getText().isEmpty()) {
            lbModelo.setForeground(Color.red);
            bandera = false;
        }
        if (campoPrecioUnitario.getText().isEmpty()) {
            lbPrecioUnitario.setForeground(Color.red);
            bandera = false;
        }
        return bandera;
    }

    public boolean verificarCamposCrearSolicitud() {
        boolean bandera = true;
        if (campoNumComprobante.getText().isEmpty()) {
            lbNumComprobante.setForeground(Color.red);
            bandera = false;
        }
        if (campoTipoAdq.getText().isEmpty()) {
            lbTipoAdq.setForeground(Color.red);
            bandera = false;
        }
        if (this.jComboBox1.getSelectedIndex() == 0) {
            lbCombo.setForeground(Color.red);
            bandera = false;
        }
        return bandera;
    }

    public void restaurarColorAgregarBien() {
        lbDescripcion.setForeground(Color.black);
        lbMarca.setForeground(Color.black);
        lbModelo.setForeground(Color.black);
        lbPrecioUnitario.setForeground(Color.black);
    }

    public void restaurarColorCrearSolicitud() {
        lbNumComprobante.setForeground(Color.black);
        lbTipoAdq.setForeground(Color.black);
        lbCombo.setForeground(Color.black);
    }

    public void limpiarCamposAgregarBien() {
        campoDescripcion.setText(null);
        campoMarca.setText(null);
        campoModelo.setText(null);
        campoPrecioUnitario.setText(null);
    }

    public void limpiarCamposCrearSolicitud() {
        limpiarCamposAgregarBien();
        campoNumComprobante.setText(null);
        campoTipoAdq.setText(null);
    }

    private void agregarSolicitud() {
        restaurarColorAgregarBien();
        restaurarColorCrearSolicitud();
        if (verificarCamposCrearSolicitud()) {
            nuevaSolicitud = new Solicitud();
            nuevaSolicitud.setNumComprobante(campoNumComprobante.getText());

            Calendar c1 = this.selectorFecha.getSelectedDate();
            String fecha = String.format("%s/%s/%s", Integer.toString(c1.get(Calendar.DAY_OF_MONTH)), Integer.toString(c1.get(Calendar.MONTH)), Integer.toString(c1.get(Calendar.YEAR)));
            nuevaSolicitud.setFecha(fecha);

            nuevaSolicitud.setTipoAdquisicion(campoTipoAdq.getText());
            nuevaSolicitud.setCantidadBienes(nuevaSolicitud.getBienes().size());
            nuevaSolicitud.setMontoToTal(nuevaSolicitud.definirMontoTotal());
            nuevaSolicitud.setEstado(jComboBox1.getSelectedItem().toString());
            try {
                controller.agregarSolicitud(nuevaSolicitud);
            } catch (GlobalException | NoDataException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void agregarBienASolicitud() {
    }

//    private int toNumero(String numero, JLabel etq) {
//        int cambio = -1;
//        try {
//            cambio = Integer.parseInt(numero);
//        } catch (NumberFormatException nf) {
//            JOptionPane.showMessageDialog(null, "Solo digite numeros para el número de comprobante", "Error", JOptionPane.ERROR_MESSAGE);
//            etq.setForeground(Color.red);
//        }
//        return cambio;
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBien = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lbDescripcion = new javax.swing.JLabel();
        lbMarca = new javax.swing.JLabel();
        lbModelo = new javax.swing.JLabel();
        lbPrecioUnitario = new javax.swing.JLabel();
        campoDescripcion = new javax.swing.JTextField();
        campoMarca = new javax.swing.JTextField();
        campoModelo = new javax.swing.JTextField();
        campoPrecioUnitario = new javax.swing.JTextField();
        btnAgregarBien = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lbNumComprobante = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbTipoAdq = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campoNumComprobante = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        campoTipoAdq = new javax.swing.JTextField();
        campoCantBienes = new javax.swing.JTextField();
        campoMontoTotal = new javax.swing.JTextField();
        lbCombo = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnAgregarSolicitud = new javax.swing.JButton();
        selectorFecha = new datechooser.beans.DateChooserCombo();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jTableBien.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTableBien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableBien);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setPreferredSize(new java.awt.Dimension(304, 222));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Ingreso de bienes");

        lbDescripcion.setText("Descripción: ");

        lbMarca.setText("Marca:");

        lbModelo.setText("Modelo:");

        lbPrecioUnitario.setText("Precio Unitario:");

        campoPrecioUnitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoPrecioUnitarioActionPerformed(evt);
            }
        });

        btnAgregarBien.setText("Agregar bien");
        btnAgregarBien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarBienActionPerformed(evt);
            }
        });

        jLabel1.setText("Serial:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 96, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(91, 91, 91))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbDescripcion)
                                        .addComponent(lbMarca)
                                        .addComponent(lbModelo))
                                    .addGap(21, 21, 21))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(lbPrecioUnitario)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(50, 50, 50)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAgregarBien)
                            .addComponent(campoDescripcion)
                            .addComponent(campoMarca)
                            .addComponent(campoModelo)
                            .addComponent(campoPrecioUnitario, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(jTextField1))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(campoDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMarca)
                            .addComponent(campoMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbModelo))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbPrecioUnitario)))
                    .addComponent(lbDescripcion))
                .addGap(49, 49, 49)
                .addComponent(btnAgregarBien)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbNumComprobante.setText("Numero de comprobante:");

        jLabel2.setText("Fecha de adquisición: ");

        lbTipoAdq.setText("Tipo de adquisición:");

        jLabel4.setText("Cantidad de bienes:");

        campoNumComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNumComprobanteActionPerformed(evt);
            }
        });
        campoNumComprobante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoNumComprobanteKeyTyped(evt);
            }
        });

        jLabel5.setText("Monto total:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Datos del comprobante");

        campoCantBienes.setText("0");
        campoCantBienes.setEnabled(false);

        campoMontoTotal.setText("0.00");
        campoMontoTotal.setEnabled(false);

        lbCombo.setText("Estado:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Recibida", "Por verificar", "Solicitud procesada" }));

        btnAgregarSolicitud.setText("Agregar solicitud ");
        btnAgregarSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarSolicitudActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(141, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(58, 58, 58))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNumComprobante)
                            .addComponent(jLabel2)
                            .addComponent(lbTipoAdq)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(lbCombo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(campoTipoAdq)
                                .addComponent(campoCantBienes)
                                .addComponent(campoMontoTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                .addComponent(campoNumComprobante)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(selectorFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(btnAgregarSolicitud)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNumComprobante)
                    .addComponent(campoNumComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(selectorFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTipoAdq)
                            .addComponent(campoTipoAdq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addComponent(campoCantBienes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCombo)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAgregarSolicitud)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Bienes agregados a la solicitud");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(223, 223, 223))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoPrecioUnitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoPrecioUnitarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoPrecioUnitarioActionPerformed

    private void btnAgregarBienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarBienActionPerformed
        // TODO add your handling code here:
        try {
            controller.listarBien();
        } catch (GlobalException | NoDataException ex) {
            Logger.getLogger(ViewSolicitud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAgregarBienActionPerformed

    private void btnAgregarSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarSolicitudActionPerformed
        agregarSolicitud();

    }//GEN-LAST:event_btnAgregarSolicitudActionPerformed

    private void campoNumComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNumComprobanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNumComprobanteActionPerformed

    private void campoNumComprobanteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNumComprobanteKeyTyped
        // TODO add your handling code here:
//        char car = evt.getKeyChar();
//        if (!Character.isLetter(car)) {
//            evt.setKeyChar(' ');
//            JOptionPane.showMessageDialog(null, "Mensaje", "Titulo", JOptionPane.ERROR_MESSAGE);
//            String texto = campoNumComprobante.getText();
//            String num = texto.substring(0, texto.length());
//            campoNumComprobante.setText(num);
        //}
    }//GEN-LAST:event_campoNumComprobanteKeyTyped

    @Override
    public void update(Observable o, Object arg) {
        this.jTableBien.setModel(model.getTableBien());
    }

    private Bien nuevoBien = new Bien();
    private Solicitud nuevaSolicitud = null;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarBien;
    private javax.swing.JButton btnAgregarSolicitud;
    private javax.swing.JTextField campoCantBienes;
    private javax.swing.JTextField campoDescripcion;
    private javax.swing.JTextField campoMarca;
    private javax.swing.JTextField campoModelo;
    private javax.swing.JTextField campoMontoTotal;
    private javax.swing.JTextField campoNumComprobante;
    private javax.swing.JTextField campoPrecioUnitario;
    private javax.swing.JTextField campoTipoAdq;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableBien;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbCombo;
    private javax.swing.JLabel lbDescripcion;
    private javax.swing.JLabel lbMarca;
    private javax.swing.JLabel lbModelo;
    private javax.swing.JLabel lbNumComprobante;
    private javax.swing.JLabel lbPrecioUnitario;
    private javax.swing.JLabel lbTipoAdq;
    private datechooser.beans.DateChooserCombo selectorFecha;
    // End of variables declaration//GEN-END:variables
}
