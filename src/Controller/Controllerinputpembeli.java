package Controller;

import Model.App;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Inputpembeli;
import Model.Pembeli;
import javax.swing.JOptionPane;

public class Controllerinputpembeli implements  ActionListener{

    private Inputpembeli view;
    private  App model;

    public Controllerinputpembeli( App model) {
        this.view = new Inputpembeli();
        view.setVisible(true);
        view.addActionlistener(this);
//        view.setSize(1000,700);
        this.model = model;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object x= ae.getSource();
        if (x.equals(view.getJBDone())){
            if (view.getNama().equals("")){
                JOptionPane.showMessageDialog(null, "Semua data harus di isi");
            }else {
            String nama=view.getNama();
            String noHp=view.getNoHp();
            Pembeli p= new Pembeli();
            p.setNama(nama);
            p.setNoHp(noHp);
             model.masukkanDataPembeli(p);
             JOptionPane.showMessageDialog(null, "data telah terinputkan");
            }
        }else if(x.equals(view.getHome())){
            ControllerhomeAdmin h= new ControllerhomeAdmin(model);
            view.setVisible(false);
        }
        view.refresh("");
    }
    
}
