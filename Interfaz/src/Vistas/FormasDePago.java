/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import datos.ConexionSQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author salva
 */
public class FormasDePago extends javax.swing.JFrame {

    ConexionSQL cc = new ConexionSQL();
    java.sql.Connection con = cc.conexion("root", "");
    
    public FormasDePago() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(getBackground());
        mostrarDatos();
    }
    
    public void insertarDatos(){
        
        try {
            String SQL = "insert into FormasPago (idFormaPago, nombre, estatus) values (?,?,?)";
            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setDouble(1, Double.parseDouble(txtIdPago.getText()));
            pst.setString(2, txtNombre.getText());
             int select = cbEstatus.getSelectedIndex();
            pst.setString(3, cbEstatus.getItemAt(select));
            //if(Integer.parseInt(txt_IdEstado.getText()) != Integer.parseInt(txt_IdEstado.getText())){
            //}else{
               pst.execute();
                //JOptionPane.showMessageDialog(null, "Registro Exitoso");
            //}   
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
    public void actualizarDatos(){
        try {
            String SQL = "update FormasPago set idFormaPago=?, nombre=?, estatus=? where idFormaPago=?";
            int filaSeleccionado = tablaFormasPago.getSelectedRow();
            String dao = (String)tablaFormasPago.getValueAt(filaSeleccionado, 0);
            PreparedStatement pst = con.prepareStatement(SQL);
            
            pst.setDouble(1, Double.parseDouble(txtIdPago.getText()));
            pst.setString(2, txtNombre.getText());
            int select = cbEstatus.getSelectedIndex();
            pst.setString(3, cbEstatus.getItemAt(select));
            pst.setString(4, dao);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro Editado Exitoso");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error de Edicion uno de los valores es incorrecto" + e.getMessage());
        }
    }

    public void filtrarDatos(String valor)
    {
        String[] titulos = {"idFormaPago", "nombre", "estatus"}; 
        String[] registros = new String[6];
        
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
        
        String SQL = "select * from FormasPago where nombre like '%" + valor + "%'";
        
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next()){
                registros[0]= rs.getString("idFormaPago");
                registros[1]= rs.getString("nombre");
                registros[2]= rs.getString("estatus");
                modelo.addRow(registros);
            }
            tablaFormasPago.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Mostrar Datos " + e.getMessage());
        }
    }
     public void mostrarDatos(){
        String[] titulos = {"idFormaPago", "nombre",  "estatus"};
        String[] registros = new String[5];
        
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
        String SQL = "select * from FormasPago";
        
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next()){
                registros[0]= rs.getString("idFormaPago");
                registros[1]= rs.getString("nombre");
                registros[2]= rs.getString("estatus");
                modelo.addRow(registros);
            }
            tablaFormasPago.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Mostrar Datos " + e.getMessage());
        }
    }
      public void eliminarRegistros(){
        int filaSeleccionada = tablaFormasPago.getSelectedRow();
        try {
            String SQL = "update FormasPago set estatus= 'I' where idFormaPago = " + tablaFormasPago.getValueAt(filaSeleccionada, 0);
            Statement st = con.createStatement();
            st.executeUpdate(SQL);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el registro"+ e.getMessage());
        }
    }
      
      public void limpiarCajas(){
        txtIdPago.setText("");
        txtNombre.setText("");
        cbEstatus.setSelectedItem(null);
        
    }
    /**
     * 
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbEstatus = new javax.swing.JComboBox<>();
        txtIdPago = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaFormasPago = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("nombre");

        jLabel2.setText("idPago");

        jLabel3.setText("status");

        cbEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A ", "I" }));

        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnNuevo.setText("NUEVO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        tablaFormasPago.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaFormasPago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaFormasPagoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaFormasPago);

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnActualizar)
                        .addGap(32, 32, 32)
                        .addComponent(btnGuardar)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdPago, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addComponent(btnNuevo)
                .addGap(18, 18, 18)
                .addComponent(btnRegresar)
                .addContainerGap(98, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(34, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(104, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(cbEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar)
                    .addComponent(btnNuevo)
                    .addComponent(btnRegresar))
                .addContainerGap(282, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(192, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
 actualizarDatos();
        limpiarCajas();
        mostrarDatos();        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
 insertarDatos();
        limpiarCajas();
        mostrarDatos();        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
eliminarRegistros();
        limpiarCajas();
        mostrarDatos();        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
limpiarCajas();        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void tablaFormasPagoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaFormasPagoMouseClicked
int filaSeleccionada = tablaFormasPago.rowAtPoint(evt.getPoint());
        txtIdPago.setText(tablaFormasPago.getValueAt(filaSeleccionada, 0).toString());
        txtNombre.setText(tablaFormasPago.getValueAt(filaSeleccionada, 1).toString());
        
        cbEstatus.setSelectedItem((tablaFormasPago.getValueAt(filaSeleccionada, 3)));        // TODO add your handling code here:
    }//GEN-LAST:event_tablaFormasPagoMouseClicked

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        PaginaPrincipal pg = new PaginaPrincipal(con);
        pg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormasDePago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormasDePago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormasDePago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormasDePago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormasDePago().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbEstatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaFormasPago;
    private javax.swing.JTextField txtIdPago;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
