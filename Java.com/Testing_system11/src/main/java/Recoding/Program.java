package Recoding;

import Recoding.Controler;
import Recoding.Group;

import java.sql.SQLException;
import java.util.List;

public class Program {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       Controler groupcontroler = new Controler();
        List<Group> arrayList = groupcontroler.getlissGroup();
        for (Group grp:arrayList) {
            System.out.println(grp);
        }
    }
}
