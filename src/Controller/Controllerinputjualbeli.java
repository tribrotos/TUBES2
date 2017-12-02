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
import util.ComboItem;
import view.InputJualbeli;

/**
 *
 * @author nanang saiful
 */
public class Controllerinputjualbeli implements ActionListener{
    private InputJualbeli view;
    private App model;
    private List<Obat> obats;
    private List<Obat> listObat;
    private List<Pembeli> listPembeli;
    private int harga;
    private int jumlah;
    private Pegawai pg;
    private Database db;
    
    public Controllerinputjualbeli( App model,Pegawai pg) {
        this.view = new InputJualbeli();
        view.addactionlistener(this);
        view.setVisible(true);
        this.model = model;
        this.obats=new ArrayList();
        this.listObat=new ArrayList();
        this.listPembeli=new ArrayList();
        view.viewall(obats);
        view.setharga("0");
        view.settotal("0");
        this.pg=pg;
        initComboObat();
        initComboPembeli();
    }
    public Controllerinputjualbeli( App model) {
        this.view = new InputJualbeli();
        view.addactionlistener(this);
        view.setVisible(true);
        this.model = model;
        this.obats=new ArrayList();
        this.listObat=new ArrayList();
        this.listPembeli=new ArrayList();
        view.viewall(obats);
//        view.setSize(1000,700);
        view.setharga("0");
        view.settotal("0");
        initComboObat();
        initComboPembeli();
    }
    
    public void initComboObat(){
        listObat = model.getDataobat();
        
        for(Obat o: listObat){
            System.out.println("o " + o);
            view.getcomboobat().addItem(new ComboItem(o.getNama(), Integer.toString(listObat.indexOf(o))));
        }
        
    }
    
    public void initComboPembeli(){
        listPembeli = model.getDatapembeli();
        
        for(Pembeli p: listPembeli){
            view.getcombopembeli().addItem(new ComboItem(p.getNama(), Integer.toString(listPembeli.indexOf(p))));
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object x = ae.getSource();
        
        if(x.equals(view.gettambah())){
            int id =view.getid();
            
            Obat o1 =new Obat();
            o1 = listObat.get(id);
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
            
            Pembeli pbl=new  Pembeli();
            pbl= listPembeli.get(view.getidpembeli());
            model.tambahtransaksi(this.pg, pbl, obats, view.gettotal(), view.getharga());
            view.allrefresh("");
            JOptionPane.showMessageDialog(null, "telah terbayar");
            obats.removeAll(obats);
            view.viewall(obats);
            
        }
        
        
        
    }
    
}
