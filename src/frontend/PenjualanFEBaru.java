/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frontend;

import backend.*;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

/**
 *
 * @author ASUS
 */
public class PenjualanFEBaru extends javax.swing.JFrame {

    /**
     * Creates new form PenjualanFE
     */
    public PenjualanFEBaru() {
        initComponents();
        showJenis();
        showBaju();
        showTransaksi();
        emptyBaju();
        emptyTransaksi();
        emptyJenis();
        tampilkanCmbBajuTransaksi();
        tampilkanCmbJenisBaju();
    }

    public void emptyJenis() {
        tfIdJenis.setText("0");
        tfNamaJenis.setText("");
        taKetJenis.setText("");
    }

    public void showJenis() {
        String[] kolom = {"Id", "Nama", "Keterangan"};
        ArrayList<Jenis> list = new Jenis().getAll();
        Object rowData[] = new Object[3];

        tabJenis.setModel(new DefaultTableModel(new Object[][]{}, kolom));

        for (Jenis jen : list) {
            rowData[0] = jen.getIdjenis();
            rowData[1] = jen.getNamaJenis();
            rowData[2] = jen.getKeterangan();

            ((DefaultTableModel) tabJenis.getModel()).addRow(rowData);
        }
    }

    public void cariJenis(String keyword) {
        String[] kolom = {"Id", "Nama", "Keterangan"};
        ArrayList<Jenis> list = new Jenis().search(keyword);
        Object rowData[] = new Object[3];

        tabJenis.setModel(new DefaultTableModel(new Object[][]{}, kolom));

        for (Jenis jen : list) {
            rowData[0] = jen.getIdjenis();
            rowData[1] = jen.getNamaJenis();
            rowData[2] = jen.getKeterangan();

            ((DefaultTableModel) tabJenis.getModel()).addRow(rowData);
        }
    }

    public void emptyBaju() {
        tfIdBaju.setText("0");
        cbJenisBaju.setSelectedIndex(0);
        tfMerkBaju.setText("");
        tfHargaBaju.setText("");
        cbUkuranBaju.setSelectedIndex(0);
        tfStokBaju.setText("");
    }

    public void showBaju() {
        String[] kolom = {"Id", "Jenis", "Merk", "Harga", "Ukuran", "Stok"};
        ArrayList<Baju> list = new Baju().getAll();
        Object rowData[] = new Object[6];

        tabBaju.setModel(new DefaultTableModel(new Object[][]{}, kolom));

        for (Baju bj : list) {
            rowData[0] = bj.getIdBaju();
            rowData[1] = bj.getJenis().getNamaJenis();
            rowData[2] = bj.getMerkBaju();
            rowData[3] = bj.getHarga();
            rowData[4] = bj.getUkuran();
            rowData[5] = bj.getStok();

            ((DefaultTableModel) tabBaju.getModel()).addRow(rowData);
        }
    }

    public void cariBaju(String keyword) {
        String[] kolom = {"Id", "Jenis", "Merk", "Harga", "Ukuran", "Stok"};
        ArrayList<Baju> list = new Baju().search(keyword);
        Object rowData[] = new Object[6];

        tabBaju.setModel(new DefaultTableModel(new Object[][]{}, kolom));

        for (Baju bj : list) {
            rowData[0] = bj.getIdBaju();
            rowData[1] = bj.getJenis();
            rowData[2] = bj.getMerkBaju();
            rowData[3] = bj.getHarga();
            rowData[4] = bj.getUkuran();
            rowData[5] = bj.getStok();

            ((DefaultTableModel) tabBaju.getModel()).addRow(rowData);
        }
    }

    public void emptyTransaksi() {
        tfIdTransaksi.setText("0");
        cbBajuTransaksi.setSelectedIndex(0);
        cbPelangganTransaksi.setSelectedIndex(0);
        tfTanggalTransaksi.setText("");
        tfJumlahTransaksi.setText("0");
        tfHargaTransaksi.setText("0");
    }

    public void showTransaksi() {
        String[] kolom = {"Id", "Baju", "Pelanggan", "Tanggal", "Jumlah", "Harga", "Total"};
        ArrayList<Transaksi> list = new Transaksi().getAll();
        Object rowData[] = new Object[7];

        tabTransaksi.setModel(new DefaultTableModel(new Object[][]{}, kolom));

        for (Transaksi bj : list) {
            rowData[0] = bj.getIdTransaksi();
            rowData[1] = bj.getBaju();
            rowData[2] = bj.getPelanggan();
            rowData[3] = bj.getTanggalTransaksi();
            rowData[4] = bj.getJumlahBeli();
            rowData[5] = bj.getHargaBeli();
            rowData[6] = bj.getJumlahBeli() * bj.getHargaBeli();

            ((DefaultTableModel) tabTransaksi.getModel()).addRow(rowData);
        }
    }

    public void cariTransaksi(String keyword) {
        String[] kolom = {"Id", "Baju", "Pelanggan", "Tanggal", "Jumlah", "Harga", "Total"};
        ArrayList<Transaksi> list = new Transaksi().search(keyword);
        Object rowData[] = new Object[7];

        tabTransaksi.setModel(new DefaultTableModel(new Object[][]{}, kolom));

        for (Transaksi bj : list) {
            rowData[0] = bj.getIdTransaksi();
            rowData[1] = bj.getBaju();
            rowData[2] = bj.getPelanggan();
            rowData[3] = bj.getTanggalTransaksi();
            rowData[4] = bj.getJumlahBeli();
            rowData[5] = bj.getHargaBeli();
            rowData[6] = bj.getJumlahBeli() * bj.getHargaBeli();

            ((DefaultTableModel) tabTransaksi.getModel()).addRow(rowData);
        }
    }

    public void tampilkanCmbJenisBaju() {
        try {
            String SQL = "SELECT * FROM jenis" ;
            ResultSet rs = DBHelper.selectQuery(SQL);
            while (rs.next()) {
                cbJenisBaju.addItem(rs.getString("nama_jenis"));
//                cbJenisBaju.setModel(new DefaultComboBoxModel(new Jenis().getAll().toArray()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void tampilkanCmbBajuTransaksi() {

        try {
            String SQL = "SELECT * FROM baju" ;
            ResultSet rs = DBHelper.selectQuery(SQL);
            while (rs.next()) {
                cbBajuTransaksi.addItem(rs.getString("nama_baju"));
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
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabBaju = new javax.swing.JTable();
        tfIdBaju = new javax.swing.JTextField();
        cbJenisBaju = new javax.swing.JComboBox<>();
        tfMerkBaju = new javax.swing.JTextField();
        tfHargaBaju = new javax.swing.JTextField();
        tfStokBaju = new javax.swing.JTextField();
        cbUkuranBaju = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btSaveBaju = new javax.swing.JButton();
        btResetBaju = new javax.swing.JButton();
        btDeleteBaju = new javax.swing.JButton();
        btExitBaju = new javax.swing.JButton();
        tfFindBaju = new javax.swing.JTextField();
        btFindBaju = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabTransaksi = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        tfIdTransaksi = new javax.swing.JTextField();
        cbBajuTransaksi = new javax.swing.JComboBox<>();
        cbPelangganTransaksi = new javax.swing.JComboBox<>();
        tfTanggalTransaksi = new javax.swing.JTextField();
        tfJumlahTransaksi = new javax.swing.JTextField();
        tfHargaTransaksi = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btSaveTransaksi = new javax.swing.JButton();
        btResetTransaksi = new javax.swing.JButton();
        btDeleteTransaksi = new javax.swing.JButton();
        btExitTransaksi = new javax.swing.JButton();
        tfFindTransaksi = new javax.swing.JTextField();
        btFindTransaksi = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        tfIdPelanggan = new javax.swing.JTextField();
        tfNamaPelanggan = new javax.swing.JTextField();
        tfNoTelp = new javax.swing.JTextField();
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
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabJenis = new javax.swing.JTable();
        tfFindJenis = new javax.swing.JTextField();
        btFindJenis = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        taKetJenis = new javax.swing.JTextArea();
        tfIdJenis = new javax.swing.JTextField();
        tfNamaJenis = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        btSaveJenis = new javax.swing.JButton();
        btResetJenis = new javax.swing.JButton();
        btDeleteJenis = new javax.swing.JButton();
        btExitJenis = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Form Baju");

        tabBaju.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Jenis", "Merk", "Harga", "Ukuran", "Stok"
            }
        ));
        tabBaju.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabBajuMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabBaju);

        tfIdBaju.setEditable(false);
        tfIdBaju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdBajuActionPerformed(evt);
            }
        });

        cbJenisBaju.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pilih jenis" }));
        cbJenisBaju.setToolTipText("");
        cbJenisBaju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJenisBajuActionPerformed(evt);
            }
        });

        tfMerkBaju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMerkBajuActionPerformed(evt);
            }
        });

        tfStokBaju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfStokBajuActionPerformed(evt);
            }
        });

        cbUkuranBaju.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "M", "L", "XL", "XXL", "XXXL" }));

        jLabel8.setText("Id");

        jLabel9.setText("Jenis");

        jLabel10.setText("Merk");

        jLabel11.setText("Harga");

        jLabel12.setText("Ukuran");

        jLabel13.setText("Stok");

        btSaveBaju.setText("Save");
        btSaveBaju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveBajuActionPerformed(evt);
            }
        });

        btResetBaju.setText("Reset");
        btResetBaju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btResetBajuActionPerformed(evt);
            }
        });

        btDeleteBaju.setText("Delete");
        btDeleteBaju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteBajuActionPerformed(evt);
            }
        });

        btExitBaju.setText("Exit");

        tfFindBaju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFindBajuActionPerformed(evt);
            }
        });

        btFindBaju.setText("Find");
        btFindBaju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFindBajuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbJenisBaju, 0, 123, Short.MAX_VALUE)
                            .addComponent(cbUkuranBaju, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfStokBaju)
                            .addComponent(tfHargaBaju)
                            .addComponent(tfMerkBaju)
                            .addComponent(tfIdBaju))
                        .addGap(125, 125, 125))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btSaveBaju)
                                    .addComponent(btExitBaju))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btResetBaju)
                                    .addComponent(btDeleteBaju)))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tfFindBaju, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btFindBaju)))
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel7)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfIdBaju, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbJenisBaju, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfMerkBaju, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfHargaBaju, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbUkuranBaju, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfStokBaju, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btSaveBaju)
                            .addComponent(btResetBaju))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btDeleteBaju)
                            .addComponent(btExitBaju)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfFindBaju, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btFindBaju))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Baju", jPanel2);

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

        cbBajuTransaksi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pilih baju" }));

        cbPelangganTransaksi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pilih pelanggan" }));

        jLabel15.setText("Id");

        jLabel16.setText("Baju");

        jLabel17.setText("Pelanggan");

        jLabel18.setText("Tanggal");

        jLabel19.setText("Jumlah");

        jLabel20.setText("Harga");

        btSaveTransaksi.setText("Save");
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

        btExitTransaksi.setText("Exit");
        btExitTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExitTransaksiActionPerformed(evt);
            }
        });

        btFindTransaksi.setText("Find");
        btFindTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFindTransaksiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfIdTransaksi)
                            .addComponent(cbBajuTransaksi, 0, 123, Short.MAX_VALUE)
                            .addComponent(cbPelangganTransaksi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfTanggalTransaksi)
                            .addComponent(tfJumlahTransaksi)
                            .addComponent(tfHargaTransaksi))
                        .addGap(119, 119, 119))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btSaveTransaksi)
                                    .addComponent(btExitTransaksi))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btResetTransaksi)
                                    .addComponent(btDeleteTransaksi)))
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tfFindTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btFindTransaksi)))
                .addGap(15, 15, 15))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(jLabel19))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfHargaTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btSaveTransaksi)
                            .addComponent(btResetTransaksi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btDeleteTransaksi)
                            .addComponent(btExitTransaksi)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfFindTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btFindTransaksi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Penjualan", jPanel3);

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

        tfNoTelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNoTelpActionPerformed(evt);
            }
        });

        radioP.setText("Perempuan");

        radioL.setText("Laki laki");

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
        if (tabPelanggan.getColumnModel().getColumnCount() > 0) {
            tabPelanggan.getColumnModel().getColumn(3).setHeaderValue("Jenis Kelamin");
            tabPelanggan.getColumnModel().getColumn(4).setHeaderValue("Alamat");
        }

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(radioP, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(radioL, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tfNoTelp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                        .addComponent(tfNamaPelanggan, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tfIdPelanggan, javax.swing.GroupLayout.Alignment.LEADING))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btSavePelanggan)
                            .addComponent(btExitPelanggan))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btResetPelanggan)
                            .addComponent(btDeletePelanggan))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfFindPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(butFindPelanggan)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(tfNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(btSavePelanggan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btDeletePelanggan)
                            .addComponent(btExitPelanggan)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(butFindPelanggan)
                            .addComponent(tfFindPelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Pelanggan", jPanel1);

        tabJenis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Nama", "Keterangan"
            }
        ));
        tabJenis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabJenisMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tabJenis);

        btFindJenis.setText("Find");
        btFindJenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFindJenisActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setText("Form Jenis");

        taKetJenis.setColumns(20);
        taKetJenis.setRows(5);
        jScrollPane6.setViewportView(taKetJenis);

        tfIdJenis.setEditable(false);
        tfIdJenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdJenisActionPerformed(evt);
            }
        });

        tfNamaJenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNamaJenisActionPerformed(evt);
            }
        });

        jLabel22.setText("Id");

        jLabel23.setText("Nama");

        jLabel24.setText("Keterangan");

        btSaveJenis.setText("Save");
        btSaveJenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveJenisActionPerformed(evt);
            }
        });

        btResetJenis.setText("Reset");
        btResetJenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btResetJenisActionPerformed(evt);
            }
        });

        btDeleteJenis.setText("Delete");
        btDeleteJenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteJenisActionPerformed(evt);
            }
        });

        btExitJenis.setText("Exit");
        btExitJenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExitJenisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(69, 69, 69)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfNamaJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfIdJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btExitJenis)
                                .addGap(18, 18, 18)
                                .addComponent(btDeleteJenis))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btSaveJenis)
                                .addGap(18, 18, 18)
                                .addComponent(btResetJenis)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(tfFindJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btFindJenis)))
                .addGap(14, 14, 14))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfFindJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btFindJenis)
                    .addComponent(jLabel21))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfIdJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfNamaJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btResetJenis, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btSaveJenis, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btDeleteJenis)
                            .addComponent(btExitJenis))
                        .addGap(69, 69, 69)))
                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("Jenis", jPanel4);

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
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfNoTelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNoTelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNoTelpActionPerformed

    private void tfIdPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdPelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdPelangganActionPerformed

    private void btResetPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btResetPelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btResetPelangganActionPerformed

    private void btDeletePelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeletePelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btDeletePelangganActionPerformed

    private void btSavePelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSavePelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btSavePelangganActionPerformed

    private void tfIdBajuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdBajuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdBajuActionPerformed

    private void tfStokBajuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfStokBajuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfStokBajuActionPerformed

    private void btSaveBajuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveBajuActionPerformed
        // TODO add your handling code here:
        Jenis jenis = new Jenis();
        Baju bj = new Baju();
        bj.setIdBaju(Integer.parseInt(tfIdBaju.getText()));
        bj.setJenis((jenis.getByNama(cbJenisBaju.getSelectedItem().toString())));
        bj.setMerkBaju(tfMerkBaju.getText());
        bj.setHarga(Integer.parseInt(tfHargaBaju.getText()));
        bj.setUkuran(cbUkuranBaju.getSelectedItem().toString());
        bj.setStok(Integer.parseInt(tfStokBaju.getText()));
        bj.save();
        tfIdBaju.setText(Integer.toString(bj.getIdBaju()));
        showBaju();
    }//GEN-LAST:event_btSaveBajuActionPerformed

    private void btSaveTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveTransaksiActionPerformed
        // TODO add your handling code here:
        Transaksi trs = new Transaksi();
        trs.setIdTransaksi(Integer.parseInt(tfIdTransaksi.getText()));
        trs.setBaju((Baju) cbBajuTransaksi.getSelectedItem());
        trs.setPelanggan((Pelanggan) cbPelangganTransaksi.getSelectedItem());
        trs.setTanggalTransaksi(tfTanggalTransaksi.getText());
        trs.setJumlahBeli(Integer.parseInt(tfJumlahTransaksi.getText()));
        trs.setHargaBeli(Integer.parseInt(tfHargaTransaksi.getText()));
        trs.save();
        tfIdTransaksi.setText(Integer.toString(trs.getIdTransaksi()));
        showTransaksi();
    }//GEN-LAST:event_btSaveTransaksiActionPerformed

    private void btSaveJenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveJenisActionPerformed
        // TODO add your handling code here:
        Jenis jns = new Jenis();
        jns.setIdjenis(Integer.parseInt(tfIdJenis.getText()));
        jns.setNamaJenis(tfNamaJenis.getText());
        jns.setKeterangan(taKetJenis.getText());
        jns.save();
        tfIdJenis.setText(Integer.toString(jns.getIdjenis()));
        showJenis();
    }//GEN-LAST:event_btSaveJenisActionPerformed

    private void btExitJenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExitJenisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btExitJenisActionPerformed

    private void btDeleteJenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteJenisActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tabJenis.getModel();
        int row = tabJenis.getSelectedRow();

        Jenis jenis = new Jenis().getById(Integer.parseInt(model.getValueAt(row, 0).toString()));
        jenis.delete();
        emptyJenis();
        showJenis();
    }//GEN-LAST:event_btDeleteJenisActionPerformed

    private void tfNamaPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNamaPelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNamaPelangganActionPerformed

    private void tfMerkBajuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMerkBajuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfMerkBajuActionPerformed

    private void btExitTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExitTransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btExitTransaksiActionPerformed

    private void btExitPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExitPelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btExitPelangganActionPerformed

    private void tabPelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPelangganMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tabPelangganMouseClicked

    private void tabBajuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabBajuMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tabBaju.getModel();
        int row = tabBaju.getSelectedRow();
        Baju baju = new Baju();

        baju = baju.getById(Integer.parseInt(model.getValueAt(row, 0).toString()));

        tfIdBaju.setText(model.getValueAt(row, 0).toString());
        cbJenisBaju.getModel().setSelectedItem(baju.getJenis().getNamaJenis());
        tfMerkBaju.setText(model.getValueAt(row, 2).toString());
        tfHargaBaju.setText(model.getValueAt(row, 3).toString());
//        cbUkuranBaju.getModel().setSelectedItem();
        tfStokBaju.setText(model.getValueAt(row, 5).toString());

    }//GEN-LAST:event_tabBajuMouseClicked

    private void tabTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabTransaksiMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tabTransaksi.getModel();
        int row = tabTransaksi.getSelectedRow();
        Transaksi transaksi = new Transaksi();

        transaksi = transaksi.getById(Integer.parseInt(model.getValueAt(row, 0).toString()));

        tfIdTransaksi.setText(model.getValueAt(row, 0).toString());
        cbBajuTransaksi.getModel().setSelectedItem(transaksi.getBaju().getMerkBaju());
        cbPelangganTransaksi.getModel().setSelectedItem(transaksi.getPelanggan().getNamaPelanggan());
        tfTanggalTransaksi.setText(model.getValueAt(row, 3).toString());
        tfJumlahTransaksi.setText(model.getValueAt(row, 4).toString());
        tfHargaTransaksi.setText(model.getValueAt(row, 5).toString());
    }//GEN-LAST:event_tabTransaksiMouseClicked

    private void tabJenisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabJenisMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tabJenis.getModel();
        int row = tabJenis.getSelectedRow();

        tfIdJenis.setText(model.getValueAt(row, 0).toString());
        tfNamaJenis.setText(model.getValueAt(row, 1).toString());
        taKetJenis.setText(model.getValueAt(row, 2).toString());
    }//GEN-LAST:event_tabJenisMouseClicked

    private void tfIdJenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdJenisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdJenisActionPerformed

    private void tfFindBajuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFindBajuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFindBajuActionPerformed

    private void btFindBajuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFindBajuActionPerformed
        // TODO add your handling code here:
        cariBaju(tfFindBaju.getText());
    }//GEN-LAST:event_btFindBajuActionPerformed

    private void btFindTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFindTransaksiActionPerformed
        // TODO add your handling code here:
        cariTransaksi(tfFindTransaksi.getText());
    }//GEN-LAST:event_btFindTransaksiActionPerformed

    private void btFindJenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFindJenisActionPerformed
        // TODO add your handling code here:
        cariJenis(tfFindJenis.getText());
    }//GEN-LAST:event_btFindJenisActionPerformed

    private void btResetBajuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btResetBajuActionPerformed
        // TODO add your handling code here:
        emptyBaju();
    }//GEN-LAST:event_btResetBajuActionPerformed

    private void btResetTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btResetTransaksiActionPerformed
        // TODO add your handling code here:
        emptyTransaksi();
    }//GEN-LAST:event_btResetTransaksiActionPerformed

    private void btResetJenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btResetJenisActionPerformed
        // TODO add your handling code here:
        emptyJenis();
    }//GEN-LAST:event_btResetJenisActionPerformed

    private void btDeleteBajuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteBajuActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tabBaju.getModel();
        int row = tabBaju.getSelectedRow();

        Baju baju = new Baju().getById(Integer.parseInt(model.getValueAt(row, 0).toString()));
        baju.delete();
        emptyBaju();
        showBaju();
    }//GEN-LAST:event_btDeleteBajuActionPerformed

    private void btDeleteTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteTransaksiActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tabTransaksi.getModel();
        int row = tabTransaksi.getSelectedRow();

        Transaksi transaksi = new Transaksi().getById(Integer.parseInt(model.getValueAt(row, 0).toString()));
        transaksi.delete();
        emptyTransaksi();
        showTransaksi();
    }//GEN-LAST:event_btDeleteTransaksiActionPerformed

    private void cbJenisBajuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJenisBajuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbJenisBajuActionPerformed

    private void tfNamaJenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNamaJenisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNamaJenisActionPerformed

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
            java.util.logging.Logger.getLogger(PenjualanFEBaru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PenjualanFEBaru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PenjualanFEBaru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PenjualanFEBaru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PenjualanFEBaru().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDeleteBaju;
    private javax.swing.JButton btDeleteJenis;
    private javax.swing.JButton btDeletePelanggan;
    private javax.swing.JButton btDeleteTransaksi;
    private javax.swing.JButton btExitBaju;
    private javax.swing.JButton btExitJenis;
    private javax.swing.JButton btExitPelanggan;
    private javax.swing.JButton btExitTransaksi;
    private javax.swing.JButton btFindBaju;
    private javax.swing.JButton btFindJenis;
    private javax.swing.JButton btFindTransaksi;
    private javax.swing.JButton btResetBaju;
    private javax.swing.JButton btResetJenis;
    private javax.swing.JButton btResetPelanggan;
    private javax.swing.JButton btResetTransaksi;
    private javax.swing.JButton btSaveBaju;
    private javax.swing.JButton btSaveJenis;
    private javax.swing.JButton btSavePelanggan;
    private javax.swing.JButton btSaveTransaksi;
    private javax.swing.JButton butFindPelanggan;
    private javax.swing.JComboBox<String> cbBajuTransaksi;
    private javax.swing.JComboBox<String> cbJenisBaju;
    private javax.swing.JComboBox<String> cbPelangganTransaksi;
    private javax.swing.JComboBox<String> cbUkuranBaju;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton radioL;
    private javax.swing.JRadioButton radioP;
    private javax.swing.JTextArea taAlamatPelanggan;
    private javax.swing.JTextArea taKetJenis;
    private javax.swing.JTable tabBaju;
    private javax.swing.JTable tabJenis;
    private javax.swing.JTable tabPelanggan;
    private javax.swing.JTable tabTransaksi;
    private javax.swing.JTextField tfFindBaju;
    private javax.swing.JTextField tfFindJenis;
    private javax.swing.JTextField tfFindPelanggan;
    private javax.swing.JTextField tfFindTransaksi;
    private javax.swing.JTextField tfHargaBaju;
    private javax.swing.JTextField tfHargaTransaksi;
    private javax.swing.JTextField tfIdBaju;
    private javax.swing.JTextField tfIdJenis;
    private javax.swing.JTextField tfIdPelanggan;
    private javax.swing.JTextField tfIdTransaksi;
    private javax.swing.JTextField tfJumlahTransaksi;
    private javax.swing.JTextField tfMerkBaju;
    private javax.swing.JTextField tfNamaJenis;
    private javax.swing.JTextField tfNamaPelanggan;
    private javax.swing.JTextField tfNoTelp;
    private javax.swing.JTextField tfStokBaju;
    private javax.swing.JTextField tfTanggalTransaksi;
    // End of variables declaration//GEN-END:variables
}
