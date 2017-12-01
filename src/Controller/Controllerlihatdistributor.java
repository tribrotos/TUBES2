package Controller;

import Model.App;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import view.LihatPegawai;
import view.Lihatdistributor;

public class Controllerlihatdistributor extends MouseAdapter  implements ActionListener{
    private App model;
    private Lihatdistributor view;

    public Controllerlihatdistributor(App model) {
        view=new Lihatdistributor();
        view.setVisible(true);
        view.addAdapter(this);
        view.addListener(this);    
//        view.setSize(1000,700);
        this.model = model;
        view.viewall(model.getDataDistributors());
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object x = ae.getSource();
        if (x.equals(view.getbtnback())){
            ControllerhomeAdmin l= new ControllerhomeAdmin(model);
            view.setVisible(false);
        }
    }
    
}
