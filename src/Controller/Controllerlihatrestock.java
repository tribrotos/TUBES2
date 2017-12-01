
package Controller;

import Database.Database;
import Model.App;
import Model.Pegawai;
import Model.Person;
import Model.Restock;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import view.Lihatrestock;

/**
 *
 * @author nanang saiful
 */
public class Controllerlihatrestock implements ActionListener{
    private App model;
    private Lihatrestock view;
    private Database db;
    private Person pg;
    private List<Restock> datarestock;

    public Controllerlihatrestock(App model ,Person pg) {
        this.model = model;
        this.view =new Lihatrestock();
        view.setVisible(true);
        view.addactionListener(this);
        this.db = new Database();
        this.db.connect();
        this.pg = pg;
        this.datarestock=db.loadrestock(this.model);
        view.viewall(datarestock);
//        view.setSize(1000,700);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object x= ae.getSource();
        if(x.equals(view.getbtnback())){
            if(pg instanceof  Pegawai ){
            Controllerihomepegawai hp=new Controllerihomepegawai(model, (Pegawai) pg);
            view.setVisible(false);
            }else{
            ControllerhomeAdmin ha= new ControllerhomeAdmin(model);
            view.setVisible(false);
            }
        }
    }
    
}
