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
public abstract class Pembayaran{
    String namaBayar;
    int idBayar, nominal;
    Pelanggan pelanggan;
    String tipeBayar;
    
    public Pembayaran(){}
    
    public Pembayaran(Pelanggan pelanggan, String namaBayar, String tipeBayar, int nominal){
        this.pelanggan = pelanggan;
        this.namaBayar = namaBayar;
        this.tipeBayar = tipeBayar;
        this.nominal = nominal;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan Pelanggan) {
        this.pelanggan = pelanggan;
    }

    
    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public String getTipeBayar() {
        return tipeBayar;
    }

    public void setTipeBayar(String tipeBayar) {
        this.tipeBayar = tipeBayar;
    }
    
    

    public int getIdBayar() {
        return idBayar;
    }

    public void setIdBayar(int idBayar) {
        this.idBayar = idBayar;
    }

    public String getNamaBayar() {
        return namaBayar;
    }

    public void setNamaBayar(String namaBayar) {
        this.namaBayar = namaBayar;
    }
    
    public abstract void save();
    public abstract void delete();

}
