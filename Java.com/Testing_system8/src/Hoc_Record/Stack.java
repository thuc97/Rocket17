package Hoc_Record;
public class Stack {

    public static void main(String[] args) {
//push();
//pop();
peek();
//search();
    }

public static void push(){
 //   Để thêm một phần tử vào đầu stack, chúng ta sử dụng hàm push(). Ví dụ,

  java.util.Stack<String> animals= new java.util.Stack<>();
    // Add elements to Stack
    animals.push("Dog");
    animals.push("Horse");
    animals.push("Cat");
    animals.push("Cat");
    System.out.println(animals);

}
 //Để loại bỏ một phần tử khỏi đỉnh stack tức là vị trí cuối cùng,
 // chúng ta sử dụng hàm  pop(). Ví dụ,
public static  void  pop(){
    java.util.Stack<String> animals= new java.util.Stack<>();
    // Add elements to Stack
    animals.push("Dog");
    animals.push("Horse");
    animals.push("Cat");
    animals.push("vit");
    System.out.println(animals);
    String element = animals.pop();
    System.out.println("Removed Element: " + element);
    System.out.println(animals);
}

public static  void  peek(){
 //   Các hàm peek() trả về đối tượng ở phía trên cùng của stack. Ví dụ,
    java.util.Stack<String> animals= new java.util.Stack<>();
    animals.push("Dog");
    animals.push("Horse");
    animals.push("Cat");
    animals.push("vit");
    String element = animals.peek();
    System.out.println("Element at top: " + element);
    System.out.println(animals);
}
//Để tìm kiếm một phần tử trong stack, chúng ta sử dụng hàm search().
// Nó trả về vị trí của phần tử ở đỉnh stack. Ví dụ,
public static  void search(){

    java.util.Stack<String> animals= new java.util.Stack<>();
    animals.push("Dog");
    animals.push("Horse");
    animals.push("Cat");
    animals.push("vit");
    int position = animals.search("Dog");
    System.out.println("Element at top: " + position);
}









}
