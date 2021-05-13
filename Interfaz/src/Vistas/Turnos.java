package Vistas;

import datos.Paginacion;
import datos.ConexionSQL;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.*;
import java.util.*;

public class Turnos extends javax.swing.JFrame {

    ConexionSQL cc = new ConexionSQL();
    Connection con = cc.conexion("root", "");

    int i = 0;
    int inicio = 0;
    int fin = 5;
    int limit;

    public Turnos() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(getBackground());
        mostrarDatos(inicio, fin);
        Paginacion p = new Paginacion(con);
        limit = getLimit(Integer.parseInt(p.count("Turnos")), fin);

    }

    public void insertarDatos() {
        try {
            String SQL = "insert into Turnos (idTurno, nombre, horaInicio, horaFin, dias, estatus) values (?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setDouble(1, Double.parseDouble(txtTurno.getText()));
            pst.setString(2, txtnombre.getText());
            int select = cbEstatus.getSelectedIndex();
            pst.setString(3, fmtHoraI.getText());
            pst.setString(4, fmtHoraF.getText());
            pst.setString(5, txtDias.getText());
            pst.setString(6, cbEstatus.getItemAt(select));
            if (Integer.parseInt(fmtHoraI.getText()) < Integer.parseInt(fmtHoraF.getText())) {
                pst.execute();
                JOptionPane.showMessageDialog(null, "Registro Exitoso");
            } else {
                JOptionPane.showMessageDialog(null, "Error la hora Final tiene que ser mayor a la hora Inicial y el id debe ser unico ");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error la fecha Final tiene que ser mayor a la fecha Inicial y el id debe ser unico ");
        }
    }

    public void actualizarDatos() {
        try {
            String SQL = "update Turnos set idTurno=?, nombre=?, horaInicio=?, horaFin=?, dias=?, estatus=? where idTurno=?";
            int filaSeleccionado = tbTurno.getSelectedRow();
            String dao = (String) tbTurno.getValueAt(filaSeleccionado, 0);
            PreparedStatement pst = con.prepareStatement(SQL);

            pst.setDouble(1, Double.parseDouble(txtTurno.getText()));
            pst.setString(2, txtnombre.getText());
            int select = cbEstatus.getSelectedIndex();
            pst.setString(3, fmtHoraI.getText());
            pst.setString(4, fmtHoraF.getText());
            pst.setString(5, txtDias.getText());
            pst.setString(6, cbEstatus.getItemAt(select));
            pst.setString(7, dao);
            if (Integer.parseInt(fmtHoraI.getText()) < Integer.parseInt(fmtHoraF.getText())) {
                pst.execute();
                JOptionPane.showMessageDialog(null, "Registro Editado Exitoso");
            } else {
                JOptionPane.showMessageDialog(null, "Error la hora Final tiene que ser mayor a la hora Inicial y el id debe ser unico ");
            }
        } catch (Exception e) {
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
        jLabel6 = new javax.swing.JLabel();
        txtTurno = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbEstatus = new javax.swing.JComboBox<>();
        txtDias = new javax.swing.JTextField();
        fmtHoraI = new javax.swing.JFormattedTextField();
        fmtHoraF = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTurno = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnAtras = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

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

        jLabel2.setText("idTurno");

        jLabel3.setText("nombre");

        jLabel4.setText("horaInicio");

        jLabel5.setText("horaFin");

        jLabel6.setText("dias");

        txtTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTurnoActionPerformed(evt);
            }
        });

        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });

        jLabel7.setText("estatus");

        cbEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "I" }));

        fmtHoraI.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("000000"))));
        fmtHoraI.setToolTipText("000000");

        fmtHoraF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("000000"))));
        fmtHoraF.setToolTipText("000000");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(49, 49, 49)
                                    .addComponent(txtTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnGuardar)
                                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(60, 60, 60)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnActualizar)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5))
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbEstatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDias)
                                    .addComponent(fmtHoraF)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fmtHoraI)
                                    .addComponent(txtnombre, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(btnRegresar)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fmtHoraI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(fmtHoraF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnNuevo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnGuardar))
                .addGap(8, 8, 8)
                .addComponent(btnRegresar)
                .addContainerGap())
        );

        tbTurno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbTurno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTurnoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbTurno);

        jLabel1.setText("Busqueda:");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(btnAtras)
                                .addGap(124, 124, 124)
                                .addComponent(btnSiguiente))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtras)
                    .addComponent(btnSiguiente))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void txtTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTurnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTurnoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        insertarDatos();
        limpiarCajas();
        mostrarDatos(inicio, fin);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        eliminarRegistros();
        limpiarCajas();
        mostrarDatos(inicio, fin);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiarCajas();
    }//GEN-LAST:event_btnNuevoActionPerformed

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

    private void tbTurnoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTurnoMouseClicked
        int filaSeleccionada = tbTurno.rowAtPoint(evt.getPoint());
        txtTurno.setText(tbTurno.getValueAt(filaSeleccionada, 0).toString());
        txtnombre.setText(tbTurno.getValueAt(filaSeleccionada, 1).toString());
        fmtHoraI.setText(tbTurno.getValueAt(filaSeleccionada, 2).toString());
        fmtHoraF.setText(tbTurno.getValueAt(filaSeleccionada, 3).toString());
        txtDias.setText(tbTurno.getValueAt(filaSeleccionada, 4).toString());
        cbEstatus.setSelectedItem((tbTurno.getValueAt(filaSeleccionada, 5)));
    }//GEN-LAST:event_tbTurnoMouseClicked

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

    public void filtrarDatos(String valor) {
        String[] titulos = {"idTurno", "nombre", "horaInicio", "horaFin", "dias", "estatus"};
        String[] registros = new String[7];

        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

        String SQL = "select * from Turnos where nombre like '%" + valor + "%'";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                registros[0] = rs.getString("idTurno");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("horaInicio");
                registros[3] = rs.getString("horaFin");
                registros[4] = rs.getString("dias");
                registros[5] = rs.getString("estatus");
                modelo.addRow(registros);
            }
            tbTurno.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Mostrar Datos " + e.getMessage());
        }
    }

    public void mostrarDatos(int inicio, int fin) {
        String[] titulos = {"idTurno", "nombre", "horaInicio", "horaFin", "dias", "estatus"};
        String[] registros = new String[7];

        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

        String SQL = "select * from Turnos where estatus = 'A' limit " + inicio + ", " + fin;

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                registros[0] = rs.getString("idTurno");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("horaInicio");
                registros[3] = rs.getString("horaFin");
                registros[4] = rs.getString("dias");
                registros[5] = rs.getString("estatus");
                modelo.addRow(registros);
            }
            tbTurno.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Mostrar Datos " + e.getMessage());
        }
    }

    public void eliminarRegistros() {
        int filaSeleccionada = tbTurno.getSelectedRow();
        try {
            String SQL = "update Turnos set estatus = 'I' where idTurno = " + tbTurno.getValueAt(filaSeleccionada, 0);
            Statement st = con.createStatement();
            st.executeUpdate(SQL);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el registro" + e.getMessage());
        }
    }

    public void limpiarCajas() {
        txtTurno.setText("");
        txtnombre.setText("");
        fmtHoraI.setText("");
        fmtHoraF.setText("");
        txtDias.setText("");
        cbEstatus.setSelectedItem(null);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Turnos().setVisible(true);
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
    private javax.swing.JFormattedTextField fmtHoraF;
    private javax.swing.JFormattedTextField fmtHoraI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbTurno;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDias;
    private javax.swing.JTextField txtTurno;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables

    public int getLimit(int n, int lim) {
        limit = (int) Math.ceil(n / lim);
        System.out.println(n + " " + limit);
        return limit;
    }
}
