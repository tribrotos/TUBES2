
package Controller;

import Controller.ControllerhomeAdmin;
import Controller.Controllerihomepegawai;
import Model.App;
import Model.Pegawai;
import Model.Pembeli;
import Model.Person;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Lihatobat;

public class Controllerlihatobat implements  ActionListener{
    private Lihatobat view;
    private App model;
    private Person p;

    public Controllerlihatobat(App model, Person p) {
        this.view = new Lihatobat();
        this.p=p;
        view.setVisible(true);
//        view.setSize(1000,700);
        view.addactionListener(this);
        this.model = model;
        view.viewall(model.getDataobat());
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object x= ae.getSource();
        if(x.equals(view.getbtnback())){
             if (this.p instanceof Pegawai ){
                Controllerihomepegawai hp = new Controllerihomepegawai(model, (Pegawai ) this.p);
                view.setVisible(false);
            }else{
                ControllerhomeAdmin h= new ControllerhomeAdmin(model);
                view.setVisible(false);
            }
        }
    }
    
}
