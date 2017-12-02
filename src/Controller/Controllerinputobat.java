package Controller;

import Controller.ControllerhomeAdmin;
import Controller.Controllerihomepegawai;
import Model.App;
import Model.Obat;
import Model.Pegawai;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.Inputobat;
import view.Inputpegawai;

public class Controllerinputobat implements ActionListener{
    private Inputobat view;
    private App model;
    private Pegawai pg;

    public Controllerinputobat(App model,Pegawai pg) {
        view = new Inputobat();
        view.setVisible(true);
        view.addactionlistener(this);
//        view.setSize(1000,700);
        this.model = model;
        this.pg=pg;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       Object x=ae.getSource();
       if (x.equals(view.getbtndone())){
        if(view.getNama().equals("")||view.getJenisObat().equals("")||view.getHarga()==0||view.getJumlah()==0){
            JOptionPane.showMessageDialog(null, "Semua data harus di isi");
        }else{
            String nama= view.getNama();
            String jenis= view.getJenisObat();
            int harga= view.getHarga();
            int jumlah = view.getJumlah();
            Obat o= new Obat();
            o.setHarga(harga);
            o.setNama(nama);
            o.setJenisobat(jenis);
            o.setJumlah(jumlah);
            model.Masukkanobat(o);
            JOptionPane.showMessageDialog(null, "data telah terinputkan");
        }
       }else if (x.equals(view.gethome())){
            if (pg instanceof  Pegawai){
             Controllerihomepegawai hp= new Controllerihomepegawai(model, pg);
             view.setVisible(false);
                }else{
           ControllerhomeAdmin h= new ControllerhomeAdmin(model);
           view.setVisible(false);
            }
       }
       view.refresh("");
    }
    
}
