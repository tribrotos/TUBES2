/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.App;
import Model.Obat;
import Model.Pegawai;
import Model.Pembeli;
import Model.Person;
import Database.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import view.Inputtransaksi;

/**
 *
 * @author nanang saiful
 */
public class Controllerinputtransaksi implements ActionListener{
    private Inputtransaksi view;
    private App model;
    private List<Obat> obats;
    private int harga;
    private int jumlah;
    private Pegawai pg;
    private Database db;
    
    public Controllerinputtransaksi( App model,Pegawai pg) {
        this.view = new Inputtransaksi();
        view.addactionlistener(this);
        view.setVisible(true);
        this.model = model;
        this.obats=new ArrayList();
        view.viewall(obats);
        view.setharga("0");
        view.settotal("0");
        this.pg=pg;
    }
    public Controllerinputtransaksi( App model) {
        this.view = new Inputtransaksi();
        view.addactionlistener(this);
        view.setVisible(true);
        this.model = model;
        this.obats=new ArrayList();
        view.viewall(obats);
//        view.setSize(1000,700);
        view.setharga("0");
        view.settotal("0");
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object x = ae.getSource();
        
        if(x.equals(view.gettambah())){
            int id =view.getid();
            Obat o1 =new Obat();
            o1=model.cariobat(id);
            if (o1!=null){
                if (o1.getJumlah()>view.getjumlah()){
                    Obat o= new Obat();
                    o.setNama(o1.getNama());
                    o.setJenisobat(o1.getJenisobat());
                    o.setIdobat(o1.getIdobat());
                    o.setJumlah(view.getjumlah());
                    o.setHarga(view.getjumlah()*o1.getHarga());
                    view.settotal(String.valueOf(o.getJumlah()+view.gettotal()));
                    view.setharga(String.valueOf(o.getHarga()+view.getharga()));
                    o1.setJumlah(o1.getJumlah()-view.getjumlah());
                    this.obats.add(o);
                }else {
                JOptionPane.showMessageDialog(null," obat tidak cukup");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Data tidak di temukan");
            }            
            view.viewall(obats);
            view.refresh("");
        }else if(x.equals(view.gethome())){
            Controllerihomepegawai h= new Controllerihomepegawai(model,pg);
            view.setVisible(false);
        }else if(x.equals(view.getbayar())){
            if (view.getidpembeli()==0){
                JOptionPane.showMessageDialog(null, "idpembeli haru di isi");
            }else{
            Pembeli pbl=new  Pembeli();
            pbl=model.caripembeli(view.getidpembeli());
            model.tambahtransaksi(this.pg, pbl, obats, view.gettotal(), view.getharga());
            view.allrefresh("");
            JOptionPane.showMessageDialog(null, "telah terbayar");
            obats.removeAll(obats);
            view.viewall(obats);
            
            }
        }
        
        
        
    }
    
}
