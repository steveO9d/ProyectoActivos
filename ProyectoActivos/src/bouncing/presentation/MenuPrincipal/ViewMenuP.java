/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bouncing.presentation.MenuPrincipal;

import java.util.Observable;
import java.util.Observer;


/**
 *
 * @author Escinf
 */
public class ViewMenuP extends javax.swing.JFrame implements Observer{
    ModelMenuP model;
    ControllerMenuP controller;

    public void setModel(ModelMenuP model) {
        this.model = model;
        model.addObserver(this);
    }

    public void setController(ControllerMenuP controller) {
        this.controller = controller;
    }
    
    private void configurar(){
        setTitle("Menu Principal");
        setLocationRelativeTo(null);
    }
    
    /**
     * Creates new form View
     */
    public ViewMenuP() {
        initComponents();
        configurar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barraEstado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelUsuario = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuAdministrador = new javax.swing.JMenu();
        itemRegSolicitud = new javax.swing.JMenuItem();
        itemVerSolicitudes = new javax.swing.JMenuItem();
        menuSecretaria = new javax.swing.JMenu();
        solicitudesSecretaria = new javax.swing.JMenuItem();
        menuJefe = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        menuRegistrador = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        barraEstado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Usuario: ");

        labelUsuario.setText("Sin información");

        javax.swing.GroupLayout barraEstadoLayout = new javax.swing.GroupLayout(barraEstado);
        barraEstado.setLayout(barraEstadoLayout);
        barraEstadoLayout.setHorizontalGroup(
            barraEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barraEstadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelUsuario)
                .addContainerGap(313, Short.MAX_VALUE))
        );
        barraEstadoLayout.setVerticalGroup(
            barraEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, barraEstadoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(barraEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelUsuario))
                .addContainerGap())
        );

        menuAdministrador.setText("Administrador");

        itemRegSolicitud.setText("Registrar solicitud");
        itemRegSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRegSolicitudActionPerformed(evt);
            }
        });
        menuAdministrador.add(itemRegSolicitud);

        itemVerSolicitudes.setText("Ver solicitudes");
        itemVerSolicitudes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemVerSolicitudesActionPerformed(evt);
            }
        });
        menuAdministrador.add(itemVerSolicitudes);

        jMenuBar1.add(menuAdministrador);

        menuSecretaria.setText("Secretaria");

        solicitudesSecretaria.setText("Solicitudes");
        solicitudesSecretaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solicitudesSecretariaActionPerformed(evt);
            }
        });
        menuSecretaria.add(solicitudesSecretaria);

        jMenuBar1.add(menuSecretaria);

        menuJefe.setText("Jefe");
        menuJefe.add(jSeparator1);

        jMenu5.setText("OCCB");

        jMenuItem7.setText("Activos");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem7);

        jMenuItem3.setText("Solicitud");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem3);

        jMenuItem1.setText("Asignar registrador");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        menuJefe.add(jMenu5);

        jMenuItem5.setText("RRH");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menuJefe.add(jMenuItem5);

        jMenuBar1.add(menuJefe);

        menuRegistrador.setText("Registrador");

        jMenu2.setText("Bienes");

        jMenuItem4.setText("Mantenimiento");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem6.setText("Incluir");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        menuRegistrador.add(jMenu2);

        jMenu1.setText("Solicitudes");

        jMenuItem2.setText("Listado");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        menuRegistrador.add(jMenu1);

        jMenuBar1.add(menuRegistrador);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barraEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 200, Short.MAX_VALUE)
                .addComponent(barraEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void itemRegSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRegSolicitudActionPerformed
        // SOLICITUD
        controller.iniciarEdicionSolicitud();
        
    }//GEN-LAST:event_itemRegSolicitudActionPerformed

    private void itemVerSolicitudesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemVerSolicitudesActionPerformed
        // TODO add your handling code here:
        controller.iniciarListadoSolicitud();
    }//GEN-LAST:event_itemVerSolicitudesActionPerformed

    private void solicitudesSecretariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solicitudesSecretariaActionPerformed
        // TODO add your handling code here:
        controller.iniciarListadoSolicitud();
    }//GEN-LAST:event_solicitudesSecretariaActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        controller.iniciarListadoSolicitud();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        controller.iniciarListadoSolicitud();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        controller.inicarMantenimientoBienes();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        controller.iniciarIncluirBienes();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    @Override
    public void update(Observable o, Object arg) {
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barraEstado;
    private javax.swing.JMenuItem itemRegSolicitud;
    private javax.swing.JMenuItem itemVerSolicitudes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JMenu menuAdministrador;
    private javax.swing.JMenu menuJefe;
    private javax.swing.JMenu menuRegistrador;
    private javax.swing.JMenu menuSecretaria;
    private javax.swing.JMenuItem solicitudesSecretaria;
    // End of variables declaration//GEN-END:variables
}
