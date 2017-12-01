package Controller;

import Model.App;
import Model.Pembeli;
import Model.Person;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Homepembeli;

public class Controllerhomepembeli implements ActionListener{
    private Homepembeli view;
    private App model;
    private Person p;

    public Controllerhomepembeli( App model, Person p) {
        this.view = new Homepembeli();
        this.model = model;
        view.setVisible(true);
//        view.setSize(1000,700);
        view.addActionListener(this);
        this.p = p;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
         Object x= ae.getSource();
         if (x.equals(view.getlihatpembeli())){
             Controllerlihatobat o= new Controllerlihatobat(model,p);
             view.setVisible(false);
         }else if(x.equals(view.getlogout())){
            Controllerhomelogin co= new Controllerhomelogin(model);
            view.setVisible(false);
         }
    }
    
}
