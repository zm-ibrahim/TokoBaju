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
public class Pelanggan implements IFeature {

    private int idPelanggan;
    private String namaPelanggan, alamat, jk, noTelp;

    public Pelanggan() {

    }

    public Pelanggan(String namaPelanggan, String alamat, String jk, String noTelp) {
        this.namaPelanggan = namaPelanggan;
        this.alamat = alamat;
        this.jk = jk;
        this.noTelp = noTelp;
    }

    public Pelanggan getByNama(String keyword) {
        Pelanggan plg = new Pelanggan();
        ResultSet rs = DBHelper.selectQuery("Select * From pelanggan where nama_pelanggan ='" + keyword + "'");
//        System.out.println("Select * From pelanggan where nama_pelanggan ='" + keyword + "'");
        try {
            while (rs.next()) {
                plg = new Pelanggan();

                plg.setIdPelanggan(rs.getInt("id_pelanggan"));
//                System.out.print(rs.getInt("id_pelanggan"));
                plg.setNamaPelanggan(rs.getString("nama_pelanggan"));
                plg.setNoTelp(rs.getString("notelp"));
                plg.setAlamat(rs.getString("alamat"));
                plg.setJk(rs.getString("jk"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        System.out.print(plg.getIdPelanggan());
        return plg;

    }

    public Pelanggan getById(int id) {
        Pelanggan plg = new Pelanggan();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM pelanggan " + "WHERE id_pelanggan = '" + id + "'");

        try {
            while (rs.next()) {
                plg = new Pelanggan();

                plg.setIdPelanggan(rs.getInt("id_pelanggan"));
                plg.setNamaPelanggan(rs.getString("nama_pelanggan"));
                plg.setNoTelp(rs.getString("notelp"));
                plg.setAlamat(rs.getString("alamat"));
                plg.setJk(rs.getString("jk"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return plg;
    }

    public ArrayList<Pelanggan> getAll() {
        ArrayList<Pelanggan> ListPelanggan = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("Select * From pelanggan");

        try {
            while (rs.next()) {
                Pelanggan plg = new Pelanggan();
                plg.setIdPelanggan(rs.getInt("id_pelanggan"));
                plg.setNamaPelanggan(rs.getString("nama_pelanggan"));
                plg.setNoTelp(rs.getString("notelp"));
                plg.setAlamat(rs.getString("alamat"));
                plg.setJk(rs.getString("jk"));

                ListPelanggan.add(plg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListPelanggan;
    }

    public ArrayList<Pelanggan> search(String keyword) {
        ArrayList<Pelanggan> ListPelanggan = new ArrayList();

        String sql = "Select * FROM pelanggan WHERE "
                + " nama_pelanggan LIKE '%" + keyword + "%'"
                + " OR notelp LIKE '%" + keyword + "%' "
                + " OR alamat LIKE '%" + keyword + "%' "
                + " OR jk LIKE '%" + keyword + "%' ";

        ResultSet rs = DBHelper.selectQuery(sql);

        try {
            while (rs.next()) {
                Pelanggan plg = new Pelanggan();
                plg.setIdPelanggan(rs.getInt("id_pelanggan"));
                plg.setNamaPelanggan(rs.getString("nama_pelanggan"));
                plg.setNoTelp(rs.getString("notelp"));
                plg.setAlamat(rs.getString("alamat"));
                plg.setJk(rs.getString("jk"));

                ListPelanggan.add(plg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListPelanggan;
    }

    @Override
    public void save() {
        if (getById(idPelanggan).getIdPelanggan() == 0) {
            String SQL = "INSERT INTO pelanggan (nama_pelanggan,alamat,notelp,jk) VALUES("
                    + "     '" + this.namaPelanggan + "', "
                    + "     '" + this.alamat + "', "
                    + "     '" + this.noTelp + "', "
                    + "     '" + this.jk + "' "
                    + "     )";
            this.idPelanggan = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE pelanggan SET "
                    + "     nama_pelanggan = '" + this.namaPelanggan + "', "
                    + "     alamat = '" + this.alamat + "', "
                    + "     notelp = '" + this.noTelp + "', "
                    + "     jk = '" + this.jk + "' "
                    + "     WHERE id_pelanggan = '" + this.idPelanggan + "'";
//            System.out.print(SQL);
            DBHelper.executeQuery(SQL);
        }
    }

    @Override
    public void delete() {
        String SQL = "DELETE FROM pelanggan WHERE id_pelanggan = '" + this.idPelanggan + "'";
        DBHelper.executeQuery(SQL);
    }

    public int getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

}
