package Record;
public class Program {
    public static void main(String[] args) {

  Student student = new Student("nguyen van A");
//       student.getidd();
//        //System.out.println(student.getId());
      print(student);

    }
  public static void print  (Student student){
      System.out.println(student.getidd());
  }
}
