package Controller;

import Model.App;
import Model.Pegawai;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.HomeAdmin;
import view.HomePegawai;

public class Controllerihomepegawai implements  ActionListener{
    private App model;
    private HomePegawai view;
    private Pegawai pg;

    public Controllerihomepegawai(App model,Pegawai pg) {
        this.model = model;
        this.view = new  HomePegawai();
        view.setVisible(true);
        view.addactionlistener(this);
//        view.setSize(1000,700);
        this.pg= pg;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object x= ae.getSource();
        if (x.equals(view.getlihattransaksi())){
            Controllerliatjualbeli lt= new Controllerliatjualbeli(model, pg);
            view.setVisible(false);
        }else if (x.equals(view.getinputtransaksi())){
            Controllerinputjualbeli it= new Controllerinputjualbeli(model, pg);
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
