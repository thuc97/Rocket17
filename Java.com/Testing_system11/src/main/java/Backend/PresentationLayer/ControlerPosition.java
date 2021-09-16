package Backend.PresentationLayer;
import Backend.BussinessLayer.ServicePostiotn;
import entity.Position2;

import java.sql.SQLException;
import java.util.List;
public class ControlerPosition {
    private ServicePostiotn service;
    public ControlerPosition() {
        service = new ServicePostiotn();
    }
    public void creatable() throws SQLException, ClassNotFoundException {
        service.creatable();
    }
    public   List<Position2> getlissposition() throws SQLException, ClassNotFoundException {
        List<Position2>arrayList =service.getlissposition();
        for (Position2 position :arrayList) {
            System.out.println(position.toString());
        }
        return service.getlissposition();
    }
    public void insertsposition() throws SQLException, ClassNotFoundException {
        service.insertsposition();
    }
    public void updatesposition() throws SQLException, ClassNotFoundException {
        service.updatesposition();
    }
    public void deleteposition()throws SQLException, ClassNotFoundException {
        service.deleteposition();
    }
    public void findposition() throws SQLException, ClassNotFoundException {
        service.findposition();
    }

}