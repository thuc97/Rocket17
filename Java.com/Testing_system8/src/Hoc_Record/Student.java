package Hoc_Record;

public class Student<T> {
    public static void main(String[] args) {
        check();

    }
    public static void check() {
        Integer[] intArray = { 1, 5, 2, 7, 8 };
        Float[] floatArray = { 1.2f, 5.3f, 2f, 7.8f, 8.2f };
        Double[] doubleArray = { 1.2, 5.3, 2.2, 7.8, 8.2 };
        printByE_Type(intArray);
        printByE_Type(floatArray);
        printByE_Type(doubleArray);

    }
        private static <T > void printByE_Type(T[] arr){
            System.out.println("Phần tử trong mảng là: ");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println(" ");
        }
    }
