package Controller;

import Model.App;
import Model.Pegawai;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.HomeAdmin;
import view.HomeKasir;

public class Controllerihomepegawai implements  ActionListener{
    private App model;
    private HomeKasir view;
    private Pegawai pg;

    public Controllerihomepegawai(App model,Pegawai pg) {
        this.model = model;
        this.view = new  HomeKasir();
        view.setVisible(true);
        view.addactionlistener(this);
//        view.setSize(1000,700);
        this.pg= pg;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object x= ae.getSource();
        if (x.equals(view.getlihattransaksi())){
            Controllerliattransaksi lt= new Controllerliattransaksi(model, pg);
            view.setVisible(false);
        }else if (x.equals(view.getinputtransaksi())){
            Controllerinputtransaksi it= new Controllerinputtransaksi(model, pg);
            view.setVisible(false);
        }else if (x.equals(view.getlogout())){
            Controllerhomelogin h= new Controllerhomelogin(model);
            view.setVisible(false);
        }else if (x.equals(view.getinput())){
            Controllerinputobat io= new Controllerinputobat(model,pg);
            view.setVisible(false);
        }else if (x.equals(view.getlihatobat())){
            Controllerlihatobat lo= new Controllerlihatobat(model, pg);
            view.setVisible(false);
        }
    }
    
}
