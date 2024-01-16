import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Stream;
import java.util.Optional;

public class main {
    public static void main(String[] args) {
        ArrayList <Double> list  = new ArrayList<>();
        list.add(5.4);
        list.add(1.2);
        Optional <Double> opt = list.stream().sorted().findFirst();
        System.out.println(opt.get()+ """
                
                """+ list.get(0));

    }    
}
