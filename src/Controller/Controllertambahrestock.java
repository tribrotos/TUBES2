package Controller;

import Model.App;
import Model.Distributor;
import Model.Obat;
import Model.Pegawai;
import Model.Person;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.Inputrestock;
import view.Inputtransaksi;

/**
 *
 * @author nanang saiful
 */
public class Controllertambahrestock implements  ActionListener{
    private App model;
    private Inputrestock view;
    private Person pg;
    public Controllertambahrestock(App model ,Person pg) {
        this.model = model;
        this.view = new Inputrestock();
        view.setVisible(true);
        view.addactionlistener(this);
        this.pg=pg;
//        view.setSize(1000,700);
    }
 
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object x=ae.getSource();
        if(x.equals(view.getJBDone())){
            if(view.getidobat()==0||view.getdistributor()==0||view.getjumlah()==0){
                JOptionPane.showMessageDialog(null,"data harus terisi semua");
            }else{
                Obat o= model.cariobat(view.getidobat());
                int y=view.getjumlah();
                Distributor d= model.caridistributor(view.getdistributor());      
                model.tambahRestock((Pegawai) pg, d, o,y);
                JOptionPane.showMessageDialog(null, "data telah terinputkan");
            }
        }else if(x.equals(view.gethome())){
            Controllerihomepegawai ch= new Controllerihomepegawai(model, (Pegawai) pg );
            view.setVisible(false);
        }
        view.refresh("");
    }
    
}
