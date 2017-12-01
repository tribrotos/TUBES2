package Controller;

import Model.App;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import view.Lihatpembeli;

public class Controllerlihatpembeli extends MouseAdapter implements ActionListener{
    private Lihatpembeli view;
    private App model;

    public Controllerlihatpembeli( App model) {
        this.view =new Lihatpembeli() ;
        view.addactionListener(this);
        view.setVisible(true);
        view.addAdapter(this);
        this.model = model;
//        view.setSize(1000,700);
        view.viewall(model.getDatapembeli());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object x= ae.getSource();
        if (x.equals(view.getbtnback())){
            ControllerhomeAdmin h= new ControllerhomeAdmin(model);
            view.setVisible(false);
        }
    }
     
}
