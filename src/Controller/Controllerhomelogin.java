package Controller;

import Model.App;
import Model.Distributor;
import Model.Pegawai;
import Model.Pembeli;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.HomeAdmin;
import view.Homelogin;

public class Controllerhomelogin implements ActionListener{
    private Homelogin view;
    private App model;

    public Controllerhomelogin( App model) {
        this.view = new Homelogin();
        view.addactionlistener(this);
        view.setVisible(true);
//        view.setSize(1000,700);
        this.model = model;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
       Object x=ae.getSource();
       if (x.equals(view.getadmin())){
           if ((view.getid()==1) &&(view.getpassword().equals("123"))){
               ControllerhomeAdmin ha= new ControllerhomeAdmin(model);
               view.setVisible(false);
           }else{
               JOptionPane.showMessageDialog(null, "password atau id salah");
           }
       }else if (x.equals(view.getPegawai())){
           Pegawai pg=new Pegawai();
           pg= model.caripegawai(view.getid());
           if (pg!=null){
               if (pg.getPassword().equals(view.getpassword())){
                   Controllerihomepegawai p = new  Controllerihomepegawai(model,pg);
                   view.setVisible(false);
               }
           }else{
                JOptionPane.showMessageDialog(null, "password atau id salah");
           }
       }
       view.refresh("");
    }
    
    
}
