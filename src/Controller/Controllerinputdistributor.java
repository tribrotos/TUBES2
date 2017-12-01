
package Controller;

import Model.App;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.Inputdistributor1;

/**
 *
 * @author nanang saiful
 */
public class Controllerinputdistributor implements ActionListener{
    private App model;
    private Inputdistributor1 view;

    public Controllerinputdistributor(App model) {
        view = new Inputdistributor1();
        view.setVisible(true);
        view.addactionlistener(this);
//        view.setSize(1000,700);
        this.model = model;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object x = ae.getSource();
        if (x.equals(view.getJBDone())){
            if(view.getNama().equals("")||view.getAlamat().equals("")||view.getKontak().equals("")||view.getpass().equals("")){
                JOptionPane.showMessageDialog(null," data harus terisi semua");
            }else{
                String nama=view.getNama();
                String alamat=view.getAlamat();
                String Kontak=view.getKontak();
                String pass= view.getpass();
                model.masukkandatadistributor(nama, Kontak, alamat, pass);
                JOptionPane.showMessageDialog(null, "data telah terinputkan");
            }
            view.refresh("");
        }else if (x.equals(view.gethome())){
           ControllerhomeAdmin c=new ControllerhomeAdmin(model);
           view.setVisible(false);
        }
    }
    
}
