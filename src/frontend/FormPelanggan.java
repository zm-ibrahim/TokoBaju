/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import backend.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class FormPelanggan extends javax.swing.JFrame {

    String jk;

    /**
     * Creates new form FormPelanggan
     */
    public FormPelanggan() {
        initComponents();
        emptyPelanggan();
        showPelanggan();
    }

    public void emptyPelanggan() {
        tfIdPelanggan.setText("0");
        tfNamaPelanggan.setText("");
        tfNoTelpPelanggan.setText("");
        radioP.setSelected(false);
        radioL.setSelected(false);
        taAlamatPelanggan.setText("");
    }

    public void showPelanggan() {
        String[] kolom = {"Id", "Nama", "No Telp", "Jenis Kelamin", "Alamat"};
        ArrayList<Pelanggan> list = new Pelanggan().getAll();
        Object rowData[] = new Object[5];

        tabPelanggan.setModel(new DefaultTableModel(new Object[][]{}, kolom));

        for (Pelanggan plg : list) {
            rowData[0] = plg.getIdPelanggan();
            rowData[1] = plg.getNamaPelanggan();
            rowData[2] = plg.getNoTelp();
            rowData[3] = plg.getJk();
            rowData[4] = plg.getAlamat();

            ((DefaultTableModel) tabPelanggan.getModel()).addRow(rowData);
        }
    }

    public void cariPelanggan(String keyword) {
        String[] kolom = {"Id", "Nama", "No Telp", "Jenis Kelamin", "Alamat"};
        ArrayList<Pelanggan> list = new Pelanggan().search(keyword);
        Object rowData[] = new Object[5];

        tabPelanggan.setModel(new DefaultTableModel(new Object[][]{}, kolom));

        for (Pelanggan plg : list) {
            rowData[0] = plg.getIdPelanggan();
            rowData[1] = plg.getNamaPelanggan();
            rowData[2] = plg.getNoTelp();
            rowData[3] = plg.getJk();
            rowData[4] = plg.getAlamat();

            ((DefaultTableModel) tabPelanggan.getModel()).addRow(rowData);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        tfIdPelanggan = new javax.swing.JTextField();
        tfNamaPelanggan = new javax.swing.JTextField();
        tfNoTelpPelanggan = new javax.swing.JTextField();
        radioP = new javax.swing.JRadioButton();
        radioL = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taAlamatPelanggan = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabPelanggan = new javax.swing.JTable();
        btSavePelanggan = new javax.swing.JButton();
        btResetPelanggan = new javax.swing.JButton();
        btDeletePelanggan = new javax.swing.JButton();
        btExitPelanggan = new javax.swing.JButton();
        butFindPelanggan = new javax.swing.JButton();
        tfFindPelanggan = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        btMoveBaju = new javax.swing.JButton();
        btMoveJenis = new javax.swing.JButton();
        btMoveTransaksi = new javax.swing.JButton();
        btMovePembayaran = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tfIdPelanggan.setEditable(false);
        tfIdPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdPelangganActionPerformed(evt);
            }
        });

        tfNamaPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNamaPelangganActionPerformed(evt);
            }
        });

        tfNoTelpPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNoTelpPelangganActionPerformed(evt);
            }
        });

        radioP.setText("Perempuan");
        radioP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioPActionPerformed(evt);
            }
        });

        radioL.setText("Laki laki");
        radioL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioLActionPerformed(evt);
            }
        });

        taAlamatPelanggan.setColumns(20);
        taAlamatPelanggan.setRows(5);
        jScrollPane1.setViewportView(taAlamatPelanggan);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Form Pelanggan");

        jLabel2.setText("Id");

        jLabel3.setText("Nama");

        jLabel4.setText("No Telepon");

        jLabel5.setText("Jenis Kelamin");

        jLabel6.setText("Alamat");

        tabPelanggan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Nama", "No Telepon", "Jenis Kelamin", "Alamat"
            }
        ));
        tabPelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabPelangganMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabPelanggan);

        btSavePelanggan.setText("Save");
        btSavePelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSavePelangganActionPerformed(evt);
            }
        });

        btResetPelanggan.setText("Reset");
        btResetPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btResetPelangganActionPerformed(evt);
            }
        });

        btDeletePelanggan.setText("Delete");
        btDeletePelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeletePelangganActionPerformed(evt);
            }
        });

        btExitPelanggan.setText("Exit");
        btExitPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExitPelangganActionPerformed(evt);
            }
        });

        butFindPelanggan.setText("Find");
        butFindPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butFindPelangganActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setText("Pindah Halaman");

        btMoveBaju.setText("Baju");
        btMoveBaju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMoveBajuActionPerformed(evt);
            }
        });

        btMoveJenis.setText("Jenis");
        btMoveJenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMoveJenisActionPerformed(evt);
            }
        });

        btMoveTransaksi.setText("Transaksi");
        btMoveTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMoveTransaksiActionPerformed(evt);
            }
        });

        btMovePembayaran.setText("Pembayaran");
        btMovePembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMovePembayaranActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btMoveTransaksi)
                        .addGap(18, 18, 18)
                        .addComponent(btMovePembayaran)
                        .addGap(18, 18, 18)
                        .addComponent(btExitPelanggan)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(tfNoTelpPelanggan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                                .addComponent(tfNamaPelanggan, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(tfIdPelanggan, javax.swing.GroupLayout.Alignment.LEADING))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(radioP, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(radioL, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btSavePelanggan)
                                        .addGap(18, 18, 18)
                                        .addComponent(btResetPelanggan)
                                        .addGap(18, 18, 18)
                                        .addComponent(btDeletePelanggan))
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(btMoveBaju)
                                        .addGap(18, 18, 18)
                                        .addComponent(btMoveJenis)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfFindPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(butFindPelanggan)))
                        .addContainerGap(12, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfIdPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfNamaPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfNoTelpPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radioP)
                            .addComponent(radioL)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btResetPelanggan)
                            .addComponent(btSavePelanggan)
                            .addComponent(btDeletePelanggan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btMoveBaju)
                            .addComponent(btMoveJenis)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(butFindPelanggan)
                            .addComponent(tfFindPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btMoveTransaksi)
                    .addComponent(btMovePembayaran)
                    .addComponent(btExitPelanggan))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pelanggan", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfIdPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdPelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdPelangganActionPerformed

    private void tfNamaPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNamaPelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNamaPelangganActionPerformed

    private void tfNoTelpPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNoTelpPelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNoTelpPelangganActionPerformed

    private void tabPelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPelangganMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tabPelanggan.getModel();
        int row = tabPelanggan.getSelectedRow();

        tfIdPelanggan.setText(model.getValueAt(row, 0).toString());
        tfNamaPelanggan.setText(model.getValueAt(row, 1).toString());
        tfNoTelpPelanggan.setText(model.getValueAt(row, 2).toString());
        if (model.getValueAt(row, 3).toString().equals("Lk")) {
            radioL.setSelected(true);
            jk = "Lk";
        }
        if (model.getValueAt(row, 3).toString().equals("PR")) {
            radioP.setSelected(true);
            jk = "PR";
        }
        taAlamatPelanggan.setText(model.getValueAt(row, 4).toString());

    }//GEN-LAST:event_tabPelangganMouseClicked

    private void btSavePelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSavePelangganActionPerformed
        // TODO add your handling code here:
        Pelanggan plg = new Pelanggan();
        plg.setIdPelanggan(Integer.parseInt(tfIdPelanggan.getText()));

        if ((((tfNamaPelanggan.getText()).isEmpty() || (tfNoTelpPelanggan.getText()).isEmpty()) || jk == null || (taAlamatPelanggan.getText()).isEmpty())) {
            JOptionPane.showMessageDialog(null, "Data Belum Lengkap !");
        } else {
            plg.setNamaPelanggan(tfNamaPelanggan.getText());
            plg.setNoTelp(tfNoTelpPelanggan.getText());
            plg.setJk(jk);
            plg.setAlamat(taAlamatPelanggan.getText());
            plg.save();
            tfIdPelanggan.setText(Integer.toString(plg.getIdPelanggan()));
            showPelanggan();
        }

    }//GEN-LAST:event_btSavePelangganActionPerformed

    private void btResetPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btResetPelangganActionPerformed
        // TODO add your handling code here:
        emptyPelanggan();
    }//GEN-LAST:event_btResetPelangganActionPerformed

    private void btDeletePelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeletePelangganActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tabPelanggan.getModel();
        int row = tabPelanggan.getSelectedRow();

        Pelanggan pelanggan = new Pelanggan().getById(Integer.parseInt(model.getValueAt(row, 0).toString()));
        pelanggan.delete();
        emptyPelanggan();
        showPelanggan();
    }//GEN-LAST:event_btDeletePelangganActionPerformed

    private void btExitPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExitPelangganActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btExitPelangganActionPerformed

    private void btMoveBajuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMoveBajuActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormBaju().setVisible(true);
                dispose();
            }
        });
    }//GEN-LAST:event_btMoveBajuActionPerformed

    private void btMoveJenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMoveJenisActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormJenis().setVisible(true);
                dispose();
            }
        });
    }//GEN-LAST:event_btMoveJenisActionPerformed

    private void btMoveTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMoveTransaksiActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTransaksi().setVisible(true);
                dispose();
            }
        });
    }//GEN-LAST:event_btMoveTransaksiActionPerformed

    private void butFindPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butFindPelangganActionPerformed
        // TODO add your handling code here:
        cariPelanggan(tfFindPelanggan.getText());
    }//GEN-LAST:event_butFindPelangganActionPerformed

    private void radioPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPActionPerformed
        // TODO add your handling code here:
        if (radioP.isSelected()) {
            radioL.setSelected(false);
            jk = "PR";
        }
    }//GEN-LAST:event_radioPActionPerformed

    private void radioLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioLActionPerformed
        // TODO add your handling code here:
        if (radioL.isSelected()) {
            radioP.setSelected(false);
            jk = "Lk";
        }
    }//GEN-LAST:event_radioLActionPerformed

    private void btMovePembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMovePembayaranActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPembayaran().setVisible(true);
                dispose();
            }
        });
    }//GEN-LAST:event_btMovePembayaranActionPerformed

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
            java.util.logging.Logger.getLogger(FormPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPelanggan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDeletePelanggan;
    private javax.swing.JButton btExitPelanggan;
    private javax.swing.JButton btMoveBaju;
    private javax.swing.JButton btMoveJenis;
    private javax.swing.JButton btMovePembayaran;
    private javax.swing.JButton btMoveTransaksi;
    private javax.swing.JButton btResetPelanggan;
    private javax.swing.JButton btSavePelanggan;
    private javax.swing.JButton butFindPelanggan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton radioL;
    private javax.swing.JRadioButton radioP;
    private javax.swing.JTextArea taAlamatPelanggan;
    private javax.swing.JTable tabPelanggan;
    private javax.swing.JTextField tfFindPelanggan;
    private javax.swing.JTextField tfIdPelanggan;
    private javax.swing.JTextField tfNamaPelanggan;
    private javax.swing.JTextField tfNoTelpPelanggan;
    // End of variables declaration//GEN-END:variables
}