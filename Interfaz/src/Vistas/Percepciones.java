
package Vistas;

import datos.Paginacion;
import datos.ConexionSQL;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Percepciones extends javax.swing.JFrame {
    
    ConexionSQL cc = new ConexionSQL();
    Connection con = cc.conexion("root", "");
    int i = 0;
    int inicio = 0;
    int fin = 5;
    int limit;

    public Percepciones() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(getBackground());
        mostrarDatos(inicio, fin);
        Paginacion p = new Paginacion(con);
        limit = getLimit(Integer.parseInt(p.count("Percepciones")), fin);
    }
    
    public void insertarDatos(){
        try {
            String SQL = "insert into Percepciones (idPercepcion, nombre, descripcion, diasPagar, estatus) values (?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setDouble(1, Double.parseDouble(txtidPercepcion.getText()));
            pst.setString(2, txtNombre.getText());
            pst.setString(3, txtDescripcion.getText());
            pst.setString(4, txtdiasPagar.getText());
            int select = cbEstatus.getSelectedIndex();
            pst.setString(5, cbEstatus.getItemAt(select));
            pst.execute();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error el id debe ser unico ");
        }
    }
    
    public void actualizarDatos(){
        try {
            String SQL = "update Percepciones set idPercepcion=?, nombre=?, descripcion=?, diasPagar=?, estatus=? where idPercepcion=?";
            int filaSeleccionado = tbPercepciones.getSelectedRow();
            String dao = (String)tbPercepciones.getValueAt(filaSeleccionado, 0);
            PreparedStatement pst = con.prepareStatement(SQL);
            
            pst.setDouble(1, Double.parseDouble(txtidPercepcion.getText()));
            pst.setString(2, txtNombre.getText());
            pst.setString(3, txtDescripcion.getText());
            pst.setString(4, txtdiasPagar.getText());
            int select = cbEstatus.getSelectedIndex();
            pst.setString(5, cbEstatus.getItemAt(select));
            pst.setString(6, dao);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro Editado Exitoso");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error de Edicion uno de los valores es incorrecto" + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtidPercepcion = new javax.swing.JTextField();
        txtdiasPagar = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        cbEstatus = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPercepciones = new javax.swing.JTable();
        btnAtras = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel2.setText("idPercepcion");

        jLabel3.setText("Nombre");

        jLabel4.setText("Descripcion");

        jLabel5.setText("DiasPagar");

        txtdiasPagar.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtdiasPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdiasPagarActionPerformed(evt);
            }
        });

        jLabel6.setText("Estatus");

        cbEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "I" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(24, 24, 24)
                        .addComponent(txtDescripcion))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addGap(41, 41, 41)
                        .addComponent(txtNombre))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(btnRegresar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtidPercepcion))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdiasPagar)
                            .addComponent(cbEstatus, 0, 155, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtidPercepcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtdiasPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegresar)
                .addGap(28, 28, 28))
        );

        tbPercepciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbPercepciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPercepcionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbPercepciones);

        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        jLabel1.setText("Busqueda:");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(159, 159, 159)
                                .addComponent(btnAtras)
                                .addGap(69, 69, 69)
                                .addComponent(btnSiguiente))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 84, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtras)
                    .addComponent(btnSiguiente))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtdiasPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdiasPagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdiasPagarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiarCajas();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarRegistros();
        limpiarCajas();
        mostrarDatos(inicio, fin);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        insertarDatos();
        limpiarCajas();
        mostrarDatos(inicio, fin);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizarDatos();
        limpiarCajas();
        mostrarDatos(inicio, fin);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        PaginaPrincipal pg = new PaginaPrincipal(con);
        pg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        filtrarDatos(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void tbPercepcionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPercepcionesMouseClicked
        int filaSeleccionada = tbPercepciones.rowAtPoint(evt.getPoint());
        txtidPercepcion.setText(tbPercepciones.getValueAt(filaSeleccionada, 0).toString());
        txtNombre.setText(tbPercepciones.getValueAt(filaSeleccionada, 1).toString());
        txtDescripcion.setText(tbPercepciones.getValueAt(filaSeleccionada, 2).toString());
        txtdiasPagar.setText(tbPercepciones.getValueAt(filaSeleccionada, 3).toString());
        cbEstatus.setSelectedItem((tbPercepciones.getValueAt(filaSeleccionada, 4)));
    }//GEN-LAST:event_tbPercepcionesMouseClicked

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        if (inicio == limit * 10) {
            btnSiguiente.setEnabled(false);
        } else {
            btnAtras.setEnabled(true);
            inicio = inicio + 5;
            mostrarDatos(inicio, fin);
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        if (inicio == 0) {
            btnAtras.setEnabled(false);
        } else {
            btnSiguiente.setEnabled(true);
            inicio = inicio - 5;
            mostrarDatos(inicio, fin);
        }
    }//GEN-LAST:event_btnAtrasActionPerformed

public void filtrarDatos(String valor){
        String[] titulos = {"idPercepcion", "nombre", "descripcion", "diasPagar", "estatus"};
        String[] registros = new String[6];       
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);         
        String SQL = "select * from Percepciones where nombre like '%" + valor + "%'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next()){
                registros[0]= rs.getString("idPercepcion");
                registros[1]= rs.getString("nombre");
                registros[2]= rs.getString("descripcion");
                registros[3]= rs.getString("diasPagar");
                registros[4]= rs.getString("estatus");
                modelo.addRow(registros);
            }
            tbPercepciones.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Mostrar Datos " + e.getMessage());
        }
    }
    
    public void mostrarDatos(int inicio, int fin){
        String[] titulos = {"idPercepcion", "nombre", "descripcion", "diasPagar", "estatus"};
        String[] registros = new String[6];       
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);     
        String SQL = "select * from Percepciones where estatus = 'A' limit " + inicio + ", " + fin;
        
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next()){
                registros[0]= rs.getString("idPercepcion");
                registros[1]= rs.getString("nombre");
                registros[2]= rs.getString("descripcion");
                registros[3]= rs.getString("diasPagar");
                registros[4]= rs.getString("estatus");
                modelo.addRow(registros);
            }
            tbPercepciones.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Mostrar Datos " + e.getMessage());
        }
    }
    
    public void eliminarRegistros(){
        int filaSeleccionada = tbPercepciones.getSelectedRow();
        try {
            String SQL = "update Percepciones set estatus= 'I' where idPercepcion = " + tbPercepciones.getValueAt(filaSeleccionada, 0);
            Statement st = con.createStatement();
            st.executeUpdate(SQL);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el registro"+ e.getMessage());
        }
    }
    
    public void limpiarCajas(){
        txtidPercepcion.setText("");
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtdiasPagar.setText("");
        cbEstatus.setSelectedItem(null);
        
    }
    
    public int getLimit(int n, int lim) {
        limit = (int) Math.ceil(n / lim);
        System.out.println(n + " " + limit);
        return limit;
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Percepciones().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JComboBox<String> cbEstatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbPercepciones;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JFormattedTextField txtdiasPagar;
    private javax.swing.JTextField txtidPercepcion;
    // End of variables declaration//GEN-END:variables
}
