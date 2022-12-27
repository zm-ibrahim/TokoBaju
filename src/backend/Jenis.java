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
public class Jenis implements IFeature{
    private int idjenis;
    private String keterangan, namaJenis;
    
    public Jenis(){
    
    }
    
    public Jenis (String namaJenis, String keterangan){
        this.namaJenis = namaJenis;
        this.keterangan = keterangan;
    }
    
    public Jenis getById(int id) {
        Jenis jen = new Jenis();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM jenis " + "WHERE id_jenis = '" + id + "'");
        
        try{
                while(rs.next()){
                    jen = new Jenis();
                    jen.setIdjenis(rs.getInt("id_jenis"));
                    jen.setNamaJenis(rs.getString("nama_jenis"));
                    jen.setKeterangan(rs.getString("keterangan"));
                }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return jen;
    }
    
    public Jenis getByNama(String keyword){
         Jenis jen = new Jenis();
         ResultSet rs = DBHelper.selectQuery("Select * From jenis where nama_jenis ='"+ keyword+"'");
         try{
                while(rs.next()){
                    jen = new Jenis();
                    jen.setIdjenis(rs.getInt("id_jenis"));
                    jen.setNamaJenis(rs.getString("nama_jenis"));
                    jen.setKeterangan(rs.getString("keterangan"));
                }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return jen;
         
    }
    
    public ArrayList<Jenis> getAll(){
        ArrayList<Jenis> ListJenis = new ArrayList();
        
        ResultSet rs = DBHelper.selectQuery("Select * From jenis");
        
        try{
            while(rs.next()){
                Jenis jen = new Jenis();
                jen.setIdjenis(rs.getInt("id_jenis"));
                jen.setNamaJenis(rs.getString("nama_jenis"));
                jen.setKeterangan(rs.getString("keterangan"));
                
                ListJenis.add(jen);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ListJenis;
    }
    
    public ArrayList<Jenis> search(String keyword){
        ArrayList<Jenis> ListJenis = new ArrayList();
        
        String sql = "Select * FROM jenis WHERE "
                    + " nama_jenis LIKE '%" + keyword + "%'"
                    + " OR keterangan LIKE '%" + keyword + "%' ";
        
        ResultSet rs = DBHelper.selectQuery(sql);
        
        try{
            while(rs.next()){
                Jenis jen = new Jenis();
                jen.setIdjenis(rs.getInt("id_jenis"));
                jen.setNamaJenis(rs.getString("nama_jenis"));
                jen.setKeterangan(rs.getString("keterangan"));
                
                ListJenis.add(jen);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return ListJenis;
    }

    @Override
    public void save() {
        if(getById(idjenis).getIdjenis()== 0){
            String SQL = "INSERT INTO jenis (nama_jenis,keterangan) VALUES("
                        + "     '" + this.namaJenis +"', "
                        + "     '" + this.keterangan + "' "
                        + "     )";
            this.idjenis = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE jenis SET "
                    + "     nama_jenis = '" + this.namaJenis + "', "
                    + "     keterangan = '" + this.keterangan + "' "
                    + "     WHERE id_jenis = '" + this.idjenis + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    @Override
    public void delete() {
        String SQL = "DELETE FROM jenis WHERE id_jenis = '" + this.idjenis + "'";
        DBHelper.executeQuery(SQL);
    }

    public int getIdjenis() {
        return idjenis;
    }

    public void setIdjenis(int idjenis) {
        this.idjenis = idjenis;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getNamaJenis() {
        return namaJenis;
    }

    public void setNamaJenis(String namaJenis) {
        this.namaJenis = namaJenis;
    }
    
    
    
}
