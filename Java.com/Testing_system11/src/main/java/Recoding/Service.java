package Recoding;

import Recoding.Group;
import Recoding.Repository;

import java.sql.SQLException;
import java.util.List;

public class Service {
    private Repository repository;
    public Service() {
        repository = new Repository();
    }
    public List<Group> getlissGroup() throws SQLException, ClassNotFoundException {
        return  repository.getlissGroup();
    }
}
