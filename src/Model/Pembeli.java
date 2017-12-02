package Model;

public class Pembeli extends Person{
   private String noHp; 

    public Pembeli(int id, String nama,String noHp) {
        this.id = id;
        this.nama = nama;
        this.noHp=noHp;
    }

    public Pembeli() {
       
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }
    
    @Override
    public String toString() {
        return "id  :"+id +"\nnama : "+nama; //To change body of generated methods, choose Tools | Templates.
    }
    

}
