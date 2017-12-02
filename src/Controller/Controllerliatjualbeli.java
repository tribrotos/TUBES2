
package Controller;

import Model.App;
import Model.Jualbeli;
import Model.Pegawai;
import Database.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;
import view.LihatJualbeli;

public class Controllerliatjualbeli extends MouseAdapter implements ActionListener{
    private LihatJualbeli view;
    private App model;
    private Database db;
    private Pegawai pg;
    
    public Controllerliatjualbeli( App model,Pegawai pg) {
        this.db=new Database();
        this.db.connect();
        this.pg=pg;
        this.view = new LihatJualbeli();
        view.addactionListener(this);
        view.addAdapter(this);
        view.setVisible(true);
        this.model = model;
        ArrayList<Jualbeli> n= db.loadtransaksi(this.model);
        view.viewall(n);        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
     Object x=ae.getSource();
     if (x.equals(view.getbtnback())){
         if (pg instanceof  Pegawai){
             Controllerihomepegawai hp= new Controllerihomepegawai(model, pg);
             view.setVisible(false);
         }else{
            ControllerhomeAdmin h= new ControllerhomeAdmin(model);
            view.setVisible(false); 
         }
     }
    
    }
    
}
