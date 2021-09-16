package Hoc_Record;

import java.util.Comparator;

public class compare  implements Comparator<Program> {

    @Override
    public int compare(Program a, Program b) {
        return a.name.compareTo(b.name);
    }

}
