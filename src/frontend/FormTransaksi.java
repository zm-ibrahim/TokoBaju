/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import backend.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class FormTransaksi extends javax.swing.JFrame {

    int idp;

    /**
     * Creates new form FormTransaksi
     */
    public FormTransaksi() {
        initComponents();
        emptyTransaksi();
        showTransaksi();
        tampilkanCmbPelangganTransaksi();
        tampilkanCmbBajuTransaksi();
    }

    public void emptyTransaksi() {
        tfIdTransaksi.setText("0");
        cbBajuTransaksi.setSelectedIndex(0);
        cbPelangganTransaksi.setSelectedIndex(0);
        tfTanggalTransaksi.setText("");
        tfJumlahTransaksi.setText("0");
        txtHargaTransaksi.setText("0");
        cbMetodeBayar.setSelectedIndex(0);
    }

    public void showTransaksi() {
        String[] kolom = {"Id", "Baju", "Pelanggan", "Tanggal", "Jumlah", "Harga", "Total"};
        ArrayList<Transaksi> list = new Transaksi().getAll();
        Object rowData[] = new Object[7];

        tabTransaksi.setModel(new DefaultTableModel(new Object[][]{}, kolom));

        for (Transaksi trs : list) {
            rowData[0] = trs.getIdTransaksi();
            rowData[1] = trs.getBaju().getMerkBaju();
            rowData[2] = trs.getPelanggan().getNamaPelanggan();
            rowData[3] = trs.getTanggalTransaksi();
            rowData[4] = trs.getJumlahBeli();
            rowData[5] = (trs.getTotalBeli() / trs.getJumlahBeli());
            rowData[6] = trs.getTotalBeli();

            ((DefaultTableModel) tabTransaksi.getModel()).addRow(rowData);
        }
    }

    public void cariTransaksi(String keyword) {
        String[] kolom = {"Id", "Baju", "Pelanggan", "Tanggal", "Jumlah", "Harga", "Total"};
        ArrayList<Transaksi> list = new Transaksi().search(keyword);
        Object rowData[] = new Object[7];

        tabTransaksi.setModel(new DefaultTableModel(new Object[][]{}, kolom));

        for (Transaksi trs : list) {
            rowData[0] = trs.getIdTransaksi();
            rowData[1] = trs.getBaju();
            rowData[2] = trs.getPelanggan();
            rowData[3] = trs.getTanggalTransaksi();
            rowData[4] = trs.getJumlahBeli();
            rowData[5] = trs.getHargaBeli();
            rowData[6] = trs.getJumlahBeli() * trs.getHargaBeli();

            ((DefaultTableModel) tabTransaksi.getModel()).addRow(rowData);
        }
    }

    public void tampilkanCmbBajuTransaksi() {

        try {
            String SQL = "SELECT * FROM baju";
            ResultSet rs = DBHelper.selectQuery(SQL);
            while (rs.next()) {
                cbBajuTransaksi.addItem(rs.getString("nama_baju"));
//        cbBajuTransaksi.setModel(new DefaultComboBoxModel(new Baju().getAll().toArray()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tampilkanCmbPelangganTransaksi() {

        try {
            String SQL = "SELECT * FROM pelanggan";
            ResultSet rs = DBHelper.selectQuery(SQL);
            while (rs.next()) {
                cbPelangganTransaksi.addItem(rs.getString("nama_pelanggan"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tampilkanCbMetodeBayar() {

        try {
            String SQL = "SELECT * FROM pembayaran WHERE id_pelanggan = '" + idp + "' ";
            ResultSet rs = DBHelper.selectQuery(SQL);
            while (rs.next()) {
                cbMetodeBayar.addItem(rs.getString("namaBayar"));
//        cbBajuTransaksi.setModel(new DefaultComboBoxModel(new Baju().getAll().toArray()));
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabTransaksi = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        tfIdTransaksi = new javax.swing.JTextField();
        cbBajuTransaksi = new javax.swing.JComboBox<>();
        cbPelangganTransaksi = new javax.swing.JComboBox<>();
        tfTanggalTransaksi = new javax.swing.JTextField();
        tfJumlahTransaksi = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btSaveTransaksi = new javax.swing.JButton();
        btResetTransaksi = new javax.swing.JButton();
        btDeleteTransaksi = new javax.swing.JButton();
        tfFindTransaksi = new javax.swing.JTextField();
        btFindTransaksi = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        btMoveBaju = new javax.swing.JButton();
        btMoveJenis = new javax.swing.JButton();
        btMovePelanggan = new javax.swing.JButton();
        btMovePembayaran = new javax.swing.JButton();
        btExitTransaksi = new javax.swing.JButton();
        txtHargaTransaksi = new javax.swing.JLabel();
        btCekHarga = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbMetodeBayar = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Baju", "Pelanggan", "Tanggal", "Jumlah", "Harga", "Total"
            }
        ));
        tabTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabTransaksiMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabTransaksi);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Form Transaksi");

        tfIdTransaksi.setEditable(false);

        cbBajuTransaksi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Baju" }));

        cbPelangganTransaksi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Pelanggan" }));

        tfTanggalTransaksi.setToolTipText("FORMAT YYYY/MM/DD");

        jLabel15.setText("Id");

        jLabel16.setText("Baju");

        jLabel17.setText("Pelanggan");

        jLabel18.setText("Tanggal");

        jLabel19.setText("Jumlah");

        jLabel20.setText("Harga");

        btSaveTransaksi.setText("Proses");
        btSaveTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveTransaksiActionPerformed(evt);
            }
        });

        btResetTransaksi.setText("Reset");
        btResetTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btResetTransaksiActionPerformed(evt);
            }
        });

        btDeleteTransaksi.setText("Delete");
        btDeleteTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteTransaksiActionPerformed(evt);
            }
        });

        btFindTransaksi.setText("Find");
        btFindTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFindTransaksiActionPerformed(evt);
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

        btMovePelanggan.setText("Pelanggan");
        btMovePelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMovePelangganActionPerformed(evt);
            }
        });

        btMovePembayaran.setText("Pembayaran");
        btMovePembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMovePembayaranActionPerformed(evt);
            }
        });

        btExitTransaksi.setText("Exit");
        btExitTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExitTransaksiActionPerformed(evt);
            }
        });

        txtHargaTransaksi.setText("0");

        btCekHarga.setText("Cek Harga");
        btCekHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCekHargaActionPerformed(evt);
            }
        });

        jLabel1.setText("Rp.");

        jLabel2.setText("Metode Bayar");

        cbMetodeBayar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Metode Bayar" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btMovePelanggan)
                        .addGap(18, 18, 18)
                        .addComponent(btMovePembayaran)
                        .addGap(18, 18, 18)
                        .addComponent(btExitTransaksi)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(btMoveBaju)
                                .addGap(18, 18, 18)
                                .addComponent(btMoveJenis))
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(btSaveTransaksi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btResetTransaksi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btDeleteTransaksi))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel2))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cbBajuTransaksi, javax.swing.GroupLayout.Alignment.LEADING, 0, 123, Short.MAX_VALUE)
                                            .addComponent(tfIdTransaksi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                            .addComponent(cbPelangganTransaksi, javax.swing.GroupLayout.Alignment.LEADING, 0, 123, Short.MAX_VALUE)
                                            .addComponent(tfTanggalTransaksi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                            .addComponent(tfJumlahTransaksi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addComponent(btCekHarga))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtHargaTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cbMetodeBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(tfFindTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btFindTransaksi)))
                        .addGap(15, 15, 15))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfFindTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btFindTransaksi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel14)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfIdTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbBajuTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbPelangganTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfTanggalTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfJumlahTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(btCekHarga))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtHargaTransaksi)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbMetodeBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btSaveTransaksi)
                            .addComponent(btResetTransaksi)
                            .addComponent(btDeleteTransaksi))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btMoveBaju)
                            .addComponent(btMoveJenis))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btMovePelanggan)
                    .addComponent(btMovePembayaran)
                    .addComponent(btExitTransaksi)))
        );

        jTabbedPane1.addTab("Transaksi", jPanel3);

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
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabTransaksiMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tabTransaksi.getModel();
        int row = tabTransaksi.getSelectedRow();
        Transaksi transaksi = new Transaksi();
        Baju baju = new Baju();

        transaksi = transaksi.getById(Integer.parseInt(model.getValueAt(row, 0).toString()));

        tfIdTransaksi.setText(model.getValueAt(row, 0).toString());
        cbBajuTransaksi.getModel().setSelectedItem(transaksi.getBaju().getMerkBaju());
        cbPelangganTransaksi.getModel().setSelectedItem(transaksi.getPelanggan().getNamaPelanggan());
        tfTanggalTransaksi.setText(model.getValueAt(row, 3).toString());
        tfJumlahTransaksi.setText(model.getValueAt(row, 4).toString());
        txtHargaTransaksi.setText(model.getValueAt(row, 5).toString());
    }//GEN-LAST:event_tabTransaksiMouseClicked

    private void btSaveTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveTransaksiActionPerformed
        // TODO add your handling code here:
        boolean cek = true;
        if (0 == cbBajuTransaksi.getSelectedIndex()) {
            JOptionPane.showMessageDialog(null, "Baju belum dipilih !");
            cek = false;
        }
        else if (0 == cbPelangganTransaksi.getSelectedIndex()) {
            JOptionPane.showMessageDialog(null, "Pelanggan belum dipilih !");
            cek = false;
        }
        else if ((tfTanggalTransaksi.getText()).isEmpty()){
            JOptionPane.showMessageDialog(null, "Tanggal belum diisi !");
            cek = false;
        }
        else if (0 == Integer.parseInt((tfJumlahTransaksi.getText()))){
            JOptionPane.showMessageDialog(null, "Jumlah tidak boleh 0 !");
            cek = false;
        } else if (0 == cbMetodeBayar.getSelectedIndex()){
            JOptionPane.showMessageDialog(null, "Metode Bayar Belum dipilih !");
            cek = false;
        }
        
        if(cek){
            String metode = (String) cbMetodeBayar.getSelectedItem();
        Debit dbt = new Debit().getByNama(metode);
        String SQL = "SELECT * FROM pembayaran WHERE tipebayar = '" + dbt.getTipeBayar() + "' ";
        ResultSet rs = DBHelper.selectQuery(SQL);

        try {
            while (rs.next()) {
                System.out.println("TipeBayar :"+rs.getString("tipebayar"));
                if (rs.getString("tipebayar").equals("debit")) {

                    SQL = "SELECT * FROM pembayaran WHERE id_pembayaran = '" + dbt.getIdBayar() + "' ";
                    rs = DBHelper.selectQuery(SQL);
                    while (rs.next()) {
                        int nominal = rs.getInt("nominal");
                        if (nominal > Integer.parseInt(txtHargaTransaksi.getText())) {
                            dbt.setSaldo(rs.getInt("nominal"));
                            dbt.kurangSaldo(Integer.parseInt(txtHargaTransaksi.getText()));
                            cek = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Saldo tidak cukup cak!");
                        }
                    }
                } else if (rs.getString("tipebayar").equals("kredit")) {

                    SQL = "SELECT * FROM pembayaran WHERE id_pembayaran = '" + dbt.getIdBayar() + "' ";
                    rs = DBHelper.selectQuery(SQL);
                    while (rs.next()) {
                        Kredit kdt = new Kredit().getByNama(metode);
                        int nominal = rs.getInt("nominal");
                        kdt.setTotalKredit(rs.getInt("nominal"));
                        kdt.tambahKredit(Integer.parseInt(txtHargaTransaksi.getText()));
                        cek = true;
                    }

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.print(cek);
        if (cek) {
            Transaksi trs = new Transaksi();
            Baju baju = new Baju().getByNama(cbBajuTransaksi.getSelectedItem().toString());
            Pelanggan plg = new Pelanggan();

            trs.setIdTransaksi(Integer.parseInt(tfIdTransaksi.getText()));
            trs.setBaju(baju);

            SQL = "SELECT * FROM baju WHERE id_baju = '" + baju.getIdBaju() + "' ";
            rs = DBHelper.selectQuery(SQL);
            try {
                while (rs.next()) {
                    if (((Integer.parseInt(tfJumlahTransaksi.getText())) <= rs.getInt("stok")) && ((rs.getInt("stok") > 0))) {
                        baju.kurangStok((Integer.parseInt(tfJumlahTransaksi.getText())));
                    } else {
                        JOptionPane.showMessageDialog(null, "Stok Baju tidak mencukupi ! ");
                        cek = false;
                    }
                }
//            baju.getStok();
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (cek) {
                trs.setPelanggan(plg.getByNama((String) cbPelangganTransaksi.getSelectedItem()));
                trs.setTanggalTransaksi(tfTanggalTransaksi.getText());
                trs.setJumlahBeli(Integer.parseInt(tfJumlahTransaksi.getText()));
                trs.setHargaBeli(baju.getByNama(cbBajuTransaksi.getSelectedItem().toString()).getHarga());
                trs.setTotalBeli(Integer.parseInt(txtHargaTransaksi.getText()));
                trs.save();
                tfIdTransaksi.setText(Integer.toString(trs.getIdTransaksi()));
                showTransaksi();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Metode bayar tidak valid!");
        }
        }
        


    }//GEN-LAST:event_btSaveTransaksiActionPerformed

    private void btResetTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btResetTransaksiActionPerformed
        // TODO add your handling code here:
        emptyTransaksi();
    }//GEN-LAST:event_btResetTransaksiActionPerformed

    private void btDeleteTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteTransaksiActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tabTransaksi.getModel();
        int row = tabTransaksi.getSelectedRow();

        Transaksi transaksi = new Transaksi().getById(Integer.parseInt(model.getValueAt(row, 0).toString()));
        transaksi.delete();
        emptyTransaksi();
        showTransaksi();
    }//GEN-LAST:event_btDeleteTransaksiActionPerformed

    private void btExitTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExitTransaksiActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btExitTransaksiActionPerformed

    private void btFindTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFindTransaksiActionPerformed
        // TODO add your handling code here:
        cariTransaksi(tfFindTransaksi.getText());
    }//GEN-LAST:event_btFindTransaksiActionPerformed

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

    private void btMovePelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMovePelangganActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPelanggan().setVisible(true);
                dispose();
            }
        });
    }//GEN-LAST:event_btMovePelangganActionPerformed

    private void btMovePembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMovePembayaranActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPembayaran().setVisible(true);
                dispose();
            }
        });
    }//GEN-LAST:event_btMovePembayaranActionPerformed

    private void btCekHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCekHargaActionPerformed
        // TODO add your handling code here:
        cbMetodeBayar.setSelectedIndex(0);
        Baju baju = new Baju();
        Transaksi tr = new Transaksi();
        Pelanggan plg = new Pelanggan();

        tr.setPelanggan(plg.getByNama((String) cbPelangganTransaksi.getSelectedItem()));
        idp = tr.getPelanggan().getIdPelanggan();
        int jumlah = Integer.parseInt(tfJumlahTransaksi.getText());
        int harga = baju.getByNama(cbBajuTransaksi.getModel().getSelectedItem().toString()).getHarga();

        tr.setTotalBeli(harga, jumlah);
        txtHargaTransaksi.setText(Integer.toString(tr.getTotalBeli()));
        tampilkanCbMetodeBayar();
    }//GEN-LAST:event_btCekHargaActionPerformed

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
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCekHarga;
    private javax.swing.JButton btDeleteTransaksi;
    private javax.swing.JButton btExitTransaksi;
    private javax.swing.JButton btFindTransaksi;
    private javax.swing.JButton btMoveBaju;
    private javax.swing.JButton btMoveJenis;
    private javax.swing.JButton btMovePelanggan;
    private javax.swing.JButton btMovePembayaran;
    private javax.swing.JButton btResetTransaksi;
    private javax.swing.JButton btSaveTransaksi;
    private javax.swing.JComboBox<String> cbBajuTransaksi;
    private javax.swing.JComboBox<String> cbMetodeBayar;
    private javax.swing.JComboBox<String> cbPelangganTransaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabTransaksi;
    private javax.swing.JTextField tfFindTransaksi;
    private javax.swing.JTextField tfIdTransaksi;
    private javax.swing.JTextField tfJumlahTransaksi;
    private javax.swing.JTextField tfTanggalTransaksi;
    private javax.swing.JLabel txtHargaTransaksi;
    // End of variables declaration//GEN-END:variables
}
