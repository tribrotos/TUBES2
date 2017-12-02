
package Model;

import Model.Jualbeli;
import Model.Obat;
import Model.Pembeli;
import Model.Person;
import java.util.ArrayList;
import java.util.List;

public class Pegawai extends Person{
    private int idpegawai;
    private String nama;
    private int shift;
    private String jabatan;
    private double gaji;
    private String Password;
    private String username;

    private List<Jualbeli> datajualbeli;

    public Pegawai(int idpegawai, String nama, int shift, double gaji, String password) {
        this.idpegawai = idpegawai;
        this.nama = nama;
        this.shift = shift;
        this.gaji = gaji;
        this.Password=password;
        this.datajualbeli=new ArrayList();
    }

    public Pegawai(String nama, int shift, double gaji, String Password) {
        this.nama = nama;
        this.shift = shift;
        this.gaji = gaji;
        this.Password = Password;
    }

    public Pegawai(int idpegawai) {
        this.idpegawai = idpegawai;
    }
    
    public Pegawai() {
    }

    public List<Jualbeli> getDatajualbeli() {
        return datajualbeli;
    }
    
   
    public void Createjualbeli(Pembeli p,List<Obat> obat,int jumlah,int harga){
       
        Jualbeli j= new Jualbeli(p, this, obat,jumlah,harga );
        this.datajualbeli.add(j);
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPassword() {
        return Password;
    }
    
    public void Lihatdatapegawai() {
        System.out.println(toString());
        
//        for (Restock r : datarestock) {
//            System.out.println(r.toString());
//        }    
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setGaji(double gaji) {
        this.gaji = gaji;
    }

    public void setIdpegawai(int idpegawai) {
        this.idpegawai = idpegawai;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public double getGaji() {
        return gaji;
    }

    public int getIdpegawai() {
        return idpegawai;
    }

    public String getJabatan() {
        return jabatan;
    }

    public String getNama() {
        return nama;
    }

    public int getShift() {
        return shift;
    }

//    @Override
//    public String toString() {
//       String temp="";
//       for (Restock r : datarestock) {
//            temp+=r.toString();
//        }
//        return "idpegawai :"+idpegawai+"\nnama :"+nama+"\njabatan :" +jabatan + "\ngaji "+gaji+"\n "+temp;
//     }
    
    
}
