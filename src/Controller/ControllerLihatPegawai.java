package Controller;

import Model.App;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import view.LihatPegawai;

public class ControllerLihatPegawai extends MouseAdapter  implements ActionListener{
    private App model;
    private LihatPegawai view;

    public ControllerLihatPegawai(App model) {
        view=new LihatPegawai();
        view.setVisible(true);
        view.addAdapter(this);
        view.addListener(this);    
        this.model = model;
//        view.setSize(1000,700);
        view.viewall(model.getDatapegawai());
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
