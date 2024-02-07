package replace_Method;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    
    var values = new ArrayList<>(List.of(3,5,7,9,8,12));
    
    values.replaceAll(n -> n*n);
    
    values.forEach(System.out::println);
    
    
    
    var names = new ArrayList<>(List.of("Maya","Bob","Charlie","Ottie"));
    
    names.replaceAll(name -> "hi! " + name);
    
    names.forEach(System.out::println);

  }

}
