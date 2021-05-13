
package Vistas;

import datos.Paginacion;
import datos.ConexionSQL;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Asistencias extends javax.swing.JFrame {

    ConexionSQL cc = new ConexionSQL();
    Connection con = cc.conexion("root", "");
    int i = 0;
    int inicio = 0;
    int fin = 5;
    int limit;

    public Asistencias() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(getBackground());
        mostrarDatos(inicio, fin);
        Paginacion p = new Paginacion(con);
        limit = getLimit(Integer.parseInt(p.count("Asistencias")), fin);
    }

    public void insertarDatos(){
        try {
            String SQL = "insert into Asistencias (idAsistencia, fecha, horaEntrada, horaSalida, dia, idEmpleado, estatus) values (?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setDouble(1, Double.parseDouble(txtidAsistencia.getText()));
            SimpleDateFormat dFormat = new SimpleDateFormat("yyyy/MM/dd");
            String date = dFormat.format(dateFecha.getDate());
            pst.setString(2, date);
            pst.setString(3, txthoraEntrada.getText());
            pst.setString(4, txthoraSalida.getText());
            pst.setString(5, txtDia.getText());
            int select = cbEmpleado.getSelectedIndex();
            pst.setString(6, cbEmpleado.getItemAt(select));
            int select1 = cbEstatus.getSelectedIndex();
            pst.setString(7, cbEstatus.getItemAt(select1));
            pst.execute();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error el id debe ser unico ");
        }
    }
    
    public void actualizarDatos(){
        try {
            String SQL = "update Asistencias set idAsistencia=?, fecha=?, horaEntrada=?, horaSalida=?, dia=?, idEmpleado=?, estatus=? where idAsistencia=?";
            int filaSeleccionado = tbAsistencias.getSelectedRow();
            String dao = (String)tbAsistencias.getValueAt(filaSeleccionado, 0);
            PreparedStatement pst = con.prepareStatement(SQL);
            
            pst.setDouble(1, Double.parseDouble(txtidAsistencia.getText()));
            SimpleDateFormat dFormat = new SimpleDateFormat("yyyy/MM/dd");
            String date = dFormat.format(dateFecha.getDate());
            pst.setString(2, date);
            pst.setString(3, txthoraEntrada.getText());
            pst.setString(4, txthoraSalida.getText());
            pst.setString(5, txtDia.getText());
            int select = cbEmpleado.getSelectedIndex();
            pst.setString(6, cbEmpleado.getItemAt(select));
            int select1 = cbEstatus.getSelectedIndex();
            pst.setString(7, cbEstatus.getItemAt(select1));
            pst.setString(8, dao);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtidAsistencia = new javax.swing.JTextField();
        dateFecha = new com.toedter.calendar.JDateChooser();
        txthoraEntrada = new javax.swing.JFormattedTextField();
        txthoraSalida = new javax.swing.JFormattedTextField();
        txtDia = new javax.swing.JTextField();
        cbEmpleado = new javax.swing.JComboBox<>();
        btnNuevo = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cbEstatus = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAsistencias = new javax.swing.JTable();
        btnAtras = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setText("idAsistencia");

        jLabel2.setText("fecha");

        jLabel3.setText("horaEntrada");

        jLabel4.setText("horaSalida");

        jLabel5.setText("dia");

        jLabel6.setText("idEmpleado");

        dateFecha.setDateFormatString("yyyy/MM/dd");

        txthoraEntrada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("000000"))));

        txthoraSalida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("000000"))));

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

        jLabel8.setText("estatus");

        cbEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "I" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(btnRegresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(51, 51, 51)
                        .addComponent(cbEstatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtidAsistencia)
                            .addComponent(dateFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(txthoraEntrada)
                            .addComponent(txthoraSalida)
                            .addComponent(txtDia)
                            .addComponent(cbEmpleado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtidAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(dateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txthoraEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txthoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnGuardar))
                .addGap(18, 18, 18)
                .addComponent(btnRegresar)
                .addGap(28, 28, 28))
        );

        tbAsistencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbAsistencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAsistenciasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbAsistencias);

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

        jLabel7.setText("Busqueda:");

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
                        .addGap(156, 156, 156)
                        .addComponent(btnAtras)
                        .addGap(82, 82, 82)
                        .addComponent(btnSiguiente))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtras)
                    .addComponent(btnSiguiente))
                .addGap(42, 42, 42))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        if (inicio == 0) {
            btnAtras.setEnabled(false);
        } else {
            btnSiguiente.setEnabled(true);
            inicio = inicio - 5;
            mostrarDatos(inicio, fin);
        }
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        if (inicio == limit * 10) {
            btnSiguiente.setEnabled(false);
        } else {
            btnAtras.setEnabled(true);
            inicio = inicio + 5;
            mostrarDatos(inicio, fin);
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed

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

    private void tbAsistenciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAsistenciasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbAsistenciasMouseClicked

    public void filtrarDatos(String valor){
        String[] titulos = {"idAsistencia", "fecha", "horaEntrada", "horaSalida", "dia", "idEmpleado", "estatus"};
        String[] registros = new String[7];       
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);         
        String SQL = "select * from Asistencias where nombre like '%" + valor + "%'";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next()){
                registros[0]= rs.getString("idAsistencia");
                registros[1]= rs.getString("fecha");
                registros[2]= rs.getString("horaEntrada");
                registros[3]= rs.getString("horaSalida");
                registros[4]= rs.getString("dia");
                registros[5]= rs.getString("idEmpleado");
                registros[6]= rs.getString("estatus");
                modelo.addRow(registros);
            }
            tbAsistencias.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Mostrar Datos " + e.getMessage());
        }
    }
    
    public void mostrarDatos(int inicio, int fin){
        String[] titulos = {"idAsistencia", "fecha", "horaEntrada", "horaSalida", "dia", "idEmpleado", "estatus"};
        String[] registros = new String[8];       
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);     
        String SQL = "select * from Asistencias where estatus = 'A' limit " + inicio + ", " + fin;
        
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next()){
                registros[0]= rs.getString("idAsistencia");
                registros[1]= rs.getString("fecha");
                registros[2]= rs.getString("horaEntrada");
                registros[3]= rs.getString("horaSalida");
                registros[4]= rs.getString("dia");
                registros[5]= rs.getString("idEmpleado");
                registros[6]= rs.getString("estatus");
                modelo.addRow(registros);
            }
            tbAsistencias.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Mostrar Datos " + e.getMessage());
        }
    }
    
    public void eliminarRegistros(){
        int filaSeleccionada = tbAsistencias.getSelectedRow();
        try {
            String SQL = "update Asistencias set estatus= 'I' where idAsistencia = " + tbAsistencias.getValueAt(filaSeleccionada, 0);
            Statement st = con.createStatement();
            st.executeUpdate(SQL);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el registro"+ e.getMessage());
        }
    }
    
    public void limpiarCajas(){
        txtidAsistencia.setText("");
        txthoraEntrada.setText("");
        txthoraSalida.setText("");
        txtDia.setText("");
        cbEmpleado.setSelectedItem(null);
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
                new Asistencias().setVisible(true);
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
    private javax.swing.JComboBox<String> cbEmpleado;
    private javax.swing.JComboBox<String> cbEstatus;
    private com.toedter.calendar.JDateChooser dateFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbAsistencias;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDia;
    private javax.swing.JFormattedTextField txthoraEntrada;
    private javax.swing.JFormattedTextField txthoraSalida;
    private javax.swing.JTextField txtidAsistencia;
    // End of variables declaration//GEN-END:variables

}
