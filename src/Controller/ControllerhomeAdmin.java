package Controller;

import Model.App;
import Database.Database;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.HomeAdmin;

public class ControllerhomeAdmin implements ActionListener{

    
    private HomeAdmin view;
    private App model;
    private Database db;

    public ControllerhomeAdmin( App model) {
        view = new HomeAdmin();
        view.setVisible(true);
//        view.setSize(1000,700);
        view.addactionlistener(this);
        this.model = model;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object x = ae.getSource();
        if (x.equals(view.getinput())){
            ControllerinputPegawai I= new ControllerinputPegawai(model);
            view.setVisible(false);
        }else if (x.equals(view.getlihatpegawai())){
            Controllerlihatpegawai L= new Controllerlihatpegawai(model);
            view.setVisible(false);
        }else if (x.equals(view.getinputobat())){
            Controllerinputobat IO= new Controllerinputobat(model,null);
            view.setVisible(false);
        }else if (x.equals(view.getlihatobat())){
            Controllerlihatobat lo= new Controllerlihatobat(model,null);
            view.setVisible(false);
        }else if (x.equals(view.getinputpembeli())){
            Controllerinputpembeli ip=new Controllerinputpembeli(model);
            view.setVisible(false);
        }else if (x.equals(view.getlihatpembeli())){
            Controllerlihatpembeli lp= new Controllerlihatpembeli(model);
            view.setVisible(false);            
        }else if (x.equals(view.getlihattransaksi())){
            Controllerliattransaksi t= new Controllerliattransaksi(model,null);
            view.setVisible(false);
        }else if (x.equals(view.getLogout())){
            Controllerhomelogin h= new Controllerhomelogin(model);
            view.setVisible(false);
        }else if(x.equals(view.getinputdistributor())){
            Controllerinputdistributor ih=new Controllerinputdistributor(model);
            view.setVisible(false);  
        }else if (x.equals(view.getlihatdistributor())){
            Controllerlihatdistributor ld=new Controllerlihatdistributor(model);
            view.setVisible(false);
        }else if(x.equals(view.getliatrestock())){
            Controllerlihatrestock lr= new Controllerlihatrestock(model, null);
            view.setVisible(false);
        };
    }
    
    
    
}
