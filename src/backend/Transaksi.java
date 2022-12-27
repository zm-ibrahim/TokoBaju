/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author IBRAHIM
 */
public class Transaksi implements IFeature{
    private int idTransaksi, jumlahBeli, hargaBeli, totalBeli;
    private String tanggalTransaksi;
    Baju baju;
    Pelanggan pelanggan;
    
    public Transaksi(){
    }
    
    public Transaksi(Baju baju, Pelanggan pelanggan, String tanggalTransaksi, int jumlahBeli, int harga){
        this.baju = baju;
        this.pelanggan = pelanggan;
        this.tanggalTransaksi = tanggalTransaksi;
        this.jumlahBeli = jumlahBeli;
        this.hargaBeli = harga;
        this.totalBeli = harga*jumlahBeli;
    }
    
    public Transaksi getById(int id) {
        Transaksi trs = new Transaksi();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM transaksi " + "WHERE id_transaksi = '" + id + "'");

        try {
            while (rs.next()) {
                Baju baj = new Baju().getById(rs.getInt("id_baju"));   
                Pelanggan plg = new Pelanggan().getById(rs.getInt("id_pelanggan"));
                
                trs.setIdTransaksi(rs.getInt("id_transaksi"));
                trs.setBaju(baj);
                trs.setPelanggan(plg);
                trs.setTanggalTransaksi(rs.getString("tanggal_transaksi"));
                trs.setJumlahBeli(rs.getInt("jumlah_beli"));
                trs.setTotalBeli(rs.getInt("total_harga"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trs;
    }

    public ArrayList<Transaksi> getAll() {
        ArrayList<Transaksi> ListTransaksi = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("Select * From transaksi");

        try {
            while (rs.next()) {
                Transaksi trs = new Transaksi();
                Baju baju = new Baju().getById(rs.getInt("id_baju"));   
                Pelanggan plg = new Pelanggan().getById(rs.getInt("id_pelanggan"));
                
                trs.setIdTransaksi(rs.getInt("id_transaksi"));
                trs.setBaju(baju);
                trs.setPelanggan(plg);
                trs.setTanggalTransaksi(rs.getString("tanggal_transaksi"));
                trs.setJumlahBeli(rs.getInt("jumlah_beli"));
                trs.setTotalBeli(rs.getInt("total_harga"));
                
                ListTransaksi.add(trs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListTransaksi;
    }

    public ArrayList<Transaksi> search(String keyword) {
        ArrayList<Transaksi> ListTransaksi = new ArrayList();

        String sql = "Select "
                +"  tr.id_transaksi AS idtransaksi, "
                +"  tr.tanggal_transaksi AS tgltransaksi, "
                +"  p.id_pelanggan AS idpelanggan, "
                +"  p.nama_pelanggan AS namapelanggan, "
                +"  b.id_baju AS idbaju, "
                +"  b.nama_baju AS namabaju "
                +"  FROM transaksi tr"
                +"  LEFT JOIN pelanggan p ON tr.id_pelanggan = p.idpelanggan"
                +"  LEFT JOIN baju b ON tr.id_baju = b.idbaju "
                +"  WHERE p.namapelanggan LIKE '%" + keyword + "%' "
                +"  OR b.namabaju LIKE '%" + keyword + "%' "
                +"  OR tr.tgltransaksi LIKE '%" + keyword + "%' ";

        ResultSet rs = DBHelper.selectQuery(sql);

        try {
            while (rs.next()) {
                Transaksi trs = new Transaksi();
                Baju baju = new Baju().getById(rs.getInt("id_baju"));   
                Pelanggan plg = new Pelanggan().getById(rs.getInt("id_pelanggan"));
                
                trs.setIdTransaksi(rs.getInt("id_transaksi"));
                trs.setBaju(baju);
                trs.setPelanggan(plg);
                trs.setTanggalTransaksi(rs.getString("tanggal_transaksi"));
                trs.setJumlahBeli(rs.getInt("jumlah_beli"));
                trs.setTotalBeli(rs.getInt("total_harga"));

                ListTransaksi.add(trs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListTransaksi;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public int getJumlahBeli() {
        return jumlahBeli;
    }

    public void setJumlahBeli(int jumlahBeli) {
        this.jumlahBeli = jumlahBeli;
    }

    public int getHargaBeli() {
        return hargaBeli;
    }

    public void setHargaBeli(int hargaBeli) {
        this.hargaBeli = hargaBeli;
    }

    public int getTotalBeli() {
        return totalBeli;
    }

    public void setTotalBeli(int totalBeli) {
        this.totalBeli = totalBeli;
    }
    
    public void setTotalBeli(int harga, int jml){
        this.totalBeli = harga*jml;
    }

    public String getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(String tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public Baju getBaju() {
        return baju;
    }

    public void setBaju(Baju baju) {
        this.baju = baju;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    
    
    @Override
    public void save() {
        if (getById(idTransaksi).getIdTransaksi() == 0) {
            String SQL = "INSERT INTO transaksi (id_baju,id_pelanggan,tanggal_transaksi,jumlah_beli,total_harga) VALUES("
                    + "     '" + this.baju.getIdBaju() + "', "
                    + "     '" + this.pelanggan.getIdPelanggan() + "', "
                    + "     '" + this.tanggalTransaksi + "', "
                    + "     '" + this.jumlahBeli + "', "
                    + "     '" + this.totalBeli + "' "
                    + "     )";
            this.idTransaksi = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE transaksi SET "
                    + "    id_baju =  '" + this.baju.getIdBaju() + "', "
                    + "    id_pelanggan =  '" + this.pelanggan.getIdPelanggan() + "', "
                    + "    tanggal_transaksi = '" + this.tanggalTransaksi + "', "
                    + "    jumlah_beli = '" + this.jumlahBeli + "', "
                    + "    total_harga = '" + this.totalBeli + "'"
                    + "     WHERE id_transaksi = '" + this.idTransaksi + "'";
//            System.out.println(SQL);
            DBHelper.executeQuery(SQL);
        }
    }

    @Override
    public void delete() {
        String SQL = "DELETE FROM transaksi WHERE id_transaksi = '" + this.idTransaksi + "'";
        DBHelper.executeQuery(SQL);
    }
    
    
}
