package Backend.BussinessLayer;
import Backend.RepositoryLayer.RepositoryPosition;
import entity.Position2;
import java.sql.SQLException;
import java.util.List;

public class ServicePostiotn {
  public RepositoryPosition repository;

    public ServicePostiotn() {
        repository = new RepositoryPosition();
    }
    public  void creatable() throws SQLException, ClassNotFoundException {
        repository.creatable();
    }
    public   List<Position2> getlissposition() throws SQLException, ClassNotFoundException {
        return repository.getlissposition();
    }

    public   void insertsposition() throws SQLException, ClassNotFoundException {
        repository.insertsposition();
    }

    public  void updatesposition() throws SQLException, ClassNotFoundException {
        repository.updatesposition();
    }

    public   void deleteposition() throws SQLException, ClassNotFoundException {
        repository.deleteposition();
    }

    public void findposition() throws SQLException, ClassNotFoundException {
        repository.findposition();
    }

}