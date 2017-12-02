package Controller;

import Controller.ControllerhomeAdmin;
import Model.App;
import Model.Pegawai;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import sun.print.PeekGraphics;
import view.HomeAdmin;
import view.Inputpegawai;

public class ControllerinputPegawai implements ActionListener{
    private Inputpegawai view;
    private App model;

    ControllerinputPegawai(App model) { 
      view = new Inputpegawai();
      view.setVisible(true);
      view.addactionlistener(this);
//      view.setSize(1000,700);
       this.model = model;//To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object x = ae.getSource();
        if (x.equals(view.getBtnDaftar())){
            if (view.getnama().equals("")||view.getgaji()==0||view.getshift()==0){ 
                JOptionPane.showMessageDialog(null, "Semua data harus di isi");
            }else{
            String nama=view.getnama();
            int shift=view.getshift();
            double gaji=view.getgaji();
            String password=view.getPasword();
            Pegawai p= new Pegawai(nama, shift, gaji, password);
            model.inputPegawai(p);
            JOptionPane.showMessageDialog(null, "data telah terinputkan");
            }
            
        }else if (x.equals(view.getBtnhome())){
            ControllerhomeAdmin h= new ControllerhomeAdmin(model);
            view.setVisible(false);
        };
        view.refresh("");
    }
}
