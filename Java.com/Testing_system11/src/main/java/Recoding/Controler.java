package Recoding;

import Recoding.Group;
import Recoding.Service;

import java.sql.SQLException;
import java.util.List;

public class Controler {
    private Service groupservice;
    public Controler() {

        groupservice = new Service();
    }
    public List<Group> getlissGroup() throws SQLException, ClassNotFoundException {
        return groupservice.getlissGroup();
    }


}
