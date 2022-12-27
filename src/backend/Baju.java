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
public class Baju implements IFeature {

    private int idBaju;
    private Jenis jenis;
    private String merkBaju, ukuran;
    private int harga, stok;

    public Baju() {

    }

    public Baju(Jenis jenis, String merkBaju, int harga, String ukuran, int stok) {
        this.jenis = jenis;
        this.merkBaju = merkBaju;
        this.harga = harga;
        this.ukuran = ukuran;
        this.stok = stok;
    }

    public int getIdBaju() {
        return idBaju;
    }

    public void setIdBaju(int idBaju) {
        this.idBaju = idBaju;
    }

    public Jenis getJenis() {
        return jenis;
    }

    public void setJenis(Jenis jenis) {
        this.jenis = jenis;
    }

    public String getMerkBaju() {
        return merkBaju;
    }

    public void setMerkBaju(String merkBaju) {
        this.merkBaju = merkBaju;
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public void kurangStok(int jml) {
        System.out.print("Stok Awal : "+this.stok);
        this.stok -= jml;
        System.out.print("Stok Akhir : "+this.stok);
        String SQL = "UPDATE baju SET "
                    + "   stok =  '" + this.stok + "' "
                    + "   WHERE id_baju = '" + this.idBaju + "'";
            DBHelper.executeQuery(SQL);
    }

    public Baju getById(int id) {
        Baju baju = new Baju();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM baju " + "WHERE id_baju = '" + id + "'");

        try {
            while (rs.next()) {
                Jenis jen = new Jenis().getById(rs.getInt("id_jenis"));
//                kategori.setIdkategori(rs.getInt("idkategori"));

                baju.setIdBaju(rs.getInt("id_baju"));
                baju.setJenis(jen);
                baju.setMerkBaju(rs.getString("nama_baju"));
                baju.setHarga(rs.getInt("harga"));
                baju.setUkuran(rs.getString("ukuran"));
                baju.setStok(rs.getInt("Stok"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baju;
    }

    public ArrayList<Baju> getAll() {
        ArrayList<Baju> ListBaju = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("Select * From baju");

        try {
            while (rs.next()) {
                Baju baju = new Baju();
                Jenis jen = new Jenis().getById(rs.getInt("id_jenis"));

                baju.setIdBaju(rs.getInt("id_baju"));
                baju.setJenis(jen);
                baju.setMerkBaju(rs.getString("nama_baju"));
                baju.setHarga(rs.getInt("harga"));
                baju.setUkuran(rs.getString("ukuran"));
                baju.setStok(rs.getInt("Stok"));

                ListBaju.add(baju);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListBaju;
    }

    public ArrayList<Baju> search(String keyword) {
        ArrayList<Baju> ListBaju = new ArrayList();

        String sql = "Select * FROM baju WHERE "
                + " nama_baju LIKE '%" + keyword + "%'"
                + " OR ukuran LIKE '%" + keyword + "%'"
                + " OR harga LIKE '%" + keyword + "%' ";

        ResultSet rs = DBHelper.selectQuery(sql);

        try {
            while (rs.next()) {
                Baju baju = new Baju();
//                Jenis jenis = new Jenis();
//                jenis.setIdjenis(rs.getInt("id_jenis"));
                Jenis jenis = new Jenis().getById(rs.getInt("id_jenis"));

                baju.setIdBaju(rs.getInt("id_baju"));
                baju.setJenis(jenis);
                baju.setMerkBaju(rs.getString("nama_baju"));
                baju.setHarga(rs.getInt("harga"));
                baju.setUkuran(rs.getString("ukuran"));
                baju.setStok(rs.getInt("Stok"));

                ListBaju.add(baju);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListBaju;
    }

    public Baju getByNama(String keyword) {
        Baju baju = new Baju();
        ResultSet rs = DBHelper.selectQuery("Select * From baju where nama_baju ='" + keyword + "'");
        try {
            while (rs.next()) {
                baju = new Baju();
                Jenis jen = new Jenis().getById(rs.getInt("id_jenis"));

                baju.setIdBaju(rs.getInt("id_baju"));
                baju.setJenis(jen);
                baju.setMerkBaju(rs.getString("nama_baju"));
                baju.setHarga(rs.getInt("harga"));
                baju.setUkuran(rs.getString("ukuran"));
                baju.setStok(rs.getInt("Stok"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return baju;

    }

    @Override
    public void save() {
        if (getById(idBaju).getIdBaju() == 0) {
            String SQL = "INSERT INTO baju (id_jenis,nama_baju,harga,ukuran, stok) VALUES("
                    + "     '" + this.jenis.getIdjenis() + "', "
                    + "     '" + this.merkBaju + "', "
                    + "     '" + this.harga + "', "
                    + "     '" + this.ukuran + "', "
                    + "     '" + this.stok + "' "
                    + "     )";
            this.idBaju = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE baju SET "
                    + "   id_jenis =  '" + this.jenis.getIdjenis() + "', "
                    + "   nama_baju =  '" + this.merkBaju + "', "
                    + "   harga =  '" + this.harga + "', "
                    + "   ukuran =   '" + this.ukuran + "', "
                    + "   stok =  '" + this.stok + "' "
                    + "     WHERE id_baju = '" + this.idBaju + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    @Override
    public void delete() {
        String SQL = "DELETE FROM baju WHERE id_baju = '" + this.idBaju + "'";
        DBHelper.executeQuery(SQL);
    }

}
