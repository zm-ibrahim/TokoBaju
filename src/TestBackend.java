/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import backend.*;
/**
 *
 * @author IBRAHIM
 */
public class TestBackend {
    public static void main(String[]args){
//        Debit dbt = new Debit("BCA", 80000);
//        Debit dbt2 = new Debit("BSI", 800000);
        Pelanggan plg = new Pelanggan("Ucok", "080121", "adsada","jk" );
//        Pelanggan plg2 = new Pelanggan("Ucok", "Alamat", "LK","081212", dbt2 );
        
        plg.save();
//        plg2.save();
        plg.getIdPelanggan();
        
    }
}
